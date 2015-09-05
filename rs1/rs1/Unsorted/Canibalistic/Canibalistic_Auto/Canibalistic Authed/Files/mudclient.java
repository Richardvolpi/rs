import java.applet.Applet;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import javax.imageio.*;
import java.awt.image.*;
import java.text.*;


             
             //+x = goin west
             //+y = goin north
             //-x = goin east
             //-y = goin south
             //+x+y = goin northwest
             //+x-y = goin southwest
             //-x-y = goin southeast
             //-x+y = goin northeast

public final class mudclient extends b
{
    public int world;
    public String un = ""; 
    public String pw = "";
    public boolean autoLog = false;
    public boolean fow = true;
    public int serv;
    public String server;
    public int PlayerID;
    public int maxDist = 16 * 16;
    public boolean Lefty = true;
    public boolean box = true;   
    public boolean PlayerHP = false;    
    public boolean Notes = false;    
    public int SMode = 1;    
    public int FoodID = 373;  
    public String lastQuestMessage = "";
    public String lastServerMessage = "";      
    public int canDraw = 1;
    public boolean Disabled = false;    
    public String Username, Password;
    public String myPlayerLastSaid = "";
    public String lastTrader = "";    
    public script AutoFighter;    
    public boolean Fight = false;  
    public int npcID = 585;
    public int MacroTime = 500;
    public int sleepAt = 95;
    public boolean WalkBack = false;  
    public int WalkDis = 10; 
    public boolean WalkAway = false;
    public boolean Graphics = false;   
    public boolean loading = false;                
    public String lastPM = "";
    public String lastPMer = "";        
    public String lastChatter = "";
    public String lastChatMessage = "";  
    public auto AutoClicker;    
    public int Coords[] = new int[2];   
    public boolean Click;
    public int Command = 1;
    public boolean Mine;
    public mine AutoMiner;
    int RocksID[] = {110,111};
    public thieve AutoThiever;
    public boolean Thieve;
    public boolean AutoEat;
    public eat AutoEater;
    public int eatAt = 10;
    public int npcs[] = {585,586,593,592};
      
    
    public void setCameraMode(boolean to) {
       
            efb = to;
            aag.hdg(91);
            aag.heb(0);
            aag.heb(efb ? 1 : 0);
            aag.hde();
            
    }
    public void setMouseButtons(boolean to) {
       
            dek = to;
            aag.hdg(91);
            aag.heb(2);
            aag.heb(dek ? 1 : 0);
            aag.hde();
            
        
    }
    
    public void setSoundEffects(boolean to) {
      
            ejl = to;
            aag.hdg(91);
            aag.heb(3);
            aag.heb(ejl ? 1 : 0);
            aag.hde();                    
    }
    
    private class eat extends Thread {
    public void run() {
    while(AutoEat){   
    if(invCount(FoodID) > 0){ 
    if(getCurrentStat(3) <= eatAt && AutoEat && !inComb()){
    use(findSlot(FoodID));
    Wait(MacroTime);
    } else Wait(1);
    } else {    
    feb("@red@Canibalistic: @yel@No more food!",3);
    feb("@red@Canibalistic: @yel@Auto Eater Stopped",3);
    AutoEat = false;    					
    }     
    }
    }     
    eat() { start(); } 
    }
        
    public String getItemCmd(int type) {
        return e.amg[type];
    }
    
    private class thieve extends Thread {
    int startX = getX();
    int startY = getY();
    int npc;
    public void run() {
    while(Thieve) {
   if(fatigue() >= sleepAt)
       {
       use(findSlot(1263));
       Wait(3000);       
       while(sleeping()) 
       Wait(1);
       }
       if(WalkAway)
       {
       if(getX() - startX >= WalkDis || getY() - startY >= WalkDis)
       {
       Walk(startX,startY);
       Wait(100);
       }
       }
       if(getFightMode() != SMode)
       {
       setFightMode(SMode);
       }           
       if(!inComb() && fatigue() < sleepAt)
       {               
       int[] npc = GetNearestNPCID(npcID);     
       if(npc[0] != -1)
       {
       ThieveNPC(npc[0]);       
       Wait(MacroTime);
       }        
       else if (WalkBack && getX() != startX && getY() != startY) 
       {
       Walk(startX,startY);
       Wait(400);     
       }       
       else      
       Wait(1);
       }
       else 
       while(inComb()) { Walk(getX(),getY()); Wait(500); }       
       }
       }       
       thieve() { start(); } 
       }
    
    private class mine extends Thread {      
    public void run(){
    while(Mine){    
    if(fatigue() > 90){
       use(findSlot(1263));
       Wait(3000);       
       while(sleeping()) 
       Wait(1);
    }    
    while(invCount() < 30 && fatigue() <= 90 && Mine){
    int[] rocks = GetNearestObject(RocksID);
    if(rocks[0] != -1)
    {
    AtObject(rocks[1],rocks[2]);
    Wait(1000);
    }
    else     
    Wait(1);
    }
    if(invCount() == 30 && Mine)
    {       
    while(getY() > 2000){
    AtObject(274,3398);
    Wait(2500);
    }
    Walk(280,562);
    Wait(400);
    Walk(286,571);
    Wait(400);
    while(!questMenu() && Mine && invCount(155) > 0)
        	 { 
        	     int[] Npc = GetNearestNPCID(95);
        	     if(Npc[0] != -1)
        	        TalkToNPC(Npc[0]);
        	        Wait(1000);
                 }
                 Answer(0);
                 while (!Bank()) 
         		Wait(1); 
        while(invCount(155) > 0 && Mine) 
       {
       Deposit(155,1);
       Wait(200);
       }	
     	while(invCount(158) > 0 && Mine)
       {
       Deposit(158,1);
       Wait(200);
       }
	while(invCount(159) > 0 && Mine)
       {
       Deposit(159,1);
       Wait(200);
       }
	while(invCount(160) > 0 && Mine)
       {
       Deposit(160,1);
       Wait(200);
       }
       Walk(280,562);
       Wait(400);
       Walk(286,571);
       Wait(400);       
       while(getY() < 2000){
       AtObject(274,566);
       Wait(5000);
       }
       }
       }
       }
       mine() { start(); }
       }      
         		
    
    public void AtObject2(int x, int y) {
        x -= dil;
        y -= dim;
        
        for(int i = 0; i < djd; i++) {
            if(ebm[i] == x && ebn[i] == y) {
                    ObjectCommand2(i);
                    
            }        
        }
    }  
    public void ObjectCommand2(int idx) 
    {        
        try {
            dch[ehk] = 2400;
            eie[ehk] = ebm[idx];
            eif[ehk] = ebn[idx];
            dfm[ehk] = ecb[idx];
            dfn[ehk] = eca[idx];
            fal(ehk++);
         } catch(Exception e) {}
        
    }	 
    private class auto extends Thread {  
    public void run(){
    while(Click){
    if(Command == 1){
    AtObject(Coords[0],Coords[1]);
    Wait(MacroTime);
    }
    if(Command == 2){
    AtObject2(Coords[0],Coords[1]);
    Wait(MacroTime);
    }
    if(fatigue() > sleepAt){
       use(findSlot(1263));
       Wait(3000);       
       while(sleeping()) 
       Wait(1);
    }    
    }
    }
    auto() { start(); } 
    }
    
    
    public JFrame menuFrame;    
    public JPanel menuPanel;
    public JLabel macro1Lbl, macro2Lbl, macro3Lbl;    
    public JButton macro1Button, macro2Button, macro3Button;
    public boolean run_gui;
    
    public void GUI()
    {
    menuFrame = new JFrame("Menu Panel");
    menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
    
    JPanel menuPanel = new JPanel(new GridLayout(3, 2));  
    macro1Lbl = new JLabel("AutoClick: ");
    macro1Button = new JButton("ON/OFF");  
             
    macro1Button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            Click = !Click;
            if(Click)
             {
            AutoClicker = new auto();
           feb("@red@Canibalistic: @yel@AutoClick Started",3);
           feb("@red@Canibalistic: @yel@Coords: " + Coords[0] + ", " + Coords[1],3);
            }else       
              feb("@red@Canibalistic: @yel@Stopped AutoClicker",3);              
         }
        }
        ); 
    macro2Lbl = new JLabel("GuildMiner: ");
    macro2Button = new JButton("ON/OFF");  
    macro2Button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
                      Mine = !Mine;
            if(Mine)
             {
            AutoMiner = new mine();
           feb("@red@Canibalistic: @yel@GuildMiner Started",3);           
            }else       
              feb("@red@Canibalistic: @yel@Stopped GuildMiner",3);            
         }
        }
        ); 
    macro3Lbl = new JLabel("Thiever: ");
    macro3Button = new JButton("ON/OFF");  
    macro3Button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            Thieve = !Thieve;
            if(Thieve)
            {
            AutoThiever =  new thieve();
            feb("@red@Canibalistic: @yel@AutoThiever Started",3);           
            }
            else       
            feb("@red@Canibalistic: @yel@Stopped AutoThiever",3);           
         }
        }
        ); 
    menuPanel.add(macro1Lbl);
    menuPanel.add(macro1Button);
    menuPanel.add(macro2Lbl);
    menuPanel.add(macro2Button);
    menuPanel.add(macro3Lbl);
    menuPanel.add(macro3Button);
    menuFrame.getContentPane().add(menuPanel, BorderLayout.CENTER);
               
   menuFrame.pack();
   menuFrame.setVisible(true);
    }    
            
    public void attackPlayer(int idx) 
    {
    try{
            dch[ehk] = 805;
            eie[ehk] = ege[idx].gmh;
            eif[ehk] = ege[idx].gmi;
            dfm[ehk] = ege[idx].gmf;
            fal(ehk++);
              } catch(Exception e) {}
        
    }      
          
    public void Trade(int item[], int amount[]) 
    { 
    dkc = item; 
    dkd = amount; 
    dkb = item.length; 
    }
    public void UpdateTrade() 
    {
    aag.hdg(144); 
    aag.heb(dkb); 
    for (int i = 0; i < dkb; i++){
    aag.hdj(dkc[i]); 
    aag.hdn(dkd[i]); 
    } 
    aag.hde();      
    }
        
public int[] GetNearestObject(int id)
      {
    int min[] = {-1,-1,-1};
    int mint = Integer.MAX_VALUE;
    for(int j = 0; j < djd; j++)
        if(eca[j] == id)
        {
            int ObjectX = ebm[j] + dil; 
            int ObjectY = ebn[j] + dim; 
            int temp = Math.abs(ObjectX - getX()) + Math.abs(ObjectY - getY());
            if(temp < mint)
            {
                min[0] = j;
                min[1] = ObjectX;
                min[2] = ObjectY;
                mint = temp;
            }
        }
         return min;
}
public int[] GetNearestObject(int[] id)
      {
    int min[] = {-1,-1,-1};
    int mint = Integer.MAX_VALUE;
    for(int j = 0; j < djd; j++)
        if(InArray(id,eca[j]))
        {
            int ObjectX = ebm[j] + dil; 
            int ObjectY = ebn[j] + dim; 
            int temp = Math.abs(ObjectX - getX()) + Math.abs(ObjectY - getY());
            if(temp < mint)
            {
                min[0] = j;
                min[1] = ObjectX;
                min[2] = ObjectY;
                mint = temp;
            }
        }
         return min;
}

    public int[] GetNearestNPCID(int id)
      {
    int min[] = {-1,-1,-1};
    int mint = Integer.MAX_VALUE;
    for(int j = 0; j < dnj; j++)
        if(ddi[j].gmj == id && ddi[j].gml != 8 && ddi[j].gml != 9)
        {
            int NpcX = ((ddi[j].gmh - 64) / ecj) + dil;
            int NpcY = ((ddi[j].gmi - 64) / ecj) + dim;
            int temp = Math.abs(NpcX - getX()) + Math.abs(NpcY - getY());
            if(temp < mint)
            {
                min[0] = j;
                min[1] = NpcX;
                min[2] = NpcY;
                mint = temp;
            }
        }
         return min;
}
    
    public int[] GetNearestNPCID(int[] id)
      {
    int min[] = {-1,-1,-1};
    int mint = Integer.MAX_VALUE;
    for(int j = 0; j < dnj; j++)
        if(InArray(id,ddi[j].gmj) && ddi[j].gml != 8 && ddi[j].gml != 9)
        {
            int NpcX = ((ddi[j].gmh - 64) / ecj) + dil;
            int NpcY = ((ddi[j].gmi - 64) / ecj) + dim;
            int temp = Math.abs(NpcX - getX()) + Math.abs(NpcY - getY());
            if(temp < mint)
            {
                min[0] = j;
                min[1] = NpcX;
                min[2] = NpcY;
                mint = temp;
            }
        }
         return min;
}

public boolean InArray(int iarray[], int i)
{
    for(int a = 0;a < iarray.length;a++)
        if(iarray[a] == i)
           return true;
    return false;
}
    
        
    public void OpenDoor(int pos) { 
        fcd(dgk[pos],dgl[pos],eij[pos]); 
        aag.hdg(100); 
        aag.hdj(doorX(pos)); 
        aag.hdj(doorY(pos));
        aag.heb(pos); 
        aag.hde();
        }
    
    public int doorType(int pos)
     {
     return eik[pos]; 
     }
    public int doorX(int pos) 
    {
    return dgk[pos] + dil;
     }
    public int doorY(int pos)
     { 
    return dgl[pos] + dim; 
    }
    
    public int doorPathLength(int pos) 
    { 
    return getPathLength(doorX(pos),doorY(pos)); 
    }
    
    public int GetNearestDoor(int dis)
    {
       int door = -1;
       for(int j = 0; j < egn; j++)
       if(doorType(j) == 8 && doorPathLength(j) <= dis)
         door = j;
       return door;
    }
              
        
    public void SendPM(String msg,String player){
        if(msg.length() > 0)
            {       
                ekc = GetPlayerId(player);
                if(ekc == -1)
                  return;                      
                String s2 = msg;
                super.fkn = "";
                super.fla = "";
                efm = 0;
                int j1 = v.cek(s2);
                acl(ekc, v.ceg, j1);
                s2 = v.cej(v.ceg, 0, j1);
                s2 = u.fgd(s2);
                adg("@pri@You tell " + t.fnd(ekc) + ": " + s2);
            }
     }
     public long GetPlayerId(String name)
     {
      for(int j = 0; j < efg; j++)
        if(name.equalsIgnoreCase(t.fnd(aal[j]).trim()))
            return aal[j];
              return -1;
     }    
    public void Drop(int pos) { 
    aag.hdg(123); 
    aag.hdj(pos); 
    aag.hde();
    }      
    
    
    public void remove(int pos) { 
    aag.hdg(130); 
    aag.hdj(pos); 
    aag.hde(); 
    }
    
    public int itemAt(int x, int y) {
        x -= dil;
        y -= dim;
        
        for(int i = 0; i < dkm; i++) {
            if(ekj[i] == x && ekk[i] == y)
                return i;
        }
        
        return -1;
    }
    
    public void takeItemAt(int x, int y, int idx) {
        x -= dil;
        y -= dim;
        
        for(int i = 0; i < dkm; i++) {
            if(ekj[i] == x && ekk[i] == y && GetItemType(i) == idx) {
                    takeItem(i);
                    
            }        
        }
    } 
        
    public int GetNearestItem(int idx)
    {    
    int item = -1;
    int distance = 999999;
    for(int j = 0; j < dkm; j++)
    if (GetItemType(j) == idx && canReachItem(j)){
    int temp = itemPathLength(j) - distance;
    if(temp < distance){
        item = j;
        distance = temp;
       }
     }
     return item;
    }    
    public int GetItemType(int idx)
    {
    return ekl[idx];
    }    
    public void CloseBank() 
    { 
    aag.hdg(78); 
    aag.hde(); 
    emc = false; 
    }
    public void WaitForStuffToHappen() {   
    while(loading) Wait(10);   
    }  
    public int door;  
    private class script extends Thread {   
    int startX = getX();
    int startY = getY();
    int npc;
    public void run() {
    while(Fight) { 
       if(fatigue() >= sleepAt)
       {
       use(findSlot(1263));
       Wait(3000);       
       while(sleeping()) 
       Wait(1);
       }
       if(WalkAway)
       {
       if(getX() - startX >= WalkDis || getY() - startY >= WalkDis)
       {
       Walk(startX,startY);
       Wait(100);
       }
       }
       if(getFightMode() != SMode)
       {
       setFightMode(SMode);
       }           
       if(!inComb() && fatigue() < sleepAt)
       {               
       int[] npc = GetNearestNPCID(npcID);     
       if(npc[0] != -1)
       {
       if(!AttackNPC(npc[0]))
       feb("Couldnt find npc!",3);
       else
       Wait(MacroTime);
       }        
       else if (WalkBack && getX() != startX && getY() != startY) 
       {
       Walk(startX,startY);
       Wait(400);     
       }       
       else      
       Wait(1);
       }
       else 
       while(inComb())
       Wait(1);
       }
       }       
       script() { start(); } 
       }
       
    public void takeItem(int pos) 
    {     
    fdn(dgd, dge, ekj[pos], ekk[pos], true); 
    aag.hdg(253); 
    aag.hdj(ekj[pos] + dil); 
    aag.hdj(ekk[pos] + dim); 
    aag.hdj(ekl[pos]); 
    aag.hdj(0); 
    aag.hde(); 
     }
    public boolean AttackNPC(int pos) 
    { 
    WaitForStuffToHappen();
     if(dnj < pos) 
     return false; 
     ena(dgd,dge,(ddi[pos].gmh - 64) / ecj,(ddi[pos].gmi - 64) / ecj,true); 
     aag.hdg(118); 
     aag.hdj(ddi[pos].gmf); 
     aag.hde(); 
     return true; 
    }
    public boolean addToFriends(String name) {
        name = name.trim();
        if(name.length() > 0 && t.fnc(name) != dgc.gmd) {
            fkl = "";
            fkm = "";
            efm = 0;
            acj(name);
            return true;
        } else {
            System.out.println("There was an error adding: " + name);
            return false;
        }
    }
    public boolean Member()
    {
    return dej;
    }
    public int fatigue() 
    { 
     return (eha * 100) / 750; 
    }
    public boolean Worn(int idx)
    {
    return ejd[idx] == 1;
    }
    public void ThieveNPC(int i)
    {
    try {
    dch[ehk] = 725;
    eie[ehk] = ddi[i].gmh;
    eif[ehk] = ddi[i].gmi;
    dfm[ehk] = ddi[i].gmf;
    fal(ehk++);
      } catch(Exception e) {}
    }    
    

    public void Say(String message) { 
                int j4 = v.cek(message);
                acm(v.ceg, j4);
                message = v.cej(v.ceg, 0, j4);
                message = u.fgd(message);
                dgc.gnf = 150;
                dgc.gne = message;
                feb(dgc.gme + ": " + message, 2);
    }
    
    public int playerByName(String name) 
    { 
    int Player = -1;
    for(int i = 0; i < efg; i++) 
    if(ege[i].gme.equals(name)) {
    Player = i;  }
    return Player;    
    }    
    
    public void TradePlayer(int p)
    {
    try{
    dch[ehk] = 2810;
    dfm[ehk] = ege[p].gmf;
    fal(ehk++);
      } catch(Exception e) {}
    }    
    public int WildyLvl()
    {
    return 1 + (2203 - (dge + dne + dim)) / 6;
    }
    public boolean Bank() 
    {
    return emc;
    }
    public boolean questMenu() 
    {
        return dli;
    }
    public void Answer(int idx) 
    {       
    WaitForStuffToHappen();       
            aag.hdg(189);
            aag.heb(idx);
            aag.hde();
            dli = false;          
    }
            	     
    public void TalkToNPC(int idx) 
    {       
    try {
            dch[ehk] = 720;
            eie[ehk] = ddi[idx].gmh;
            eif[ehk] = ddi[idx].gmi;
            dfm[ehk] = ddi[idx].gmf;
            fal(ehk++); 
              } catch(Exception e) {}       
    } 
    public String getItemName(int idx)
    {
    return e.ame[idx];
    }
    
    public boolean Withdraw(int type, int amount)
        {       
        WaitForStuffToHappen();
	            aag.hdg(131);
	            aag.hdj(type);
	            aag.hdj(amount);
	            aag.hde();
	            return true;	              
    	}
    
    public void Deposit(int idx, int amount) 
    {   	
    WaitForStuffToHappen();	
	            aag.hdg(190);
	            aag.hdj(idx);
	            aag.hdj(amount);
	            aag.hde();
	            return;	        	                	        
    }
    
    public int GetPlayerIDX(int type)
    {
    int player = -1;
    for (int i = 0; i < efg; i++) {
    if(ege[i].gmf == type){ player = i; }
    }
    return player;
    }
    
    public int getStat(int idx)
    {
    return efk[idx];
    }  
    public int GetExp(int idx)
    {
    return dlf[idx] / 4;
    }
    public int getCurrentStat(int idx)
    {
    return egk[idx];
    }
    public int getPathLength(int x, int y) {
     int x1 = dgd;
     int y1 = dge; 
     x -= dil; 
     y -= dim; 
     int i = (ejk.gkb(x1,y1,x,y,x,y,djk,djl,false)); 
     if(i < 0) return -1; 
     int len = 0; 
     for(i--; i >= 0; i--) { 
     int dx = x1 - djk[i]; 
     int dy = y1 - djl[i]; 
     x1 = djk[i]; 
     y1 = djl[i]; 
     if(dx < 0) dx = -dx; 
     if(dy < 0) dy = -dy; 
     if(dx > dy) len += dx; 
     else len += dy; 
     } 
     return len; 
     }
     public int GetNearestRangeNPC(int id) {
     WaitForStuffToHappen();
     int npc = -1;
         int distance = 999999;
        for(int j = 0; j < dnj; j++)
    if (GetNPCType(j) == id){
    int temp = npcPathLength(j) - distance;
    if(temp < distance){
        npc = j;
        distance = temp;
       }
     }
     return npc;
    }
     public int GetNearestNPC(int id) 
     {
     WaitForStuffToHappen();
       int npc = -1;
         int distance = 999999;
        for(int j = 0; j < dnj; j++)
    if (GetNPCType(j) == id && canReachNpc(j) && !npcInCombat(j)) {
    int temp = npcPathLength(j) - distance;
    if(temp < distance){
        npc = j;
        distance = temp;
       }
     }
     return npc;
    }
    public boolean npcInCombat(int idx)
    {
    return ddi[idx].gml == 8 || ddi[idx].gml == 9;
    } 
    public int itemPathLength(int pos)
    {
    return getPathLength(itemX(pos),itemY(pos));
    }   
    public int npcPathLength(int pos) 
    {      
    return getPathLength(npcX(pos),npcY(pos)); 
    }
    public boolean canReachItem(int pos)
    {
    if(ejk.gkb(dgd,dge,itemX(pos)-dil,itemY(pos)-dim,itemX(pos)-dil,itemY(pos)-dim,djk,djl,false) == -1) 
    return false;     
    return true;
     }
     public boolean canReachNpc(int pos)
     	{      
    if(ejk.gkb(dgd,dge,npcX(pos)-dil,npcY(pos)-dim,npcX(pos)-dil,npcY(pos)-dim,djk,djl,false) == -1) 
    return false;     
    return true;
     }
    public void ObjectCommand(int idx) 
    {        
         try {
            dch[ehk] = 420;
            eie[ehk] = ebm[idx];
            eif[ehk] = ebn[idx];
            dfm[ehk] = ecb[idx];
            dfn[ehk] = eca[idx];
            fal(ehk++);
          } catch(Exception e) {}
    }    
    public boolean canReach(int x, int y) 
    {
        int i = (ejk.gkb(dgd, dgd, x - dil, y - dim, x - dil, y - dim, djk, djl, false));
        return (i > -1 ? true : false);
    }   
    
    /**public int GetNearestObject(int idx){
    int min = 999999;
    int object = -1;
         for (int i = 0; i < djd; i++) {
       if(canReach(objectX(i),objectY(i)) && eca[i] == idx){
       int eval = getPathLength(objectX(i),objectY(i)) - min;
 	      if (eval < min) {
 	        min = eval;
 	        object = i;
 	      }
 	  }
 	}
    return object;
    }*/
    public int objectX(int idx) {        
            return ebm[idx] + dil;        
    }
    public int objectY(int idx) {        
            return ebn[idx] + dim;        
    }   
   
    public int itemCount(){
    return dkm;
    }
    public void AtObject(int x, int y) {
        x -= dil;
        y -= dim;
        
        for(int i = 0; i < djd; i++) {
            if(ebm[i] == x && ebn[i] == y) {
                    ObjectCommand(i);
                    
            }        
        }
    } 
    public void take(int x, int y) {
        x -= dil;
        y -= dim;
        
        for(int i = 0; i < itemCount(); i++) {
            if(ekj[i] == x && ekk[i] == y) {
                    takeCommand(i);
                    
            }        
        }
    } 
    public void takeCommand(int idx) 
    {       
        try {
            dch[ehk] = 220;
            eie[ehk] = ekj[idx];
            eif[ehk] = ekk[idx];
            dfm[ehk] = ekl[idx];
            fal(ehk++);
          } catch(Exception e) {}
    }
    public int itemX(int idx) {        
            return ekj[idx] + dil;        
    }
    public int itemY(int idx) {        
            return ekk[idx] + dim;        
    }
  
    public boolean sleeping() {
        	
        	return ece;
    	}       
    public int PathLength(int x1, int y1, int x2, int y2) {
        x1 -= dil;
        y1 -= dim;
        x2 -= dil;
        y2 -= dim;
        
        int i = (ejk.gkb(x1, y1, x2, y2, x2, y2, djk, djl, false));
        
        if(i < 0)
            return -1;
        
        int len = 0;
        
        for(i--; i >= 0; i--) {
            int dx = x1 - djk[i];
            int dy = y1 - djl[i];
            x1 = djk[i];
            y1 = djl[i];
            
           
            if(dx < 0) dx = -dx;
            if(dy < 0) dy = -dy;
            
            if(dx > dy) len += dx;
            else len += dy;
        }
        
        
        return len;
    }
           
     public int GetNPCType(int idx) {
 	 return ddi[idx].gmj;
	} 
        
    public int npcX(int idx) {
    return (ddi[idx].gmh - 64) / ecj + dil;
    } 
    public int npcY(int idx) {
    return (ddi[idx].gmi - 64) / ecj + dim;
    }      

    
    public boolean IsHerb(int idx){
    if(idx == 165 || idx == 435 || idx == 436 || idx == 437 || idx == 438 || idx == 439 || idx == 440 || idx == 441 || idx == 442 || idx == 443)
    return true;
    else
    return false;
    }
    public String CheckHerb(int idx)
    {
    if (idx == 165) { return "Guam"; }
    else
    if (idx == 435) { return "Marrentill"; }
    else
    if (idx == 436) { return "Tarromin"; }
    else
    if (idx == 437) { return "Harralander"; }
    else
    if (idx == 438) { return "Ranarr"; }
    else
    if (idx == 439) { return "Irit"; }
    else
    if (idx == 440) { return "Avantoe"; }
    else
    if (idx == 441) { return "Kwuarm"; }
    else
    if (idx == 442) { return "Cadentine"; }
    else
    if (idx == 443) { return "Dwarf Weed"; }
    else
    return null;    
    }
    public int getDistance(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        
        return (dx * dx) + (dy + dy);
    }
    class Tile {        
       
        public int x;
        
        public int y;
        
        
        public Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        
        public int distanceFrom(int x, int y) {
            int dx = this.x - x;
            int dy = this.y - y;
            
            return (dx * dx) + (dy * dy);
        }
        
        
        public int distanceFrom(Tile c) {
            int dx = x - c.x;
            int dy = y - c.y;
            
            return (dx * dx) + (dy * dy);
        }
        
        
        public boolean inArea(int x1, int y1, int x2, int y2) {
            int temp = 0;
            
            if(x2 > x1) {
                temp = x2;
                x2 = x1;
                x1 = temp;
            }
            if(y2 > y1) {
                temp = y2;
                y2 = y1;
                y1 = temp;
            }
            
            return (x < x1 && x > x2 && y < y1 && y > y2);
        }
    };
     public boolean Walk(int x, int y) {
        int playerX = getX();
        int playerY = getY();
        
        if(getDistance(playerX, playerY, x, y) > maxDist)
            return false;
        
        int i = (ejk.gkb(playerX - dil, playerY - dim, x - dil, y - dim, x - dil, y - dim, djk, djl, false));
        if(i < 0)
            return false;
        else {
            dch[ehk] = 920;
            eie[ehk] = x - dil;
            eif[ehk] = y - dim;
            fal(ehk++);
            return true;
        }
    }
    public int getFightMode(){
		return dck;
	}
    public void setFightMode(int idx) 
    {
    dck = idx;
    super.aag.hdg(74);
    super.aag.heb(dck);
    super.aag.hde();   
    }	
    public boolean isPrayerOn(int type) {
        
        return dhe[type];
    }
    public void prayerOn(int idx){
    if(egk[5] == 0) { feb("@red@Canibalistic: @yel@No more Prayer, Sorry", 3); }
    else {
            aag.hdg(202);
            aag.heb(idx);
            aag.hde();
            dhe[idx] = true;
         }   
    }
    public void prayerOff(int idx){
            aag.hdg(162);
            aag.heb(idx);
            aag.hde();
            dhe[idx] = false;
            }
    /*public boolean togglePrayer(int type) {
        
        if(!isPrayerOn(type)) {
            aag.hdg(202);
            aag.heb(type);
            aag.hde();
            dhe[type] = true;
            return true;
        } else {
            aag.hdg(162);
            aag.heb(type);
            aag.hde();
            dhe[type] = false;
            return false;
        }
    }*/
    /**public boolean isFriendOn(String name) {
    if(super.aam[name] == 99)
    return true;
    else 
    return false;
    }**/
    public int getPlayerX(int idx) 
    {
        
            return (ege[idx].gmh - 64) / ecj + dil;
        
    }
    public int getPlayerY(int idx) 
    {
        
            return (ege[idx].gmi - 64) / ecj + dim;
        
    }
    public void attPlayer(int idx) 
    {
    dch[ehk] = 805; 
    eie[ehk] = ege[idx].gmh;
    eif[ehk] = ege[idx].gmi;
    dfm[ehk] = ege[idx].gmf;
    fal(ehk++);
    }
    
    public int getPlayerDestinationX(int idx) {
        int i = ege[idx].gna;
        if(i + 1 % 10 == ege[idx].gmn) {
            return (ege[idx].gmh - 64) / ecj + dil;
        }
        
        return (ege[idx].gnb[i] - 64) / ecj + dil;
        
    }
    public int getPlayerDestinationY(int idx) {
        int i = ege[idx].gna;
        if(i + 1 % 10 == ege[idx].gmn) {
            return (ege[idx].gmi - 64) / ecj + dim;
        }
        
        return (ege[idx].gnc[i] - 64) / ecj + dil;
        
    }    
    public int getX() {
		 
        	return (dgc.gmh - 64) / ecj + dil;
    	}
    	
    	public int getY() {
    		 
        	return (dgc.gmi - 64) / ecj + dim;
    	}
    
    public void Wait(long time){
		try {
                        Thread.sleep(time);
                    }
                    catch(Exception e) {}

	}
    public int invCount (int id){	
		return fce(id);
      	}
    public int invCount(){
		return eja;
	}   
    public int getItemAtSlot(int idx)
     {
     return ejb[idx];     
     }
    public int findSlot(int type) {
	        
	        for(int i = 0; i < invCount(); i++) {
	            if(getItemAtSlot(i) == type)
	                return i;
	        }
	        return -1;
    	}
    public void use(int idx) 
    {
     try {
	            dch[ehk] = 640;
	            dfm[ehk] = idx;
	            fal(ehk++);
	              } catch(Exception e) {}
	        
    }
	
    public boolean loggedIn(){
		return eck == 1;
	}
    public boolean inComb(){
		 
		return dgc.gml == 8 || dgc.gml == 9;
	}
    
    public boolean inWildy()
    {
    int lvl = 2203 - (dge + dne + dim);
    if(lvl > 0)
    
    return true;
    
    else
    
    return false;
    
    }    
    public void Screen()throws Exception {
     File f;
      for(int x = 1;x < Integer.MAX_VALUE;x++){
       f = new File("Shots/Screeny" + x + ".png");
        if(!f.exists()){
         BufferedImage Im = new BufferedImage(dcl, dcm + 10, BufferedImage.TYPE_INT_RGB);
         Graphics2D g = Im.createGraphics();
         g.drawImage(efj.bmb,0,0,this);
         g.dispose();
         ImageIO.write(Im,"png",f);
         break;
    }
  }
 }    

    
    public static final void main(String args[])
    {
    
        mudclient mudclient1 = new mudclient();
        mudclient1.dhh = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.dej = true;
        if(args.length > 1)
            mudclient1.aac = args[1];
        if(args.length > 2)
            mudclient1.aad = Integer.parseInt(args[2]);
        mudclient1.flc(mudclient1.dcl, mudclient1.dcm + 11, "Canibalistic - Canibal", false);
        mudclient1.fkd = 10;      
          
    }   
    private final void emg()
    {
        byte byte0 = 7;
        byte byte1 = 15;
        char c1 = '\257';
        if(ebd != 0)
        {
            for(int l = 0; l < 5; l++)
            {
                if(l <= 0 || super.fke <= byte0 || super.fke >= byte0 + c1 || super.fkf <= byte1 + l * 20 || super.fkf >= byte1 + l * 20 + 20)
                    continue;
                dck = l - 1;
                SMode = l - 1;
                ebd = 0;
                super.aag.hdg(74);
                super.aag.heb(dck);
                super.aag.hde();
                break;
            }

        }
        for(int i1 = 0; i1 < 5; i1++)
        {
            if(i1 == dck + 1)
                efj.cam(byte0, byte1 + i1 * 20, c1, 20, j.cbh(255, 0, 0), 128);
            else
                efj.cam(byte0, byte1 + i1 * 20, c1, 20, j.cbh(190, 190, 190), 128);
            efj.cbc(byte0, byte1 + i1 * 20, c1, 0);
            efj.cbc(byte0, byte1 + i1 * 20 + 20, c1, 0);
        }

        efj.cdl("Select combat style", byte0 + c1 / 2, byte1 + 16, 3, 0xffffff);
        efj.cdl("Controlled (+1 of each)", byte0 + c1 / 2, byte1 + 36, 3, 0);
        efj.cdl("Aggressive (+3 strength)", byte0 + c1 / 2, byte1 + 56, 3, 0);
        efj.cdl("Accurate   (+3 attack)", byte0 + c1 / 2, byte1 + 76, 3, 0);
        efj.cdl("Defensive  (+3 defense)", byte0 + c1 / 2, byte1 + 96, 3, 0);
    }

    public final Image createImage(int l, int i1)
    {
        if(a.fig != null)
            return a.fig.createImage(l, i1);
        if(link.fni != null)
            return link.fni.createImage(l, i1);
        else
            return super.createImage(l, i1);
    }

    private final void emh(int l, String s1)
    {
        int i1 = ebm[l];
        int j1 = ebn[l];
        int k1 = i1 - dgc.gmh / 128;
        int l1 = j1 - dgc.gmi / 128;
        byte byte0 = 7;
        if(i1 >= 0 && j1 >= 0 && i1 < 96 && j1 < 96 && k1 > -byte0 && k1 < byte0 && l1 > -byte0 && l1 < byte0)
        {
            efn.bgn(ddf[l]);
            int i2 = e.anj(s1);
            i j2 = dkj[i2].cnj();
            efn.bgm(j2);
            j2.cme(true, 48, 48, -50, -10, -50);
            j2.cnl(ddf[l]);
            j2.chk = l;
            ddf[l] = j2;
        }
    }

    private final void emi()
    {
        efj.cba(126, 137, 260, 60, 0);
        efj.cbb(126, 137, 260, 60, 0xffffff);
        efj.cdl("Logging out... Bye, Bye", 256, 173, 5, 0xffffff);
    }

    private final void emj()
    {
        dea = false;
        efj.bnc = false;
        efj.cak();
        if(ehl == 0 || ehl == 1 || ehl == 2 || ehl == 3)
        {
            int l = (dji * 2) % 3072;
            if(l < 1024)
            {
                efj.ccb(0, 10, dfd);
                if(l > 768)
                    efj.ccd(0, 10, dfd + 1, l - 768);
            } else
            if(l < 2048)
            {
                efj.ccb(0, 10, dfd + 1);
                if(l > 1792)
                    efj.ccd(0, 10, del + 10, l - 1792);
            } else
            {
                efj.ccb(0, 10, del + 10);
                if(l > 2816)
                    efj.ccd(0, 10, dfd, l - 2816);
            }
        }
        if(ehl == 0)
            ehm.ged();
        if(ehl == 1)
            dmc.ged();
        if(ehl == 2)
            dkf.ged();
        efj.ccb(0, dcm, del + 22);
        efj.caj(dci, 0, 0);
    }

    protected final void adf(int arg0, int arg1, byte arg2[])
    {
        try
        {
            if(arg0 == 141)
            {
                efh = efg;
                for(int l = 0; l < efh; l++)
                    dmn[l] = ege[l];

                int l7 = 8;
                dgd = t.fmn(arg2, l7, 11);
                l7 += 11;
                dge = t.fmn(arg2, l7, 13);
                l7 += 13;
                int i14 = t.fmn(arg2, l7, 4);
                l7 += 4;
                boolean flag1 = fdg(dgd, dge);
                dgd -= dil;
                dge -= dim;
                int i23 = dgd * ecj + 64;
                int i26 = dge * ecj + 64;
                if(flag1)
                {
                    dgc.gna = 0;
                    dgc.gmn = 0;
                    dgc.gmh = dgc.gnb[0] = i23;
                    dgc.gmi = dgc.gnc[0] = i26;
                }
                efg = 0;
                dgc = eml(dgf, i23, i26, i14);
                int j29 = t.fmn(arg2, l7, 8);
                l7 += 8;
                for(int i34 = 0; i34 < j29; i34++)
                {
                    f f4 = dmn[i34 + 1];
                    int i40 = t.fmn(arg2, l7, 1);
                    l7++;
                    if(i40 != 0)
                    {
                        int i42 = t.fmn(arg2, l7, 1);
                        l7++;
                        if(i42 == 0)
                        {
                            int j43 = t.fmn(arg2, l7, 3);
                            l7 += 3;
                            int j44 = f4.gna;
                            int i45 = f4.gnb[j44];
                            int j45 = f4.gnc[j44];
                            if(j43 == 2 || j43 == 1 || j43 == 3)
                                i45 += ecj;
                            if(j43 == 6 || j43 == 5 || j43 == 7)
                                i45 -= ecj;
                            if(j43 == 4 || j43 == 3 || j43 == 5)
                                j45 += ecj;
                            if(j43 == 0 || j43 == 1 || j43 == 7)
                                j45 -= ecj;
                            f4.gmm = j43;
                            f4.gna = j44 = (j44 + 1) % 10;
                            f4.gnb[j44] = i45;
                            f4.gnc[j44] = j45;
                        } else
                        {
                            int k43 = t.fmn(arg2, l7, 4);
                            if((k43 & 0xc) == 12)
                            {
                                l7 += 2;
                                continue;
                            }
                            f4.gmm = t.fmn(arg2, l7, 4);
                            l7 += 4;
                        }
                    }
                    ege[efg++] = f4;
                }

                int k37 = 0;
                while(l7 + 24 < arg1 * 8) 
                {
                    int j40 = t.fmn(arg2, l7, 11);
                    l7 += 11;
                    int j42 = t.fmn(arg2, l7, 5);
                    l7 += 5;
                    if(j42 > 15)
                        j42 -= 32;
                    int l43 = t.fmn(arg2, l7, 5);
                    l7 += 5;
                    if(l43 > 15)
                        l43 -= 32;
                    int j14 = t.fmn(arg2, l7, 4);
                    l7 += 4;
                    int k44 = t.fmn(arg2, l7, 1);
                    l7++;
                    int j23 = (dgd + j42) * ecj + 64;
                    int j26 = (dge + l43) * ecj + 64;
                    eml(j40, j23, j26, j14);
                    if(k44 == 0)
                        dde[k37++] = j40;
                }
                if(k37 > 0)
                {
                    super.aag.hdg(241);
                    super.aag.hdj(k37);
                    for(int k40 = 0; k40 < k37; k40++)
                    {
                        f f5 = eba[dde[k40]];
                        super.aag.hdj(f5.gmf);
                        super.aag.hdj(f5.gmg);
                    }

                    super.aag.hde();
                    k37 = 0;
                }
                return;
            }
            if(arg0 == 172)
            {
                for(int i1 = 1; i1 < arg1;)
                    if(t.fmh(arg2[i1]) == 255)
                    {
                        int i8 = 0;
                        int k14 = dgd + arg2[i1 + 1] >> 3;
                        int j19 = dge + arg2[i1 + 2] >> 3;
                        i1 += 3;
                        for(int k23 = 0; k23 < dkm; k23++)
                        {
                            int k26 = (ekj[k23] >> 3) - k14;
                            int k29 = (ekk[k23] >> 3) - j19;
                            if(k26 != 0 || k29 != 0)
                            {
                                if(k23 != i8)
                                {
                                    ekj[i8] = ekj[k23];
                                    ekk[i8] = ekk[k23];
                                    ekl[i8] = ekl[k23];
                                    ekm[i8] = ekm[k23];
                                }
                                i8++;
                            }
                        }

                        dkm = i8;
                    } else
                    {
                        int j8 = t.fmi(arg2, i1);
                        i1 += 2;
                        int l14 = dgd + arg2[i1++];
                        int k19 = dge + arg2[i1++];
                        if((j8 & 0x8000) == 0)
                        {
                            ekj[dkm] = l14;
                            ekk[dkm] = k19;
                            ekl[dkm] = j8;
                            ekm[dkm] = 0;
                            for(int l23 = 0; l23 < djd; l23++)
                            {
                                if(ebm[l23] != l14 || ebn[l23] != k19)
                                    continue;
                                ekm[dkm] = e.ama[eca[l23]];
                                break;
                            }

                            dkm++;
                        } else
                        {
                            j8 &= 0x7fff;
                            int i24 = 0;
                            for(int l26 = 0; l26 < dkm; l26++)
                                if(ekj[l26] != l14 || ekk[l26] != k19 || ekl[l26] != j8)
                                {
                                    if(l26 != i24)
                                    {
                                        ekj[i24] = ekj[l26];
                                        ekk[i24] = ekk[l26];
                                        ekl[i24] = ekl[l26];
                                        ekm[i24] = ekm[l26];
                                    }
                                    i24++;
                                } else
                                {
                                    j8 = -123;
                                }

                            dkm = i24;
                        }
                    }

                return;
            }
            if(arg0 == 158)
            {
                for(int j1 = 1; j1 < arg1;)
                    if(t.fmh(arg2[j1]) == 255)
                    {
                        int k8 = 0;
                        int i15 = dgd + arg2[j1 + 1] >> 3;
                        int l19 = dge + arg2[j1 + 2] >> 3;
                        j1 += 3;
                        for(int j24 = 0; j24 < djd; j24++)
                        {
                            int i27 = (ebm[j24] >> 3) - i15;
                            int l29 = (ebn[j24] >> 3) - l19;
                            if(i27 != 0 || l29 != 0)
                            {
                                if(j24 != k8)
                                {
                                    ddf[k8] = ddf[j24];
                                    ddf[k8].chk = k8;
                                    ebm[k8] = ebm[j24];
                                    ebn[k8] = ebn[j24];
                                    eca[k8] = eca[j24];
                                    ecb[k8] = ecb[j24];
                                }
                                k8++;
                            } else
                            {
                                efn.bgn(ddf[j24]);
                                ejk.gkg(ebm[j24], ebn[j24], eca[j24]);
                            }
                        }

                        djd = k8;
                    } else
                    {
                        int l8 = t.fmi(arg2, j1);
                        j1 += 2;
                        int j15 = dgd + arg2[j1++];
                        int i20 = dge + arg2[j1++];
                        int k24 = 0;
                        for(int j27 = 0; j27 < djd; j27++)
                            if(ebm[j27] != j15 || ebn[j27] != i20)
                            {
                                if(j27 != k24)
                                {
                                    ddf[k24] = ddf[j27];
                                    ddf[k24].chk = k24;
                                    ebm[k24] = ebm[j27];
                                    ebn[k24] = ebn[j27];
                                    eca[k24] = eca[j27];
                                    ecb[k24] = ecb[j27];
                                }
                                k24++;
                            } else
                            {
                                efn.bgn(ddf[j27]);
                                ejk.gkg(ebm[j27], ebn[j27], eca[j27]);
                            }

                        djd = k24;
                        if(l8 != 60000)
                        {
                            int i30 = ejk.gjh(j15, i20);
                            int j34;
                            int l37;
                            if(i30 == 0 || i30 == 4)
                            {
                                j34 = e.all[l8];
                                l37 = e.alm[l8];
                            } else
                            {
                                l37 = e.all[l8];
                                j34 = e.alm[l8];
                            }
                            int l40 = ((j15 + j15 + j34) * ecj) / 2;
                            int k42 = ((i20 + i20 + l37) * ecj) / 2;
                            int i44 = e.alk[l8];
                            i l44 = dkj[i44].cnj();
                            efn.bgm(l44);
                            l44.chk = djd;
                            l44.cmi(0, i30 * 32, 0);
                            l44.cmk(l40, -ejk.gla(l40, k42), k42);
                            l44.cme(true, 48, 48, -50, -10, -50);
                            ejk.gjj(j15, i20, l8);
                            if(l8 == 74)
                                l44.cmk(0, -480, 0);
                            ebm[djd] = j15;
                            ebn[djd] = i20;
                            eca[djd] = l8;
                            ecb[djd] = i30;
                            ddf[djd++] = l44;
                        }
                    }

                return;
            }
            if(arg0 == 37)
            {
                int k1 = 1;
                eja = arg2[k1++] & 0xff;
                for(int i9 = 0; i9 < eja; i9++)
                {
                    int k15 = t.fmi(arg2, k1);
                    k1 += 2;
                    ejb[i9] = k15 & 0x7fff;
                    ejd[i9] = k15 / 32768;
                    if(e.ajh[k15 & 0x7fff] == 0)
                    {
                        ejc[i9] = t.fmm(arg2, k1);
                        if(ejc[i9] >= 128)
                            k1 += 4;
                        else
                            k1++;
                    } else
                    {
                        ejc[i9] = 1;
                    }
                }

                return;
            }
            if(arg0 == 183)
            {
                int l1 = t.fmi(arg2, 1);
                int j9 = 3;
                for(int l15 = 0; l15 < l1; l15++)
                {
                    int j20 = t.fmi(arg2, j9);
                    j9 += 2;
                    f f1 = eba[j20];
                    byte byte6 = arg2[j9];
                    j9++;
                    if(byte6 == 0)
                    {
                        int j30 = t.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.gnh = 150;
                            f1.gng = j30;
                        }
                    } else
                    if(byte6 == 1)
                    {
                        byte byte7 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s3 = u.fgd(v.cej(arg2, j9, byte7));
                            boolean flag3 = false;
                            for(int i41 = 0; i41 < super.aan; i41++)
                                if(super.aba[i41] == f1.gmd)
                                    flag3 = true;

                            if(!flag3)
                            {
                                f1.gnf = 150;
                                f1.gne = s3;
                                                                lastChatMessage = s3;
								lastChatter = f1.gme;
                                feb(f1.gme + ": " + f1.gne, 2);
                            }
                        }
                        j9 += byte7;
                    } else
                    if(byte6 == 2)
                    {
                        int k30 = t.fmh(arg2[j9]);
                        j9++;
                        int k34 = t.fmh(arg2[j9]);
                        j9++;
                        int i38 = t.fmh(arg2[j9]);
                        j9++;
                        if(f1 != null)
                        {
                            f1.gni = k30;
                            f1.gnj = k34;
                            f1.gnk = i38;
                            f1.gnl = 200;
                            if(f1 == dgc)
                            {
                                egk[3] = k34;
                                efk[3] = i38;
                                eab = false;
                                ega = false;
                            }
                        }
                    } else
                    if(byte6 == 3)
                    {
                        int l30 = t.fmi(arg2, j9);
                        j9 += 2;
                        int l34 = t.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.had = l30;
                            f1.haf = l34;
                            f1.hae = -1;
                            f1.hag = ebc;
                        }
                    } else
                    if(byte6 == 4)
                    {
                        int i31 = t.fmi(arg2, j9);
                        j9 += 2;
                        int i35 = t.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.had = i31;
                            f1.hae = i35;
                            f1.haf = -1;
                            f1.hag = ebc;
                        }
                    } else
                    if(byte6 == 5)
                    {
                        if(f1 != null)
                        {
                            f1.gmg = t.fmi(arg2, j9);
                            j9 += 2;
                            f1.gmd = t.fmk(arg2, j9);
                            j9 += 8;
                            f1.gme = t.fnd(f1.gmd);
                            int j31 = t.fmh(arg2[j9]);
                            j9++;
                            for(int j35 = 0; j35 < j31; j35++)
                            {
                                f1.gnd[j35] = t.fmh(arg2[j9]);
                                j9++;
                            }

                            for(int j38 = j31; j38 < 12; j38++)
                                f1.gnd[j38] = 0;

                            f1.gnn = arg2[j9++] & 0xff;
                            f1.haa = arg2[j9++] & 0xff;
                            f1.hab = arg2[j9++] & 0xff;
                            f1.hac = arg2[j9++] & 0xff;
                            f1.gnm = arg2[j9++] & 0xff;
                            f1.haj = arg2[j9++] & 0xff;
                        } else
                        {
                            j9 += 14;
                            int k31 = t.fmh(arg2[j9]);
                            j9 += k31 + 1;
                        }
                    } else
                    if(byte6 == 6)
                    {
                        byte byte8 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s4 = v.cej(arg2, j9, byte8);
                            f1.gnf = 150;
                            f1.gne = s4;
                            if(f1 == dgc)
                                feb(f1.gme + ": " + f1.gne, 5);
                        }
                        j9 += byte8;
                    }
                }

                return;
            }
            if(arg0 == 29)
            {
                for(int i2 = 1; i2 < arg1;)
                    if(t.fmh(arg2[i2]) == 255)
                    {
                        int k9 = 0;
                        int i16 = dgd + arg2[i2 + 1] >> 3;
                        int k20 = dge + arg2[i2 + 2] >> 3;
                        i2 += 3;
                        for(int l24 = 0; l24 < egn; l24++)
                        {
                            int k27 = (dgk[l24] >> 3) - i16;
                            int l31 = (dgl[l24] >> 3) - k20;
                            if(k27 != 0 || l31 != 0)
                            {
                                if(l24 != k9)
                                {
                                    dkl[k9] = dkl[l24];
                                    dkl[k9].chk = k9 + 10000;
                                    dgk[k9] = dgk[l24];
                                    dgl[k9] = dgl[l24];
                                    eij[k9] = eij[l24];
                                    eik[k9] = eik[l24];
                                }
                                k9++;
                            } else
                            {
                                efn.bgn(dkl[l24]);
                                ejk.gke(dgk[l24], dgl[l24], eij[l24], eik[l24]);
                            }
                        }

                        egn = k9;
                    } else
                    {
                        int l9 = t.fmi(arg2, i2);
                        i2 += 2;
                        int j16 = dgd + arg2[i2++];
                        int l20 = dge + arg2[i2++];
                        byte byte5 = arg2[i2++];
                        int l27 = 0;
                        for(int i32 = 0; i32 < egn; i32++)
                            if(dgk[i32] != j16 || dgl[i32] != l20 || eij[i32] != byte5)
                            {
                                if(i32 != l27)
                                {
                                    dkl[l27] = dkl[i32];
                                    dkl[l27].chk = l27 + 10000;
                                    dgk[l27] = dgk[i32];
                                    dgl[l27] = dgl[i32];
                                    eij[l27] = eij[i32];
                                    eik[l27] = eik[i32];
                                }
                                l27++;
                            } else
                            {
                                efn.bgn(dkl[i32]);
                                ejk.gke(dgk[i32], dgl[i32], eij[i32], eik[i32]);
                            }

                        egn = l27;
                        if(l9 != 65535)
                        {
                            ejk.gkj(j16, l20, byte5, l9);
                            i k35 = feg(j16, l20, byte5, l9, egn);
                            dkl[egn] = k35;
                            dgk[egn] = j16;
                            dgl[egn] = l20;
                            eik[egn] = l9;
                            eij[egn++] = byte5;
                        }
                    }

                return;
            }
            if(arg0 == 41)
            {
                dnk = dnj;
                dnj = 0;
                for(int j2 = 0; j2 < dnk; j2++)
                    eii[j2] = ddi[j2];

                int i10 = 8;
                int k16 = t.fmn(arg2, i10, 8);
                i10 += 8;
                for(int i21 = 0; i21 < k16; i21++)
                {
                    f f2 = eii[i21];
                    int i28 = t.fmn(arg2, i10, 1);
                    i10++;
                    if(i28 != 0)
                    {
                        int j32 = t.fmn(arg2, i10, 1);
                        i10++;
                        if(j32 == 0)
                        {
                            int l35 = t.fmn(arg2, i10, 3);
                            i10 += 3;
                            int k38 = f2.gna;
                            int j41 = f2.gnb[k38];
                            int l42 = f2.gnc[k38];
                            if(l35 == 2 || l35 == 1 || l35 == 3)
                                j41 += ecj;
                            if(l35 == 6 || l35 == 5 || l35 == 7)
                                j41 -= ecj;
                            if(l35 == 4 || l35 == 3 || l35 == 5)
                                l42 += ecj;
                            if(l35 == 0 || l35 == 1 || l35 == 7)
                                l42 -= ecj;
                            f2.gmm = l35;
                            f2.gna = k38 = (k38 + 1) % 10;
                            f2.gnb[k38] = j41;
                            f2.gnc[k38] = l42;
                        } else
                        {
                            int i36 = t.fmn(arg2, i10, 4);
                            if((i36 & 0xc) == 12)
                            {
                                i10 += 2;
                                continue;
                            }
                            f2.gmm = t.fmn(arg2, i10, 4);
                            i10 += 4;
                        }
                    }
                    ddi[dnj++] = f2;
                }

                while(i10 + 34 < arg1 * 8) 
                {
                    int i25 = t.fmn(arg2, i10, 12);
                    i10 += 12;
                    int j28 = t.fmn(arg2, i10, 5);
                    i10 += 5;
                    if(j28 > 15)
                        j28 -= 32;
                    int k32 = t.fmn(arg2, i10, 5);
                    i10 += 5;
                    if(k32 > 15)
                        k32 -= 32;
                    int j36 = t.fmn(arg2, i10, 4);
                    i10 += 4;
                    int l38 = (dgd + j28) * ecj + 64;
                    int k41 = (dge + k32) * ecj + 64;
                    int i43 = t.fmn(arg2, i10, 10);
                    i10 += 10;
                    if(i43 >= e.ald)
                        i43 = 24;
                    faj(i25, l38, k41, j36, i43);
                }
                return;
            }
            if(arg0 == 47)
            {
                int k2 = t.fmi(arg2, 1);
                int j10 = 3;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = t.fmi(arg2, j10);
                    j10 += 2;
                    f f3 = dgj[j21];
                    int k28 = t.fmh(arg2[j10]);
                    j10++;
                    if(k28 == 1)
                    {
                        int l32 = t.fmi(arg2, j10);
                        j10 += 2;
                        byte byte9 = arg2[j10];
                        j10++;
                        if(f3 != null)
                        {
                            String s5 = v.cej(arg2, j10, byte9);
                            f3.gnf = 150;
                            f3.gne = s5;
                            lastQuestMessage = s5;
			    int lastQuestNpcId = f3.gmf;
                            if(l32 == dgc.gmf)
                                feb("@yel@" + e.amb[f3.gmj] + ": " + f3.gne, 5);
                        }
                        j10 += byte9;
                    } else
                    if(k28 == 2)
                    {
                        int i33 = t.fmh(arg2[j10]);
                        j10++;
                        int k36 = t.fmh(arg2[j10]);
                        j10++;
                        int i39 = t.fmh(arg2[j10]);
                        j10++;
                        if(f3 != null)
                        {
                            f3.gni = i33;
                            f3.gnj = k36;
                            f3.gnk = i39;
                            f3.gnl = 200;
                        }
                    }
                }

                return;
            }
            if(arg0 == 117)
            {
                dli = true;
                int l2 = t.fmh(arg2[1]);
                dee = l2;
                int k10 = 2;
                for(int i17 = 0; i17 < l2; i17++)
                {
                    int k21 = t.fmh(arg2[k10]);
                    k10++;
                    dfk[i17] = new String(arg2, k10, k21);
                    k10 += k21;
                }

                return;
            }
            if(arg0 == 208)
            {
                dli = false;
                return;
            }
            if(arg0 == 249)
            {
                dcj = true;
                dgf = t.fmi(arg2, 1);
                dnd = t.fmi(arg2, 3);
                dne = t.fmi(arg2, 5);
                din = t.fmi(arg2, 7);
                dnf = t.fmi(arg2, 9);
                dne -= din * dnf;
                return;
            }
            if(arg0 == 16)
            {
                int i3 = 1;
                for(int l10 = 0; l10 < 18; l10++)
                    egk[l10] = t.fmh(arg2[i3++]);

                for(int j17 = 0; j17 < 18; j17++)
                    efk[j17] = t.fmh(arg2[i3++]);

                for(int l21 = 0; l21 < 18; l21++)
                {
                    dlf[l21] = t.fmj(arg2, i3);
                    i3 += 4;
                }

                dhk = t.fmh(arg2[i3++]);
                return;
            }
            if(arg0 == 33)
            {
                for(int j3 = 0; j3 < 5; j3++)
                    ebb[j3] = t.fmh(arg2[1 + j3]);

                return;
            }
            if(arg0 == 109)
            {
                dfl = 250;
                return;
            }
            if(arg0 == 76)
            {
                int k3 = (arg1 - 1) / 4;
                for(int i11 = 0; i11 < k3; i11++)
                {
                    int k17 = dgd + t.fml(arg2, 1 + i11 * 4) >> 3;
                    int i22 = dge + t.fml(arg2, 3 + i11 * 4) >> 3;
                    int j25 = 0;
                    for(int l28 = 0; l28 < dkm; l28++)
                    {
                        int j33 = (ekj[l28] >> 3) - k17;
                        int l36 = (ekk[l28] >> 3) - i22;
                        if(j33 != 0 || l36 != 0)
                        {
                            if(l28 != j25)
                            {
                                ekj[j25] = ekj[l28];
                                ekk[j25] = ekk[l28];
                                ekl[j25] = ekl[l28];
                                ekm[j25] = ekm[l28];
                            }
                            j25++;
                        }
                    }

                    dkm = j25;
                    j25 = 0;
                    for(int k33 = 0; k33 < djd; k33++)
                    {
                        int i37 = (ebm[k33] >> 3) - k17;
                        int j39 = (ebn[k33] >> 3) - i22;
                        if(i37 != 0 || j39 != 0)
                        {
                            if(k33 != j25)
                            {
                                ddf[j25] = ddf[k33];
                                ddf[j25].chk = j25;
                                ebm[j25] = ebm[k33];
                                ebn[j25] = ebn[k33];
                                eca[j25] = eca[k33];
                                ecb[j25] = ecb[k33];
                            }
                            j25++;
                        } else
                        {
                            efn.bgn(ddf[k33]);
                            ejk.gkg(ebm[k33], ebn[k33], eca[k33]);
                        }
                    }

                    djd = j25;
                    j25 = 0;
                    for(int j37 = 0; j37 < egn; j37++)
                    {
                        int k39 = (dgk[j37] >> 3) - k17;
                        int l41 = (dgl[j37] >> 3) - i22;
                        if(k39 != 0 || l41 != 0)
                        {
                            if(j37 != j25)
                            {
                                dkl[j25] = dkl[j37];
                                dkl[j25].chk = j25 + 10000;
                                dgk[j25] = dgk[j37];
                                dgl[j25] = dgl[j37];
                                eij[j25] = eij[j37];
                                eik[j25] = eik[j37];
                            }
                            j25++;
                        } else
                        {
                            efn.bgn(dkl[j37]);
                            ejk.gke(dgk[j37], dgl[j37], eij[j37], eik[j37]);
                        }
                    }

                    egn = j25;
                }

                return;
            }
            if(arg0 == 7)
            {
                efc = true;
                return;
            }
            if(arg0 == 108)
            {
                int l3 = t.fmi(arg2, 1);
                if(eba[l3] != null)
                    ddg = eba[l3].gme;
                eff = true;
                ede = false;
                edf = false;
                dkb = 0;
                ecl = 0;
                return;
            }
            if(arg0 == 113)
            {
                eff = false;
                ehn = false;
                return;
            }
            if(arg0 == 155)
            {
                ecl = arg2[1] & 0xff;
                int i4 = 2;
                for(int j11 = 0; j11 < ecl; j11++)
                {
                    ecm[j11] = t.fmi(arg2, i4);
                    i4 += 2;
                    ecn[j11] = t.fmj(arg2, i4);
                    i4 += 4;
                }

                ede = false;
                edf = false;
                return;
            }
            if(arg0 == 185)
            {
                byte byte0 = arg2[1];
                if(byte0 == 1)
                {
                    ede = true;
                    return;
                } else
                {
                    ede = false;
                    return;
                }
            }
            if(arg0 == 24)
            {
                djh = true;
                int j4 = 1;
                int k11 = arg2[j4++] & 0xff;
                byte byte4 = arg2[j4++];
                dnh = arg2[j4++] & 0xff;
                dni = arg2[j4++] & 0xff;
                for(int j22 = 0; j22 < 40; j22++)
                    djm[j22] = -1;

                for(int k25 = 0; k25 < k11; k25++)
                {
                    djm[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    djn[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    dka[k25] = arg2[j4++];
                }

                if(byte4 == 1)
                {
                    int i29 = 39;
                    for(int l33 = 0; l33 < eja; l33++)
                    {
                        if(i29 < k11)
                            break;
                        boolean flag2 = false;
                        for(int l39 = 0; l39 < 40; l39++)
                        {
                            if(djm[l39] != ejb[l33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(ejb[l33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            djm[i29] = ejb[l33] & 0x7fff;
                            djn[i29] = 0;
                            dka[i29] = 0;
                            i29--;
                        }
                    }

                }
                if(dml >= 0 && dml < 40 && djm[dml] != dmm)
                {
                    dml = -1;
                    dmm = -2;
                }
                return;
            }
            if(arg0 == 42)
            {
                djh = false;
                return;
            }
            if(arg0 == 170)
            {
                byte byte1 = arg2[1];
                if(byte1 == 1)
                {
                    edf = true;
                    return;
                } else
                {
                    edf = false;
                    return;
                }
            }
            if(arg0 == 161)
            {
                efb = t.fmh(arg2[1]) == 1;
                dek = t.fmh(arg2[2]) == 1;
                ejl = t.fmh(arg2[3]) == 1;
                return;
            }
            if(arg0 == 222)
            {
                for(int k4 = 0; k4 < arg1 - 1; k4++)
                {
                    boolean flag = arg2[k4 + 1] == 1;
                    if(!dhe[k4] && flag)
                        fdb("prayeron");
                    if(dhe[k4] && !flag)
                        fdb("prayeroff");
                    dhe[k4] = flag;
                }

                return;
            }
            if(arg0 == 26)
            {
                for(int l4 = 0; l4 < 50; l4++)
                    dkk[l4] = arg2[l4 + 1] == 1;

                return;
            }
            if(arg0 == 188)
            {
                emc = true;
                int i5 = 1;
                dec = arg2[i5++] & 0xff;
                dnb = arg2[i5++] & 0xff;
                for(int l11 = 0; l11 < dec; l11++)
                {
                    ecf[l11] = t.fmi(arg2, i5);
                    i5 += 2;
                    ecg[l11] = t.fmm(arg2, i5);
                    if(ecg[l11] >= 128)
                        i5 += 4;
                    else
                        i5++;
                }

                ene();
                return;
            }
            if(arg0 == 130)
            {
                emc = false;
                return;
            }
            if(arg0 == 69)
            {
                int j5 = arg2[1] & 0xff;
                dlf[j5] = t.fmj(arg2, 2);
                return;
            }
            if(arg0 == 240)
            {
                int k5 = t.fmi(arg2, 1);
                if(eba[k5] != null)
                    ekg = eba[k5].gme;
                deh = true;
                dkg = 0;
                edl = 0;
                dgm = false;
                dgn = false;
                dla = false;
                dlb = false;
                dlc = false;
                dld = false;
                return;
            }
            if(arg0 == 198)
            {
                deh = false;
                dll = false;
                return;
            }
            if(arg0 == 128)
            {
                ehn = true;
                eia = false;
                eff = false;
                int l5 = 1;
                ekf = t.fmk(arg2, l5);
                l5 += 8;
                eje = arg2[l5++] & 0xff;
                for(int i12 = 0; i12 < eje; i12++)
                {
                    ejf[i12] = t.fmi(arg2, l5);
                    l5 += 2;
                    ejg[i12] = t.fmj(arg2, l5);
                    l5 += 4;
                }

                egh = arg2[l5++] & 0xff;
                for(int l17 = 0; l17 < egh; l17++)
                {
                    egi[l17] = t.fmi(arg2, l5);
                    l5 += 2;
                    egj[l17] = t.fmj(arg2, l5);
                    l5 += 4;
                }

                return;
            }
            if(arg0 == 229)
            {
                edl = arg2[1] & 0xff;
                int i6 = 2;
                for(int j12 = 0; j12 < edl; j12++)
                {
                    edm[j12] = t.fmi(arg2, i6);
                    i6 += 2;
                    edn[j12] = t.fmj(arg2, i6);
                    i6 += 4;
                }

                dgm = false;
                dgn = false;
                return;
            }
            if(arg0 == 211)
            {
                if(arg2[1] == 1)
                    dla = true;
                else
                    dla = false;
                if(arg2[2] == 1)
                    dlb = true;
                else
                    dlb = false;
                if(arg2[3] == 1)
                    dlc = true;
                else
                    dlc = false;
                if(arg2[4] == 1)
                    dld = true;
                else
                    dld = false;
                dgm = false;
                dgn = false;
                return;
            }
            if(arg0 == 81)
            {
                int j6 = 1;
                int k12 = arg2[j6++] & 0xff;
                int i18 = t.fmi(arg2, j6);
                j6 += 2;
                int k22 = t.fmm(arg2, j6);
                if(k22 >= 128)
                    j6 += 4;
                else
                    j6++;
                if(k22 == 0)
                {
                    dec--;
                    for(int l25 = k12; l25 < dec; l25++)
                    {
                        ecf[l25] = ecf[l25 + 1];
                        ecg[l25] = ecg[l25 + 1];
                    }

                } else
                {
                    ecf[k12] = i18;
                    ecg[k12] = k22;
                    if(k12 >= dec)
                        dec = k12 + 1;
                }
                ene();
                return;
            }
            if(arg0 == 210)
            {
                int k6 = 1;
                int l12 = 1;
                int j18 = arg2[k6++] & 0xff;
                int l22 = t.fmi(arg2, k6);
                k6 += 2;
                if(e.ajh[l22 & 0x7fff] == 0)
                {
                    l12 = t.fmm(arg2, k6);
                    if(l12 >= 128)
                        k6 += 4;
                    else
                        k6++;
                }
                ejb[j18] = l22 & 0x7fff;
                ejd[j18] = l22 / 32768;
                ejc[j18] = l12;
                if(j18 >= eja)
                    eja = j18 + 1;
                return;
            }
            if(arg0 == 44)
            {
                int l6 = arg2[1] & 0xff;
                eja--;
                for(int i13 = l6; i13 < eja; i13++)
                {
                    ejb[i13] = ejb[i13 + 1];
                    ejc[i13] = ejc[i13 + 1];
                    ejd[i13] = ejd[i13 + 1];
                }

                return;
            }
            if(arg0 == 23)
            {
                int i7 = 1;
                int j13 = arg2[i7++] & 0xff;
                egk[j13] = t.fmh(arg2[i7++]);
                efk[j13] = t.fmh(arg2[i7++]);
                dlf[j13] = t.fmj(arg2, i7);
                i7 += 4;
                return;
            }
            if(arg0 == 73)
            {
                byte byte2 = arg2[1];
                if(byte2 == 1)
                {
                    dgm = true;
                    return;
                } else
                {
                    dgm = false;
                    return;
                }
            }
            if(arg0 == 131)
            {
                byte byte3 = arg2[1];
                if(byte3 == 1)
                {
                    dgn = true;
                    return;
                } else
                {
                    dgn = false;
                    return;
                }
            }
            if(arg0 == 10)
            {
                dll = true;
                dlm = false;
                deh = false;
                int j7 = 1;
                eme = t.fmk(arg2, j7);
                j7 += 8;
                dhb = arg2[j7++] & 0xff;
                for(int k13 = 0; k13 < dhb; k13++)
                {
                    dhc[k13] = t.fmi(arg2, j7);
                    j7 += 2;
                    dhd[k13] = t.fmj(arg2, j7);
                    j7 += 4;
                }

                dgg = arg2[j7++] & 0xff;
                for(int k18 = 0; k18 < dgg; k18++)
                {
                    dgh[k18] = t.fmi(arg2, j7);
                    j7 += 2;
                    dgi[k18] = t.fmj(arg2, j7);
                    j7 += 4;
                }

                eac = arg2[j7++] & 0xff;
                ead = arg2[j7++] & 0xff;
                eae = arg2[j7++] & 0xff;
                eaf = arg2[j7++] & 0xff;
                return;
            }
            if(arg0 == 238)
            {
                String s1 = new String(arg2, 1, arg1 - 1);
                fdb(s1);
                return;
            }
            if(arg0 == 253)
            {
                if(ean < 50)
                {
                    int k7 = arg2[1] & 0xff;
                    int l13 = arg2[2] + dgd;
                    int l18 = arg2[3] + dge;
                    ekn[ean] = k7;
                    dna[ean] = 0;
                    dnc[ean] = l13;
                    dgb[ean] = l18;
                    ean++;
                }
                return;
            }
            if(arg0 == 126)
            {
                if(!dea)
                {
                    dif = t.fmj(arg2, 1);
                    ela = t.fmi(arg2, 5);
                    ddb = arg2[7] & 0xff;
                    dij = t.fmi(arg2, 8);
                    eab = true;
                    dea = true;
                    edd = null;
                }
                return;
            }
            if(arg0 == 112)
            {
                eln = new String(arg2, 1, arg1 - 1);
                ega = true;
                djj = false;
                return;
            }
            if(arg0 == 49)
            {
                eln = new String(arg2, 1, arg1 - 1);
                ega = true;
                djj = true;
                return;
            }
            if(arg0 == 60)
            {
                eha = t.fmi(arg2, 1);
                return;
            }
            if(arg0 == 15)
            {
                if(!ece)
                    ehb = eha;
                ece = true;
                super.fkl = "";
                super.fkm = "";   
                saveOutput(HCfile, MakePic(arg2));                                                         
                efj.cbk(dfb + 1, arg2);                                          
                eke = null;
                return;
            }
            if(arg0 == 174)
            {
                ehb = t.fmi(arg2, 1);
                return;
            }
            if(arg0 == 206)
            {
                ece = false;
                return;
            }
            if(arg0 == 20)
            {
                eke = "Incorrect - Please wait...";
                return;
            }
            if(arg0 == 28)
            {
                edh = t.fmi(arg2, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(dkn < 3)
            {
                super.aag.hdg(7);
                super.aag.hdk(runtimeexception.toString());
                super.aag.hde();
                super.aag.hdg(7);
                super.aag.hdk("p-type:" + arg0 + " p-size:" + arg1);
                super.aag.hde();
                super.aag.hdg(7);
                super.aag.hdk("rx:" + dgd + " ry:" + dge + " num3l:" + djd);
                super.aag.hde();
                String s2 = "";
                for(int i19 = 0; i19 < 80 && i19 < arg1; i19++)
                    s2 = s2 + arg2[i19] + " ";

                super.aag.hdg(7);
                super.aag.hdk(s2);
                super.aag.hde();
                dkn++;
            }
        }
    }

    private final void emk()
    {
        if(ebd != 0)
        {
            for(int l = 0; l < dee; l++)
            {
                if(super.fke >= efj.cef(dfk[l], 1) || super.fkf <= l * 12 || super.fkf >= 12 + l * 12)
                    continue;
                super.aag.hdg(189);
                super.aag.heb(l);
                super.aag.hde();
                break;
            }

            ebd = 0;
            dli = false;
            return;
        }
        for(int i1 = 0; i1 < dee; i1++)
        {
            int j1 = 65535;
            if(super.fke < efj.cef(dfk[i1], 1) && super.fkf > i1 * 12 && super.fkf < 12 + i1 * 12)
                j1 = 0xff0000;
            efj.cdn(dfk[i1], 6, 12 + i1 * 12, 1, j1);
        }

    }

    private final f eml(int arg0, int arg1, int arg2, int arg3)
    {
        if(eba[arg0] == null)
        {
            eba[arg0] = new f();
            eba[arg0].gmf = arg0;
            eba[arg0].gmg = 0;
        }
        f f1 = eba[arg0];
        boolean flag = false;
        for(int l = 0; l < efh; l++)
        {
            if(dmn[l].gmf != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.gmm = arg3;
            int i1 = f1.gna;
            if(arg1 != f1.gnb[i1] || arg2 != f1.gnc[i1])
            {
                f1.gna = i1 = (i1 + 1) % 10;
                f1.gnb[i1] = arg1;
                f1.gnc[i1] = arg2;
            }
        } else
        {
            f1.gmf = arg0;
            f1.gmn = 0;
            f1.gna = 0;
            f1.gnb[0] = f1.gmh = arg1;
            f1.gnc[0] = f1.gmi = arg2;
            f1.gmm = f1.gml = arg3;
            f1.gmk = 0;
        }
        ege[efg++] = f1;
        return f1;
    }

    private final void emm()
    {
        char c1 = '\u0198';
        char c2 = '\u014E';
        if(dha > 0 && dmj <= 48)
            dha = 0;
        if(dha > 1 && dmj <= 96)
            dha = 1;
        if(dha > 2 && dmj <= 144)
            dha = 2;
        if(dma >= dmj || dma < 0)
            dma = -1;
        if(dma != -1 && edb[dma] != dmb)
        {
            dma = -1;
            dmb = -2;
        }
        if(ebd != 0)
        {
            ebd = 0;
            int l = super.fke - (256 - c1 / 2);
            int j1 = super.fkf - (170 - c2 / 2);
            if(l >= 0 && j1 >= 12 && l < 408 && j1 < 280)
            {
                int l1 = dha * 48;
                for(int k2 = 0; k2 < 6; k2++)
                {
                    for(int i3 = 0; i3 < 8; i3++)
                    {
                        int k7 = 7 + i3 * 49;
                        int i8 = 28 + k2 * 34;
                        if(l > k7 && l < k7 + 49 && j1 > i8 && j1 < i8 + 34 && l1 < dmj && edb[l1] != -1)
                        {
                            dmb = edb[l1];
                            dma = l1;
                        }
                        l1++;
                    }

                }

                l = 256 - c1 / 2;
                j1 = 170 - c2 / 2;
                int j3;
                if(dma < 0)
                    j3 = -1;
                else
                    j3 = edb[dma];
                if(j3 != -1)
                {
                    int i2 = edc[dma];
                    if(e.ajh[j3] == 1 && i2 > 1)
                        i2 = 1;
                    if(i2 >= 1 && super.fke >= l + 220 && super.fkf >= j1 + 238 && super.fke < l + 250 && super.fkf <= j1 + 249)
                    {
                        super.aag.hdg(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(1);
                        super.aag.hde();
                    }
                    if(i2 >= 5 && super.fke >= l + 250 && super.fkf >= j1 + 238 && super.fke < l + 280 && super.fkf <= j1 + 249)
                    {
                        super.aag.hdg(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(5);
                        super.aag.hde();
                    }
                    if(i2 >= 25 && super.fke >= l + 280 && super.fkf >= j1 + 238 && super.fke < l + 305 && super.fkf <= j1 + 249)
                    {
                        super.aag.hdg(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(25);
                        super.aag.hde();
                    }
                    if(i2 >= 100 && super.fke >= l + 305 && super.fkf >= j1 + 238 && super.fke < l + 335 && super.fkf <= j1 + 249)
                    {
                        super.aag.hdg(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(100);
                        super.aag.hde();
                    }
                    if(i2 >= 500 && super.fke >= l + 335 && super.fkf >= j1 + 238 && super.fke < l + 368 && super.fkf <= j1 + 249)
                    {
                        super.aag.hdg(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(500);
                        super.aag.hde();
                    }
                    if(i2 >= 25000 && super.fke >= l + 370 && super.fkf >= j1 + 238 && super.fke < l + 400 && super.fkf <= j1 + 249)
                    {
                        super.aag.hdg(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(25000);
                        super.aag.hde();
                    }
                    if(fce(j3) >= 1 && super.fke >= l + 220 && super.fkf >= j1 + 263 && super.fke < l + 250 && super.fkf <= j1 + 274)
                    {
                        super.aag.hdg(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(1);
                        super.aag.hde();
                    }
                    if(fce(j3) >= 5 && super.fke >= l + 250 && super.fkf >= j1 + 263 && super.fke < l + 280 && super.fkf <= j1 + 274)
                    {
                        super.aag.hdg(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(5);
                        super.aag.hde();
                    }
                    if(fce(j3) >= 25 && super.fke >= l + 280 && super.fkf >= j1 + 263 && super.fke < l + 305 && super.fkf <= j1 + 274)
                    {
                        super.aag.hdg(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(25);
                        super.aag.hde();
                    }
                    if(fce(j3) >= 100 && super.fke >= l + 305 && super.fkf >= j1 + 263 && super.fke < l + 335 && super.fkf <= j1 + 274)
                    {
                        super.aag.hdg(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(100);
                        super.aag.hde();
                    }
                    if(fce(j3) >= 500 && super.fke >= l + 335 && super.fkf >= j1 + 263 && super.fke < l + 368 && super.fkf <= j1 + 274)
                    {
                        super.aag.hdg(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(500);
                        super.aag.hde();
                    }
                    if(fce(j3) >= 25000 && super.fke >= l + 370 && super.fkf >= j1 + 263 && super.fke < l + 400 && super.fkf <= j1 + 274)
                    {
                        super.aag.hdg(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(25000);
                        super.aag.hde();
                    }
                }
            } else
            if(dmj > 48 && l >= 50 && l <= 115 && j1 <= 12)
                dha = 0;
            else
            if(dmj > 48 && l >= 115 && l <= 180 && j1 <= 12)
                dha = 1;
            else
            if(dmj > 96 && l >= 180 && l <= 245 && j1 <= 12)
                dha = 2;
            else
            if(dmj > 144 && l >= 245 && l <= 310 && j1 <= 12)
            {
                dha = 3;
            } else
            {
                super.aag.hdg(78);
                super.aag.hde();
                emc = false;
                return;
            }
        }
        int i1 = 256 - c1 / 2;
        int k1 = 170 - c2 / 2;
        efj.cba(i1, k1, 408, 12, 192);
        int j2 = 0x989898;
        efj.cam(i1, k1 + 12, 408, 17, j2, 160);
        efj.cam(i1, k1 + 29, 8, 204, j2, 160);
        efj.cam(i1 + 399, k1 + 29, 9, 204, j2, 160);
        efj.cam(i1, k1 + 233, 408, 47, j2, 160);
        efj.cdn("Bank", i1 + 1, k1 + 10, 1, 0xffffff);
        int l2 = 50;
        if(dmj > 48)
        {
            int k3 = 0xffffff;
            if(dha == 0)
                k3 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                k3 = 0xffff00;
            efj.cdn("<page 1>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
            k3 = 0xffffff;
            if(dha == 1)
                k3 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                k3 = 0xffff00;
            efj.cdn("<page 2>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
        }
        if(dmj > 96)
        {
            int l3 = 0xffffff;
            if(dha == 2)
                l3 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                l3 = 0xffff00;
            efj.cdn("<page 3>", i1 + l2, k1 + 10, 1, l3);
            l2 += 65;
        }
        if(dmj > 144)
        {
            int i4 = 0xffffff;
            if(dha == 3)
                i4 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                i4 = 0xffff00;
            efj.cdn("<page 4>", i1 + l2, k1 + 10, 1, i4);
            l2 += 65;
        }
        int j4 = 0xffffff;
        if(super.fke > i1 + 320 && super.fkf >= k1 && super.fke < i1 + 408 && super.fkf < k1 + 12)
            j4 = 0xff0000;
        efj.cdk("Close window", i1 + 406, k1 + 10, 1, j4);
        efj.cdn("Number in bank in green", i1 + 7, k1 + 24, 1, 65280);
        efj.cdn("Number held in blue", i1 + 289, k1 + 24, 1, 65535);
        int l7 = 0xd0d0d0;
        int j8 = dha * 48;
        for(int l8 = 0; l8 < 6; l8++)
        {
            for(int i9 = 0; i9 < 8; i9++)
            {
                int k9 = i1 + 7 + i9 * 49;
                int l9 = k1 + 28 + l8 * 34;
                if(dma == j8)
                    efj.cam(k9, l9, 49, 34, 0xff0000, 160);
                else
                    efj.cam(k9, l9, 49, 34, l7, 160);
                efj.cbb(k9, l9, 50, 35, 0);
                if(j8 < dmj && edb[j8] != -1)
                {
                    efj.cdd(k9, l9, 48, 32, den + e.ajf[edb[j8]], e.ajk[edb[j8]], 0, 0, false);
                    efj.cdn(String.valueOf(edc[j8]), k9 + 1, l9 + 10, 1, 65280);
                    efj.cdk(String.valueOf(fce(edb[j8])), k9 + 47, l9 + 29, 1, 65535);
                }
                j8++;
            }

        }

        efj.cbc(i1 + 5, k1 + 256, 398, 0);
        if(dma == -1)
        {
            efj.cdl("Select an object to withdraw or deposit", i1 + 204, k1 + 248, 3, 0xffff00);
            return;
        }
        int j9;
        if(dma < 0)
            j9 = -1;
        else
            j9 = edb[dma];
        if(j9 != -1)
        {
            int k8 = edc[dma];
            if(e.ajh[j9] == 1 && k8 > 1)
                k8 = 1;
            if(k8 > 0)
            {
                efj.cdn("Withdraw " + e.ame[j9], i1 + 2, k1 + 248, 1, 0xffffff);
                int k4 = 0xffffff;
                if(super.fke >= i1 + 220 && super.fkf >= k1 + 238 && super.fke < i1 + 250 && super.fkf <= k1 + 249)
                    k4 = 0xff0000;
                efj.cdn("One", i1 + 222, k1 + 248, 1, k4);
                if(k8 >= 5)
                {
                    int l4 = 0xffffff;
                    if(super.fke >= i1 + 250 && super.fkf >= k1 + 238 && super.fke < i1 + 280 && super.fkf <= k1 + 249)
                        l4 = 0xff0000;
                    efj.cdn("Five", i1 + 252, k1 + 248, 1, l4);
                }
                if(k8 >= 25)
                {
                    int i5 = 0xffffff;
                    if(super.fke >= i1 + 280 && super.fkf >= k1 + 238 && super.fke < i1 + 305 && super.fkf <= k1 + 249)
                        i5 = 0xff0000;
                    efj.cdn("25", i1 + 282, k1 + 248, 1, i5);
                }
                if(k8 >= 100)
                {
                    int j5 = 0xffffff;
                    if(super.fke >= i1 + 305 && super.fkf >= k1 + 238 && super.fke < i1 + 335 && super.fkf <= k1 + 249)
                        j5 = 0xff0000;
                    efj.cdn("100", i1 + 307, k1 + 248, 1, j5);
                }
                if(k8 >= 500)
                {
                    int k5 = 0xffffff;
                    if(super.fke >= i1 + 335 && super.fkf >= k1 + 238 && super.fke < i1 + 368 && super.fkf <= k1 + 249)
                        k5 = 0xff0000;
                    efj.cdn("500", i1 + 337, k1 + 248, 1, k5);
                }
                if(k8 >= 2500)
                {
                    int l5 = 0xffffff;
                    if(super.fke >= i1 + 370 && super.fkf >= k1 + 238 && super.fke < i1 + 400 && super.fkf <= k1 + 249)
                        l5 = 0xff0000;
                    efj.cdn("25000", i1 + 370, k1 + 248, 1, l5);
                }
            }
            if(fce(j9) > 0)
            {
                efj.cdn("Deposit " + e.ame[j9], i1 + 2, k1 + 273, 1, 0xffffff);
                int i6 = 0xffffff;
                if(super.fke >= i1 + 220 && super.fkf >= k1 + 263 && super.fke < i1 + 250 && super.fkf <= k1 + 274)
                    i6 = 0xff0000;
                efj.cdn("One", i1 + 222, k1 + 273, 1, i6);
                if(fce(j9) >= 5)
                {
                    int j6 = 0xffffff;
                    if(super.fke >= i1 + 250 && super.fkf >= k1 + 263 && super.fke < i1 + 280 && super.fkf <= k1 + 274)
                        j6 = 0xff0000;
                    efj.cdn("Five", i1 + 252, k1 + 273, 1, j6);
                }
                if(fce(j9) >= 25)
                {
                    int k6 = 0xffffff;
                    if(super.fke >= i1 + 280 && super.fkf >= k1 + 263 && super.fke < i1 + 305 && super.fkf <= k1 + 274)
                        k6 = 0xff0000;
                    efj.cdn("25", i1 + 282, k1 + 273, 1, k6);
                }
                if(fce(j9) >= 100)
                {
                    int l6 = 0xffffff;
                    if(super.fke >= i1 + 305 && super.fkf >= k1 + 263 && super.fke < i1 + 335 && super.fkf <= k1 + 274)
                        l6 = 0xff0000;
                    efj.cdn("100", i1 + 307, k1 + 273, 1, l6);
                }
                if(fce(j9) >= 500)
                {
                    int i7 = 0xffffff;
                    if(super.fke >= i1 + 335 && super.fkf >= k1 + 263 && super.fke < i1 + 368 && super.fkf <= k1 + 274)
                        i7 = 0xff0000;
                    efj.cdn("500", i1 + 337, k1 + 273, 1, i7);
                }
                if(fce(j9) >= 2500)
                {
                    int j7 = 0xffffff;
                    if(super.fke >= i1 + 370 && super.fkf >= k1 + 263 && super.fke < i1 + 400 && super.fkf <= k1 + 274)
                        j7 = 0xff0000;
                    efj.cdn("25000", i1 + 370, k1 + 273, 1, j7);
                }
            }
        }
    }

    protected final void emn()
    {
        if(eki)
            return;
        if(elm)
            return;
        if(ein)
            return;
        try
        {         
       
            dji++;
            if(eck == 0)
            {
                super.fil = 0;
                fcc();
            }
            if(eck == 1)
            {
                super.fil++;
                fan();                
            }
            super.fkh = 0;
            super.fkj = 0;
            dcg++;
            if(dcg > 500)
            {
                dcg = 0;
                int l = (int)(Math.random() * 4D);
                if((l & 1) == 1)
                    egf += egg;
                if((l & 2) == 2)
                    eea += eeb;
            }
            if(egf < -50)
                egg = 2;
            if(egf > 50)
                egg = -2;
            if(eea < -50)
                eeb = 2;
            if(eea > 50)
                eeb = -2;
            if(ehc > 0)
                ehc--;
            if(ehd > 0)
                ehd--;
            if(ehe > 0)
                ehe--;
            if(ehf > 0)
            {
                ehf--;
                return;
            }    
            
        }
        catch(OutOfMemoryError _ex)
        {
            fdd();
            elm = true;
        }
    }

    private final void ena(int l, int i1, int j1, int k1, boolean flag)
    {
        fde(l, i1, j1, k1, j1, k1, false, flag);
    }

    public  URL getCodeBase()
    {
        try
	{
		return new URL("http://" + super.aac + "/client2/");
	}
	catch(Exception e) {return null;}
	
    }
    
     protected final byte[] enb(int i, String arg1, int arg2) // load data files
    {
        return super.enb(i, arg1, arg2);
    }

    private final void enc()
    {
        char c1 = '\u0190';
        char c2 = 'd';
        if(djj)
        {
            c2 = '\u01C2';
            c2 = '\u012C';
        }
        efj.cba(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0);
        efj.cbb(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0xffffff);
        efj.cdm(eln, 256, (167 - c2 / 2) + 20, 1, 0xffffff, c1 - 40);
        int l = 157 + c2 / 2;
        int i1 = 0xffffff;
        if(super.fkf > l - 12 && super.fkf <= l && super.fke > 106 && super.fke < 406)
            i1 = 0xff0000;
        efj.cdl("Click here to close window", 256, l, 1, i1);
        if(ebd == 1)
        {
            if(i1 == 0xff0000)
                ega = false;
            if((super.fke < 256 - c1 / 2 || super.fke > 256 + c1 / 2) && (super.fkf < 167 - c2 / 2 || super.fkf > 167 + c2 / 2))
                ega = false;
        }
        ebd = 0;
    }

    private final void end()
    {
        elg = new h(efj, 10);
        elh = elg.gfh(5, 269, 502, 56, 1, 20, true);
        eli = elg.gfi(7, 324, 498, 14, 1, 80, false, true);
        elj = elg.gfh(5, 269, 502, 56, 1, 20, true);
        elk = elg.gfh(5, 269, 502, 56, 1, 20, true);
        elg.ggg(eli);
    }

    private final void ene()
    {
        dmj = dec;
        for(int l = 0; l < dec; l++)
        {
            edb[l] = ecf[l];
            edc[l] = ecg[l];
        }

        for(int i1 = 0; i1 < eja; i1++)
        {
            if(dmj >= dnb)
                break;
            int j1 = ejb[i1];
            boolean flag = false;
            for(int k1 = 0; k1 < dmj; k1++)
            {
                if(edb[k1] != j1)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                edb[dmj] = j1;
                edc[dmj] = 0;
                dmj++;
            }
        }

    }

    private final void enf()
    {
        if(dje == 0 && super.fke >= ((j) (efj)).blg - 35 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 && super.fkf < 35)
            dje = 1;
        if(dje == 0 && super.fke >= ((j) (efj)).blg - 35 - 33 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 33 && super.fkf < 35)
        {
            dje = 2;
            dfe = (int)(Math.random() * 13D) - 6;
            dff = (int)(Math.random() * 23D) - 11;
        }
        if(dje == 0 && super.fke >= ((j) (efj)).blg - 35 - 66 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 66 && super.fkf < 35)
            dje = 3;
        if(dje == 0 && super.fke >= ((j) (efj)).blg - 35 - 99 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 99 && super.fkf < 35)
            dje = 4;
        if(dje == 0 && super.fke >= ((j) (efj)).blg - 35 - 132 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 132 && super.fkf < 35)
            dje = 5;
        if(dje == 0 && super.fke >= ((j) (efj)).blg - 35 - 165 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 165 && super.fkf < 35)
            dje = 6;
        if(dje != 0 && super.fke >= ((j) (efj)).blg - 35 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 && super.fkf < 26)
            dje = 1;
        if(dje != 0 && dje != 2 && super.fke >= ((j) (efj)).blg - 35 - 33 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 33 && super.fkf < 26)
        {
            dje = 2;
            dfe = (int)(Math.random() * 13D) - 6;
            dff = (int)(Math.random() * 23D) - 11;
        }
        if(dje != 0 && super.fke >= ((j) (efj)).blg - 35 - 66 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 66 && super.fkf < 26)
            dje = 3;
        if(dje != 0 && super.fke >= ((j) (efj)).blg - 35 - 99 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 99 && super.fkf < 26)
            dje = 4;
        if(dje != 0 && super.fke >= ((j) (efj)).blg - 35 - 132 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 132 && super.fkf < 26)
            dje = 5;
        if(dje != 0 && super.fke >= ((j) (efj)).blg - 35 - 165 && super.fkf >= 3 && super.fke < ((j) (efj)).blg - 3 - 165 && super.fkf < 26)
            dje = 6;
        if(dje == 1 && (super.fke < ((j) (efj)).blg - 248 || super.fkf > 36 + (dlk / 5) * 34))
            dje = 0;
        if(dje == 3 && (super.fke < ((j) (efj)).blg - 199 || super.fkf > 316))
            dje = 0;
        if((dje == 2 || dje == 4 || dje == 5) && (super.fke < ((j) (efj)).blg - 199 || super.fkf > 240))
            dje = 0;
        if(dje == 6 && (super.fke < ((j) (efj)).blg - 199 || super.fkf > 311))
            dje = 0;
    }

    private final void eng()
    {
        if(ebd != 0)
        {
            ebd = 0;
            if(efm == 1 && (super.fke < 106 || super.fkf < 145 || super.fke > 406 || super.fkf > 215))
            {
                efm = 0;
                return;
            }
            if(efm == 2 && (super.fke < 6 || super.fkf < 145 || super.fke > 506 || super.fkf > 215))
            {
                efm = 0;
                return;
            }
            if(efm == 3 && (super.fke < 106 || super.fkf < 145 || super.fke > 406 || super.fkf > 215))
            {
                efm = 0;
                return;
            }
            if(super.fke > 236 && super.fke < 276 && super.fkf > 193 && super.fkf < 213)
            {
                efm = 0;
                return;
            }
        }
        int l = 145;
        if(efm == 1)
        {
            efj.cba(106, l, 300, 70, 0);
            efj.cbb(106, l, 300, 70, 0xffffff);
            l += 20;
            efj.cdl("Enter name to add to friends list", 256, l, 4, 0xffffff);
            l += 20;
            efj.cdl(super.fkl + "*", 256, l, 4, 0xffffff);
            if(super.fkm.length() > 0)
            {
                String s1 = super.fkm.trim();
                super.fkl = "";
                super.fkm = "";
                efm = 0;
                if(s1.length() > 0 && t.fnc(s1) != dgc.gmd)
                    acj(s1);
            }
        }
        if(efm == 2)
        {
            efj.cba(6, l, 500, 70, 0);
            efj.cbb(6, l, 500, 70, 0xffffff);
            l += 20;
            efj.cdl("Enter message to send to " + t.fnd(ekc), 256, l, 4, 0xffffff);
            l += 20;
            efj.cdl(super.fkn + "*", 256, l, 4, 0xffffff);
            if(super.fla.length() > 0)
            {
                String s2 = super.fla;
                super.fkn = "";
                super.fla = "";
                efm = 0;
                int j1 = v.cek(s2);
                acl(ekc, v.ceg, j1);
                s2 = v.cej(v.ceg, 0, j1);
                s2 = u.fgd(s2);
                adg("@pri@You tell " + t.fnd(ekc) + ": " + s2);
            }
        }
        if(efm == 3)
        {
            efj.cba(106, l, 300, 70, 0);
            efj.cbb(106, l, 300, 70, 0xffffff);
            l += 20;
            efj.cdl("Enter name to add to ignore list", 256, l, 4, 0xffffff);
            l += 20;
            efj.cdl(super.fkl + "*", 256, l, 4, 0xffffff);
            if(super.fkm.length() > 0)
            {
                String s3 = super.fkm.trim();
                super.fkl = "";
                super.fkm = "";
                efm = 0;
                if(s3.length() > 0 && t.fnc(s3) != dgc.gmd)
                    ach(s3);
            }
        }
        int i1 = 0xffffff;
        if(super.fke > 236 && super.fke < 276 && super.fkf > 193 && super.fkf < 213)
            i1 = 0xffff00;
        efj.cdl("Cancel", 256, 208, 1, i1);
    }

    private final void enh()
    {
        for(int l = 0; l < efd; l++)
        {
            int i1 = efj.ced(1);
            int k1 = ebe[l];
            int j2 = ebf[l];
            int i3 = ebg[l];
            int l3 = ebh[l];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int l4 = 0; l4 < l; l4++)
                    if(j2 + l3 > ebf[l4] - i1 && j2 - i1 < ebf[l4] + ebh[l4] && k1 - i3 < ebe[l4] + ebg[l4] && k1 + i3 > ebe[l4] - ebg[l4] && ebf[l4] - i1 - l3 < j2)
                    {
                        j2 = ebf[l4] - i1 - l3;
                        flag = true;
                    }

            }
            ebf[l] = j2;
            efj.cdm(efe[l], k1, j2, 1, 0xffff00, 300);
        }

        for(int j1 = 0; j1 < dln; j1++)
        {
            int l1 = eai[j1];
            int k2 = eaj[j1];
            int j3 = eag[j1];
            int i4 = eah[j1];
            int k4 = (39 * j3) / 100;
            int i5 = (27 * j3) / 100;
            int j5 = k2 - i5;
            efj.cce(l1 - k4 / 2, j5, k4, i5, del + 9, 85);
            int k5 = (36 * j3) / 100;
            int l5 = (24 * j3) / 100;
            efj.cdd(l1 - k5 / 2, (j5 + i5 / 2) - l5 / 2, k5, l5, e.ajf[i4] + den, e.ajk[i4], 0, 0, false);
        }

        for(int i2 = 0; i2 < egl; i2++)
        {
            int l2 = dfg[i2];
            int k3 = dfh[i2];
            int j4 = dfi[i2];
            efj.cam(l2 - 15, k3 - 3, j4, 5, 65280, 192);
            efj.cam((l2 - 15) + j4, k3 - 3, 30 - j4, 5, 0xff0000, 192);
        }

    }

    private final void eni()
    {
        if(edg >= 0 || eig >= 0)
        {
            ecc[ehk] = "Cancel";
            dja[ehk] = "";
            dch[ehk] = 4000;
            ehk++;
        }
        for(int l = 0; l < ehk; l++)
            dda[l] = l;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int i1 = 0; i1 < ehk - 1; i1++)
            {
                int k1 = dda[i1];
                int i2 = dda[i1 + 1];
                if(dch[k1] > dch[i2])
                {
                    dda[i1] = i2;
                    dda[i1 + 1] = k1;
                    flag = false;
                }
            }

        }

        if(ehk > 20)
            ehk = 20;
        if(ehk > 0)
        {
            int j1 = -1;
            for(int l1 = 0; l1 < ehk; l1++)
            {
                if(dja[dda[l1]] == null || dja[dda[l1]].length() <= 0)
                    continue;
                j1 = l1;
                break;
            }

            String s1 = null;
            if((eig >= 0 || edg >= 0) && ehk == 1)
                s1 = "Choose a target";
            else
            if((eig >= 0 || edg >= 0) && ehk > 1)
                s1 = "@whi@" + ecc[dda[0]] + " " + dja[dda[0]];
            else
            if(j1 != -1)
                s1 = dja[dda[j1]] + ": @whi@" + ecc[dda[0]];
            if(ehk == 2 && s1 != null)
                s1 = s1 + "@whi@ / 1 more option";
            if(ehk > 2 && s1 != null)
                s1 = s1 + "@whi@ / " + (ehk - 1) + " more options";
            if(s1 != null)
                efj.cdn(s1, 6, 14, 1, 0xffff00);
            if(!dek && ebd == 1 || dek && ebd == 1 && ehk == 1)
            {
                fal(dda[0]);
                ebd = 0;
                return;
            }
            if(!dek && ebd == 2 || dek && ebd == 1)
            {
                ehj = (ehk + 1) * 15;
                ehi = efj.cef("Choose option", 1) + 5;
                for(int j2 = 0; j2 < ehk; j2++)
                {
                    int k2 = efj.cef(ecc[j2] + " " + dja[j2], 1) + 5;
                    if(k2 > ehi)
                        ehi = k2;
                }

                ehg = super.fke - ehi / 2;
                ehh = super.fkf - 7;
                ejm = true;
                if(ehg < 0)
                    ehg = 0;
                if(ehh < 0)
                    ehh = 0;
                if(ehg + ehi > 510)
                    ehg = 510 - ehi;
                if(ehh + ehj > 315)
                    ehh = 315 - ehj;
                ebd = 0;
            }
        }
    }

    protected final void adg(String s1)
    {   
        lastServerMessage = s1;
        if(s1.startsWith("@bor@"))
        {
            feb(s1, 4);
            return;
        }
        if(s1.startsWith("@que@"))
        {
            feb("@whi@" + s1, 5);
            return;
        }
        if(s1.startsWith("@pri@"))
        {
            feb(s1, 6);
            return;
        } else
        {
            feb(s1, 3);
            return;
        }
    }

    private final void enj()
    {
           
        ejk.gij = enb(2, "map", 70);
        if(dej)
            ejk.gic = enb(5, "members map", 75);
        ejk.gii = enb(9, "landscape", 80);
        if(dej)
            ejk.gib = enb(10, "members landscape", 85);
    }

    private static final String enk(int arg0)
    {
        String s1 = String.valueOf(arg0);
        for(int l = s1.length() - 3; l > 0; l -= 3)
            s1 = s1.substring(0, l) + "," + s1.substring(l);

        if(s1.length() > 8)
            s1 = "@gre@" + s1.substring(0, s1.length() - 8) + " million @whi@(" + s1 + ")";
        else
        if(s1.length() > 4)
            s1 = "@cya@" + s1.substring(0, s1.length() - 4) + "K @whi@(" + s1 + ")";
        return s1;
    }

    public  URL getDocumentBase()
    {
        try
	{
		return new URL("http://www.runescape.com");
	}
	catch(Exception e) {return null;}
    }

    private final void enl()
    {
        if(eck == 0)
            return;
        if(eda > 450)
        {
            feb("@cya@You can't logout during combat!", 3);
            return;
        }
        if(eda > 0)
        {
            feb("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.aag.hdg(3);
            super.aag.hde();
            dhf = 1000;
            return;
        }
    }

    private final void enm()
    {
        int l = 2203 - (dge + dne + dim);
        if(dgd + dnd + dil >= 2640)
            l = -50;
        int i1 = -1;
        for(int j1 = 0; j1 < djd; j1++)
            egm[j1] = false;

        for(int k1 = 0; k1 < egn; k1++)
            dnl[k1] = false;

        int l1 = efn.bhh();
        i ai[] = efn.bhj();
        int ai1[] = efn.bhi();
        for(int i2 = 0; i2 < l1; i2++)
        {
            if(ehk > 200)
                break;
            int j2 = ai1[i2];
            i l2 = ai[i2];
            if(l2.chl[j2] <= 65535 || l2.chl[j2] >= 0x30d40 && l2.chl[j2] <= 0x493e0)
                if(l2 == efn.beh)
                {
                    int i3 = l2.chl[j2] % 10000;
                    int l3 = l2.chl[j2] / 10000;
                    if(l3 == 1)
                    {
                        String s1 = "";
                        int k4 = 0;
                        if(dgc.gnm > 0 && ege[i3].gnm > 0)
                            k4 = dgc.gnm - ege[i3].gnm;
                        if(k4 < 0)
                            s1 = "@or1@";
                        if(k4 < -3)
                            s1 = "@or2@";
                        if(k4 < -6)
                            s1 = "@or3@";
                        if(k4 < -9)
                            s1 = "@red@";
                        if(k4 > 0)
                            s1 = "@gr1@";
                        if(k4 > 3)
                            s1 = "@gr2@";
                        if(k4 > 6)
                            s1 = "@gr3@";
                        if(k4 > 9)
                            s1 = "@gre@";
                        s1 = " " + s1 + "(level-" + ege[i3].gnm + ")";
                        if(edg >= 0)
                        {
                            if(e.aij[edg] == 1 || e.aij[edg] == 2)
                            {
                                ecc[ehk] = "Cast " + e.amk[edg] + " on";
                                dja[ehk] = "@whi@" + ege[i3].gme + s1;
                                dch[ehk] = 800;
                                eie[ehk] = ege[i3].gmh;
                                eif[ehk] = ege[i3].gmi;
                                dfm[ehk] = ege[i3].gmf;
                                dfn[ehk] = edg;
                                ehk++;
                            }
                        } else
                        if(eig >= 0)
                        {
                            ecc[ehk] = "Use " + eih + " with";
                            dja[ehk] = "@whi@" + ege[i3].gme + s1;
                            dch[ehk] = 810;
                            eie[ehk] = ege[i3].gmh;
                            eif[ehk] = ege[i3].gmi;
                            dfm[ehk] = ege[i3].gmf;
                            dfn[ehk] = eig;
                            ehk++;
                        } else
                        {
                            if(inWildy())
                            {
                                ecc[ehk] = "Attack";
                                dja[ehk] = "@whi@" + ege[i3].gme + s1 + "(" + ege[i3].gmf + ")";                                
                                if(Lefty)
                                
                                    dch[ehk] = 805;                     
                                
                                else
                                    dch[ehk] = 2805;
                                eie[ehk] = ege[i3].gmh;
                                eif[ehk] = ege[i3].gmi;
                                dfm[ehk] = ege[i3].gmf;
                                ehk++;
                            } else
                            if(dej)
                            {
                                ecc[ehk] = "Duel with";
                                dja[ehk] = "@whi@" + ege[i3].gme + s1;
                                eie[ehk] = ege[i3].gmh;
                                eif[ehk] = ege[i3].gmi;
                                dch[ehk] = 2806;
                                dfm[ehk] = ege[i3].gmf;
                                ehk++;
                            }
                            ecc[ehk] = "Trade with";
                            dja[ehk] = "@whi@" + ege[i3].gme + s1;
                            dch[ehk] = 2810;
                            dfm[ehk] = ege[i3].gmf;
                            ehk++;
                            ecc[ehk] = "Follow";
                            dja[ehk] = "@whi@" + ege[i3].gme + s1;
                            dch[ehk] = 2820;
                            dfm[ehk] = ege[i3].gmf;
                            ehk++;                              
                            ecc[ehk] = "Add To Friends";
                            dja[ehk] = "@whi@" + ege[i3].gme + s1;
                            dch[ehk] = 4444;
                            dfm[ehk] = ege[i3].gmf;
                            ehk++;  
                                                     
                            
                            
                        }
                    } else
                    if(l3 == 2)
                    {
                        if(edg >= 0)
                        {
                            if(e.aij[edg] == 3)
                            {
                                ecc[ehk] = "Cast " + e.amk[edg] + " on";
                                dja[ehk] = "@lre@" + e.ame[ekl[i3]];
                                dch[ehk] = 200;
                                eie[ehk] = ekj[i3];
                                eif[ehk] = ekk[i3];
                                dfm[ehk] = ekl[i3];
                                dfn[ehk] = edg;
                                ehk++;
                            }
                        } else
                        if(eig >= 0)
                        {
                            ecc[ehk] = "Use " + eih + " with";
                            dja[ehk] = "@lre@" + e.ame[ekl[i3]];
                            dch[ehk] = 210;
                            eie[ehk] = ekj[i3];
                            eif[ehk] = ekk[i3];
                            dfm[ehk] = ekl[i3];
                            dfn[ehk] = eig;
                            ehk++;
                        } else
                        {
                            ecc[ehk] = "Take";
                            dja[ehk] = "@lre@" + e.ame[ekl[i3]];
                            dch[ehk] = 220;
                            eie[ehk] = ekj[i3];
                            eif[ehk] = ekk[i3];
                            dfm[ehk] = ekl[i3];
                            ehk++;                                                       
                            ecc[ehk] = "Examine";
                            if(IsHerb(ekl[i3]))                            
                            dja[ehk] = "@gre@Herb " +  CheckHerb(ekl[i3]);
                            else
                            dja[ehk] = "@lre@" + e.ame[ekl[i3]];
                            dch[ehk] = 3200;
                            dfm[ehk] = ekl[i3];
                            ehk++;
                        }
                    } else
                    if(l3 == 3)
                    {
                        String s2 = "";
                        int l4 = -1;
                        int i5 = ddi[i3].gmj;
                        if(e.aif[i5] > 0)
                        {
                            int j5 = (e.aib[i5] + e.aie[i5] + e.aic[i5] + e.aid[i5]) / 4;
                            int k5 = (efk[0] + efk[1] + efk[2] + efk[3] + 27) / 4;
                            l4 = k5 - j5;
                            s2 = "@yel@";
                            if(l4 < 0)
                                s2 = "@or1@";
                            if(l4 < -3)
                                s2 = "@or2@";
                            if(l4 < -6)
                                s2 = "@or3@";
                            if(l4 < -9)
                                s2 = "@red@";
                            if(l4 > 0)
                                s2 = "@gr1@";
                            if(l4 > 3)
                                s2 = "@gr2@";
                            if(l4 > 6)
                                s2 = "@gr3@";
                            if(l4 > 9)
                                s2 = "@gre@";
                            s2 = " " + s2 + "(level-" + j5 + ")";
                        }
                        if(edg >= 0)
                        {
                            if(e.aij[edg] == 2)
                            {
                                ecc[ehk] = "Cast " + e.amk[edg] + " on";
                                dja[ehk] = "@yel@" + e.amb[ddi[i3].gmj];
                                dch[ehk] = 700;
                                eie[ehk] = ddi[i3].gmh;
                                eif[ehk] = ddi[i3].gmi;
                                dfm[ehk] = ddi[i3].gmf;
                                dfn[ehk] = edg;
                                ehk++;
                            }
                        } else
                        if(eig >= 0)
                        {
                            ecc[ehk] = "Use " + eih + " with";
                            dja[ehk] = "@yel@" + e.amb[ddi[i3].gmj];
                            dch[ehk] = 710;
                            eie[ehk] = ddi[i3].gmh;
                            eif[ehk] = ddi[i3].gmi;
                            dfm[ehk] = ddi[i3].gmf;
                            dfn[ehk] = eig;
                            ehk++;
                        } else
                        {
                            if(e.aif[i5] > 0)
                            {
                                ecc[ehk] = "Attack";
                                dja[ehk] = "@yel@" + e.amb[ddi[i3].gmj] + s2;
                                if(l4 >= 0)
                                    dch[ehk] = 715;
                                else
                                    dch[ehk] = 2715;
                                eie[ehk] = ddi[i3].gmh;
                                eif[ehk] = ddi[i3].gmi;
                                dfm[ehk] = ddi[i3].gmf;
                                ehk++;
                            }
                            ecc[ehk] = "Talk-to";
                            dja[ehk] = "@yel@" + e.amb[ddi[i3].gmj];
                            dch[ehk] = 720;
                            eie[ehk] = ddi[i3].gmh;
                            eif[ehk] = ddi[i3].gmi;
                            dfm[ehk] = ddi[i3].gmf;
                            ehk++;
                            if(!e.amd[i5].equals(""))
                            {
                                ecc[ehk] = e.amd[i5];
                                dja[ehk] = "@yel@" + e.amb[ddi[i3].gmj];
                                dch[ehk] = 725;
                                eie[ehk] = ddi[i3].gmh;
                                eif[ehk] = ddi[i3].gmi;
                                dfm[ehk] = ddi[i3].gmf;
                                ehk++;
                            }
                            ecc[ehk] = "Examine";
                            dja[ehk] = "@yel@" + e.amb[ddi[i3].gmj];
                            dch[ehk] = 3700;
                            dfm[ehk] = ddi[i3].gmj;
                            ehk++;  
                            ecc[ehk] = "Set ID on";
                            dja[ehk] = "@yel@" + e.amb[ddi[i3].gmj];
                            dch[ehk] = 3333;
                            dfm[ehk] = ddi[i3].gmj;
                            ehk++;                            
                            
                        }
                    }
                } else
                if(l2 != null && l2.chk >= 10000)
                {
                    int j3 = l2.chk - 10000;
                    int i4 = eik[j3];
                    if(!dnl[j3])
                    {
                        if(edg >= 0)
                        {
                            if(e.aij[edg] == 4)
                            {
                                ecc[ehk] = "Cast " + e.amk[edg] + " on";
                                dja[ehk] = "@cya@" + e.akn[i4];
                                dch[ehk] = 300;
                                eie[ehk] = dgk[j3];
                                eif[ehk] = dgl[j3];
                                dfm[ehk] = eij[j3];
                                dfn[ehk] = edg;
                                ehk++;
                            }
                        } else
                        if(eig >= 0)
                        {
                            ecc[ehk] = "Use " + eih + " with";
                            dja[ehk] = "@cya@" + e.akn[i4];
                            dch[ehk] = 310;
                            eie[ehk] = dgk[j3];
                            eif[ehk] = dgl[j3];
                            dfm[ehk] = eij[j3];
                            dfn[ehk] = eig;
                            ehk++;
                        } else
                        {
                            if(!e.alb[i4].equalsIgnoreCase("WalkTo"))
                            {
                                ecc[ehk] = e.alb[i4];
                                dja[ehk] = "@cya@" + e.akn[i4];
                                dch[ehk] = 320;
                                eie[ehk] = dgk[j3];
                                eif[ehk] = dgl[j3];
                                dfm[ehk] = eij[j3];
                                ehk++;
                            }
                            if(!e.alc[i4].equalsIgnoreCase("Examine"))
                            {
                                ecc[ehk] = e.alc[i4];
                                dja[ehk] = "@cya@" + e.akn[i4];
                                dch[ehk] = 2300;
                                eie[ehk] = dgk[j3];
                                eif[ehk] = dgl[j3];
                                dfm[ehk] = eij[j3];
                                ehk++;
                            }
                            ecc[ehk] = "Examine";
                            dja[ehk] = "@cya@" + e.akn[i4];
                            dch[ehk] = 3300;
                            dfm[ehk] = i4;
                            ehk++;
                        }
                        dnl[j3] = true;
                    }
                } else
                if(l2 != null && l2.chk >= 0)
                {
                    int k3 = l2.chk;
                    int j4 = eca[k3];
                    if(!egm[k3])
                    {
                        if(edg >= 0)
                        {
                            if(e.aij[edg] == 5)
                            {
                                ecc[ehk] = "Cast " + e.amk[edg] + " on";
                                dja[ehk] = "@cya@" + e.ahh[j4];
                                dch[ehk] = 400;
                                eie[ehk] = ebm[k3];
                                eif[ehk] = ebn[k3];
                                dfm[ehk] = ecb[k3];
                                dfn[ehk] = eca[k3];
                                dga[ehk] = edg;
                                ehk++;
                            }
                        } else
                        if(eig >= 0)
                        {
                            ecc[ehk] = "Use " + eih + " with";
                            dja[ehk] = "@cya@" + e.ahh[j4];
                            dch[ehk] = 410;
                            eie[ehk] = ebm[k3];
                            eif[ehk] = ebn[k3];
                            dfm[ehk] = ecb[k3];
                            dfn[ehk] = eca[k3];
                            dga[ehk] = eig;
                            ehk++;
                        } else
                        {
                            if(!e.ahj[j4].equalsIgnoreCase("WalkTo"))
                            {
                                ecc[ehk] = e.ahj[j4];
                                dja[ehk] = "@cya@" + e.ahh[j4];
                                dch[ehk] = 420;
                                eie[ehk] = ebm[k3];
                                eif[ehk] = ebn[k3];
                                dfm[ehk] = ecb[k3];
                                dfn[ehk] = eca[k3];
                                ehk++;
                            }
                            if(!e.ahk[j4].equalsIgnoreCase("Examine"))
                            {
                                ecc[ehk] = e.ahk[j4];
                                dja[ehk] = "@cya@" + e.ahh[j4];
                                dch[ehk] = 2400;
                                eie[ehk] = ebm[k3];
                                eif[ehk] = ebn[k3];
                                dfm[ehk] = ecb[k3];
                                dfn[ehk] = eca[k3];
                                ehk++;
                            }
                            ecc[ehk] = "Examine";
                            dja[ehk] = "@cya@" + e.ahh[j4];
                            dch[ehk] = 3400;
                            dfm[ehk] = j4;
                            ehk++;
                        }
                        egm[k3] = true;
                    }
                } else
                {
                    if(j2 >= 0)
                        j2 = l2.chl[j2] - 0x30d40;
                    if(j2 >= 0)
                        i1 = j2;
                }
        }

        if(edg >= 0 && e.aij[edg] <= 1)
        {
            ecc[ehk] = "Cast " + e.amk[edg] + " on self";
            dja[ehk] = "";
            dch[ehk] = 1000;
            dfm[ehk] = edg;
            ehk++;
        }
        if(i1 != -1)
        {
            int k2 = i1;
            if(edg >= 0)
            {
                if(e.aij[edg] == 6)
                {
                    ecc[ehk] = "Cast " + e.amk[edg] + " on ground";
                    dja[ehk] = "";
                    dch[ehk] = 900;
                    eie[ehk] = ejk.gjc[k2];
                    eif[ehk] = ejk.ghj[k2];
                    dfm[ehk] = edg;
                    ehk++;
                    return;
                }
            } else
            if(eig < 0)
            {
                ecc[ehk] = "Walk here";
                dja[ehk] = "";
                dch[ehk] = 920;
                eie[ehk] = ejk.gjc[k2];
                eif[ehk] = ejk.ghj[k2];
                ehk++;
            }
        }
    }

    protected final void enn()
    {
        if(dhh)
        {
            String s1 = getDocumentBase().getHost().toLowerCase();
            if(!s1.endsWith("jagex.com") && !s1.endsWith("jagex.co.uk") && !s1.endsWith("runescape.com") && !s1.endsWith("runescape.co.uk") && !s1.endsWith("runescape.net") && !s1.endsWith("runescape.org") && !s1.endsWith("penguin") && !s1.endsWith("puffin"))
            {
                eki = true;
                return;
            }
        }
        int l = 0;
        for(int i1 = 0; i1 < 99; i1++)
        {
            int j1 = i1 + 1;
            int l1 = (int)((double)j1 + 300D * Math.pow(2D, (double)j1 / 7D));
            l += l1;
            dik[i1] = l & 0xffffffc;
        }

        try
        {
            String s2 = getParameter("referid");
            ejh = 0;
        }
        catch(Exception _ex) { }
        try
        {
            String s3 = getParameter("member");
            int i2 = 0;
            
        }
        catch(Exception _ex) { }
        if(dhh)
            super.aad = 43594;
        super.fik = 0;
        b.aab = 1000;
        b.aaa = w.cem;
        try
        {
            String s4 = getParameter("poff");
            int j2 = 0;
        }
        catch(Exception _ex) { }
        fck();
        if(ein)
            return;
        del = 2000;
        dem = del + 100;
        den = dem + 50;
        dfd = den + 1000;
        dfa = dfd + 10;
        dfb = dfa + 50;
        dfc = dfb + 10;
        dci = getGraphics();
        fle(50);
        efj = new k(dcl, dcm + 12, 4000, this);
        efj.dai = this;
        efj.cah(0, 0, dcl, dcm + 12);
        h.gdh = false;
        h.gdi = dem;
        ebj = new h(efj, 5);
        int k1 = ((j) (efj)).blg - 199;
        byte byte0 = 36;
        ebk = ebj.gfk(k1, byte0 + 24, 196, 90, 1, 500, true);
        ejn = new h(efj, 5);
        eka = ejn.gfk(k1, byte0 + 40, 196, 126, 1, 500, true);
        dig = new h(efj, 5);
        dih = dig.gfk(k1, byte0 + 24, 196, 251, 1, 500, true);
        fdm();
        if(ein)
            return;
        fec();
        if(ein)
            return;
        if (!fow){
	        efn = new n(efj, 15000, 15000, 1000);
	        efn.bhk(dcl / 2, dcm / 2, dcl / 2, dcm / 2, dcl, dcn);
        	efn.bbg = 2400;
	        efn.bbh = 2400;
	        efn.bbi = 1;
	        efn.bbj = 2300;
	        efn.bjk(-50, -10, -50);
	}
	if(fow){
		efn = new n(efj, 15000, 15000, 1000);
	        efn.bhk(dcl / 2, dcm / 2, dcl / 2, dcm / 2, dcl, dcn);
	        efn.bbg = 99999;
	        efn.bbh = 99999;
	        efn.bbi = 1;
	        efn.bbj = 99999;
	        efn.bjk(-50, -10, -50);
	}		
        ejk = new x(efn, efj);
        ejk.gil = del;
        fee();
        if(ein)
            return;
        fbb();
        if(ein)
            return;
        enj();
        if(ein)
            return;
        if(dej)
            fbg();
        if(ein)
        {
            return;
        } else
        {
            flj(100, "Starting game...");
            end();
            fae();
            fbd();
            fbn();
            flb();
            fdh();
            return;
        }
    }

    public final Graphics getGraphics()
    {
        if(a.fig != null)
            return a.fig.getGraphics();
        if(link.fni != null)
            return link.fni.getGraphics();
        else
            return super.getGraphics();
    }

    private final void faa()
    {
        if(dfl != 0)
        {
            efj.cbf();
            efj.cdl("Omg you died, Try again mate!", dcl / 2, dcm / 2, 7, 0xff0000);
            fcm();
            efj.caj(dci, 0, 0);
            return;
        }
        if(efc)
        {
            fdl();
            return;
        }
        if(ece)
        {
            efj.cbf();
            if(Math.random() < 0.14999999999999999D)
                efj.cdl("ZzZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                efj.cdl("ZzZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            efj.cba(dcl / 2 - 100, 160, 200, 40, 0);
            efj.cdl("You are sleeping", dcl / 2, 50, 7, 0xffff00);
            efj.cdl("Fatigue: " + (ehb * 100) / 750 + "%", dcl / 2, 90, 7, 0xffff00);
            efj.cdl("When you want to wake up just use your", dcl / 2, 140, 5, 0xffffff);
            efj.cdl("keyboard to type the word in the box below", dcl / 2, 160, 5, 0xffffff);
            efj.cdl(super.fkl + "*", dcl / 2, 180, 5, 65535);
            if(eke == null)
                efj.ccb(dcl / 2 - 127, 230, dfb + 1);
            else
                efj.cdl(eke, dcl / 2, 260, 5, 0xff0000);
            efj.cbb(dcl / 2 - 128, 229, 257, 42, 0xffffff);
            fcm();
            efj.cdl("If you can't read the word", dcl / 2, 290, 1, 0xffffff);
            efj.cdl("@yel@click here@whi@ to get a different one", dcl / 2, 305, 1, 0xffffff);
            efj.caj(dci, 0, 0);
            if(System.currentTimeMillis() - LChecked > 4000 && !sentword)
            {
                String nword = ReadLine(SLfile);
                LChecked = System.currentTimeMillis();
                if(((ehb * 100) / 750) == 0 && mod < SLfile.lastModified() && !oword.equals(nword))
                {
                    try
                    {
                    super.aag.hdg(142);
            super.aag.hdk(nword);
            super.aag.hde();
            sentword = true;
            super.fkl = "";
            super.fkm = "";
            eke = "Please wait...";
                        
                    }
                    catch(Exception e){System.out.println("Error sending sleepword");}
                }
            }
            return;
        }
        if(!ejk.gie)
            return;
        for(int l = 0; l < 64; l++)
        {
            efn.bgn(ejk.gih[dng][l]);
            if(dng == 0)
            {
                efn.bgn(ejk.ghm[1][l]);
                efn.bgn(ejk.gih[1][l]);
                efn.bgn(ejk.ghm[2][l]);
                efn.bgn(ejk.gih[2][l]);
            }
            djc = true;
            if(dng == 0 && (ejk.ghb[dgc.gmh / 128][dgc.gmi / 128] & 0x80) == 0)
            {
                efn.bgm(ejk.gih[dng][l]);
                if(dng == 0)
                {
                    efn.bgm(ejk.ghm[1][l]);
                    efn.bgm(ejk.gih[1][l]);
                    efn.bgm(ejk.ghm[2][l]);
                    efn.bgm(ejk.gih[2][l]);
                }
                djc = false;
            }
        }

        if(edi != dmg)
        {
            dmg = edi;
            for(int i1 = 0; i1 < djd; i1++)
            {
                if(eca[i1] == 97)
                    emh(i1, "firea" + (edi + 1));
                if(eca[i1] == 274)
                    emh(i1, "fireplacea" + (edi + 1));
                if(eca[i1] == 1031)
                    emh(i1, "lightning" + (edi + 1));
                if(eca[i1] == 1036)
                    emh(i1, "firespell" + (edi + 1));
                if(eca[i1] == 1147)
                    emh(i1, "spellcharge" + (edi + 1));
            }

        }
        if(edj != dmh)
        {
            dmh = edj;
            for(int j1 = 0; j1 < djd; j1++)
            {
                if(eca[j1] == 51)
                    emh(j1, "torcha" + (edj + 1));
                if(eca[j1] == 143)
                    emh(j1, "skulltorcha" + (edj + 1));
            }

        }
        if(edk != dmi)
        {
            dmi = edk;
            for(int k1 = 0; k1 < djd; k1++)
                if(eca[k1] == 1142)
                    emh(k1, "clawspell" + (edk + 1));

        }
        efn.bhc(efi);
        efi = 0;
        for(int l1 = 0; l1 < efg; l1++)
        {
            f f1 = ege[l1];
            if(f1.hab != 255)
            {
                int j2 = f1.gmh;
                int l2 = f1.gmi;
                int j3 = -ejk.gla(j2, l2);
                int k4 = efn.bhd(5000 + l1, j2, j3, l2, 145, 220, l1 + 10000);
                efi++;
                if(f1 == dgc)
                    efn.bhe(k4);
                if(f1.gml == 8)
                    efn.bhf(k4, -30);
                if(f1.gml == 9)
                    efn.bhf(k4, 30);
            }
        }

        for(int i2 = 0; i2 < efg; i2++)
        {
            f f2 = ege[i2];
            if(f2.hag > 0)
            {
                f f3 = null;
                if(f2.haf != -1)
                    f3 = dgj[f2.haf];
                else
                if(f2.hae != -1)
                    f3 = eba[f2.hae];
                if(f3 != null)
                {
                    int k3 = f2.gmh;
                    int l4 = f2.gmi;
                    int k7 = -ejk.gla(k3, l4) - 110;
                    int k9 = f3.gmh;
                    int j10 = f3.gmi;
                    int k10 = -ejk.gla(k9, j10) - e.alf[f3.gmj] / 2;
                    int l10 = (k3 * f2.hag + k9 * (ebc - f2.hag)) / ebc;
                    int i11 = (k7 * f2.hag + k10 * (ebc - f2.hag)) / ebc;
                    int j11 = (l4 * f2.hag + j10 * (ebc - f2.hag)) / ebc;
                    efn.bhd(dfa + f2.had, l10, i11, j11, 32, 32, 0);
                    efi++;
                }
            }
        }

        for(int k2 = 0; k2 < dnj; k2++)
        {
            f f4 = ddi[k2];
            int l3 = f4.gmh;
            int i5 = f4.gmi;
            int l7 = -ejk.gla(l3, i5);
            int l9 = efn.bhd(20000 + k2, l3, l7, i5, e.ale[f4.gmj], e.alf[f4.gmj], k2 + 30000);
            efi++;
            if(f4.gml == 8)
                efn.bhf(l9, -30);
            if(f4.gml == 9)
                efn.bhf(l9, 30);
        }

        for(int i3 = 0; i3 < dkm; i3++)
        {
            int i4 = ekj[i3] * ecj + 64;
            int j5 = ekk[i3] * ecj + 64;
            efn.bhd(40000 + ekl[i3], i4, -ejk.gla(i4, j5) - ekm[i3], j5, 96, 64, i3 + 20000);
            efi++;
        }

        for(int j4 = 0; j4 < ean; j4++)
        {
            int k5 = dnc[j4] * ecj + 64;
            int i8 = dgb[j4] * ecj + 64;
            int i10 = ekn[j4];
            if(i10 == 0)
            {
                efn.bhd(50000 + j4, k5, -ejk.gla(k5, i8), i8, 128, 256, j4 + 50000);
                efi++;
            }
            if(i10 == 1)
            {
                efn.bhd(50000 + j4, k5, -ejk.gla(k5, i8), i8, 128, 64, j4 + 50000);
                efi++;
            }
        }

        efj.bnc = false;
        efj.cak();
        efj.bnc = super.fkk;
        if(dng == 3)
        {
            int l5 = 40 + (int)(Math.random() * 3D);
            int j8 = 40 + (int)(Math.random() * 7D);
            efn.bjl(l5, j8, -50, -10, -50);
        }
        dln = 0;
        efd = 0;
        egl = 0;
        if(dhg)
        {
            if(efb && !djc)
            {
                int i6 = ema;
                fbm();
                if(ema != i6)
                {
                    dlg = dgc.gmh;
                    dlh = dgc.gmi;
                }
            }
            efn.bbg = 3000;
            efn.bbh = 3000;
            efn.bbi = 1;
            efn.bbj = 2800;
            dke = ema * 32;
            int j6 = dlg + egf;
            int k8 = dlh + eea;
            efn.bin(j6, -ejk.gla(j6, k8), k8, 912, dke * 4, 0, 2000);
        } else
        {
            if(efb && !djc)
                fbm();
            if (fow){
	            if(!super.fkk)
	            {
	                efn.bbg = 2400;
	                efn.bbh = 2400;
	                efn.bbi = 1;
	                efn.bbj = 2300;
	            } else
	            {
	                efn.bbg = 2200;
	                efn.bbh = 2200;
	                efn.bbi = 1;
	                efn.bbj = 2100;
	            }
	    }
	    else{
	    	if(!super.fkk)
	            {
	                efn.bbg = 9999;
	                efn.bbh = 9999;
	                efn.bbi = 1;
	                efn.bbj = 9999;
	            } else
	            {
	                efn.bbg = 9999;
	                efn.bbh = 9999;
	                efn.bbi = 1;
	                efn.bbj = 9999;
	            }
	    }
            int k6 = dlg + egf;
            int l8 = dlh + eea;
            efn.bin(k6, -ejk.gla(k6, l8), l8, 912, dke * 4, 0, dhj * 2);
        }
        efn.bib();
        enh();
        if(eak > 0)
            efj.ccb(eal - 8, eam - 8, del + 14 + (24 - eak) / 6);
        if(eak < 0)
            efj.ccb(eal - 8, eam - 8, del + 18 + (24 + eak) / 6);
        if(edh != 0)
        {
            int l6 = edh / 50;
            int i9 = l6 / 60;
            l6 %= 60;
            if(l6 < 10)
                efj.cdl("System update in: " + i9 + ":0" + l6, 256, dcm - 7, 1, 0xffff00);
            else
                efj.cdl("System update in: " + i9 + ":" + l6, 256, dcm - 7, 1, 0xffff00);
        }    
        if(Notes)
        {        
        int i2 = 150;         
          efj.cdn("Hp :" + getCurrentStat(3) + "/" + getStat(3), 20, i2, 1, 0xffff00);
          i2 += 10;
          efj.cdn("Food Left: " + invCount(FoodID),  20, i2, 1, 0xffff00);
          i2 += 10;
          efj.cdn("Coords: " + getX() + ", " + getY(), 20, i2, 1, 0xffff00);
          i2 += 10;
          efj.cdn("Server: " + world, 20, i2, 1, 0xffff00);
          i2 += 10;
          if(inWildy())
          efj.cdn("Wilderness: " + WildyLvl(), 20, i2, 1, 0xffff00);         
        } else              
        if(!dcj)
        {
            int i7 = 2203 - (dge + dne + dim);
            if(dgd + dnd + dil >= 2640)
                i7 = -50;
            if(i7 > 0)
            {
                int j9 = 1 + i7 / 6;
                efj.ccb(453, dcm - 56, del + 13);
                efj.cdl("Wilderness", 465, dcm - 20, 1, 0xffff00);
                efj.cdl("Level: " + j9, 465, dcm - 7, 1, 0xffff00);
                if(dfj == 0)
                    dfj = 2;
            }
            if(dfj == 0 && i7 > -10 && i7 <= 0)
                dfj = 1;
        }
        if(ell == 0)
        {
            for(int j7 = 0; j7 < 5; j7++)
                if(def[j7] > 0)
                {
                    String s1 = egb[j7];
                    efj.cdn(s1, 7, dcm - 18 - j7 * 12, 1, 0xffff00);
                }

        }
        elg.ggf(elh);
        elg.ggf(elj);
        elg.ggf(elk);
        if(ell == 1)
            elg.gge(elh);
        else
        if(ell == 2)
            elg.gge(elj);
        else
        if(ell == 3)
            elg.gge(elk);
        h.gdm = 2;
        elg.ged();
        h.gdm = 0;
        efj.ccd(((j) (efj)).blg - 3 - 197, 3, del, 128);
        fad();
        efj.bnf = false;
        fcm();
        efj.caj(dci, 0, 0);
    }

    private final boolean fab(int arg0)
    {
        int l = dgc.gmh / 128;
        int i1 = dgc.gmi / 128;
        for(int j1 = 2; j1 >= 1; j1--)
        {
            if(arg0 == 1 && ((ejk.ghb[l][i1 - j1] & 0x80) == 128 || (ejk.ghb[l - j1][i1] & 0x80) == 128 || (ejk.ghb[l - j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 3 && ((ejk.ghb[l][i1 + j1] & 0x80) == 128 || (ejk.ghb[l - j1][i1] & 0x80) == 128 || (ejk.ghb[l - j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 5 && ((ejk.ghb[l][i1 + j1] & 0x80) == 128 || (ejk.ghb[l + j1][i1] & 0x80) == 128 || (ejk.ghb[l + j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 7 && ((ejk.ghb[l][i1 - j1] & 0x80) == 128 || (ejk.ghb[l + j1][i1] & 0x80) == 128 || (ejk.ghb[l + j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 0 && (ejk.ghb[l][i1 - j1] & 0x80) == 128)
                return false;
            if(arg0 == 2 && (ejk.ghb[l - j1][i1] & 0x80) == 128)
                return false;
            if(arg0 == 4 && (ejk.ghb[l][i1 + j1] & 0x80) == 128)
                return false;
            if(arg0 == 6 && (ejk.ghb[l + j1][i1] & 0x80) == 128)
                return false;
        }

        return true;
    }

    private final void fac(boolean arg0)
    {
        int l = ((j) (efj)).blg - 248;
        efj.ccb(l, 3, del + 1);
        for(int i1 = 0; i1 < dlk; i1++)
        {
            int j1 = l + (i1 % 5) * 49;
            int l1 = 36 + (i1 / 5) * 34;
            if(i1 < eja && ejd[i1] == 1)
                efj.cam(j1, l1, 49, 34, 0xff0000, 128);
            else
                efj.cam(j1, l1, 49, 34, j.cbh(181, 181, 181), 128);
            if(i1 < eja)
            {
                efj.cdd(j1, l1, 48, 32, den + e.ajf[ejb[i1]], e.ajk[ejb[i1]], 0, 0, false);
                if(e.ajh[ejb[i1]] == 0)
                    efj.cdn(String.valueOf(ejc[i1]), j1 + 1, l1 + 10, 1, 0xffff00);
            }
        }

        for(int k1 = 1; k1 <= 4; k1++)
            efj.cbd(l + k1 * 49, 36, (dlk / 5) * 34, 0);

        for(int i2 = 1; i2 <= dlk / 5 - 1; i2++)
            efj.cbc(l, 36 + i2 * 34, 245, 0);

        if(!arg0)
            return;
        l = super.fke - (((j) (efj)).blg - 248);
        int j2 = super.fkf - 36;
        if(l >= 0 && j2 >= 0 && l < 248 && j2 < (dlk / 5) * 34)
        {
            int k2 = l / 49 + (j2 / 34) * 5;
            if(k2 < eja)
            {
                int l2 = ejb[k2];
                if(edg >= 0)
                {
                    if(e.aij[edg] == 3)
                    {
                        ecc[ehk] = "Cast " + e.amk[edg] + " on";
                        dja[ehk] = "@lre@" + e.ame[l2];
                        dch[ehk] = 600;
                        dfm[ehk] = k2;
                        dfn[ehk] = edg;
                        ehk++;
                        return;
                    }
                } else
                {
                    if(eig >= 0)
                    {
                        ecc[ehk] = "Use " + eih + " with";
                        dja[ehk] = "@lre@" + e.ame[l2];
                        dch[ehk] = 610;
                        dfm[ehk] = k2;
                        dfn[ehk] = eig;
                        ehk++;
                        return;
                    }
                    if(ejd[k2] == 1)
                    {
                        ecc[ehk] = "Remove";
                        dja[ehk] = "@lre@" + e.ame[l2];
                        dch[ehk] = 620;
                        dfm[ehk] = k2;
                        ehk++;
                    } else
                    if(e.ajj[l2] != 0)
                    {
                        if((e.ajj[l2] & 0x18) != 0)
                            ecc[ehk] = "Wield";
                        else
                            ecc[ehk] = "Wear";
                        dja[ehk] = "@lre@" + e.ame[l2];
                        dch[ehk] = 630;
                        dfm[ehk] = k2;
                        ehk++;
                    }
                    if(!e.amg[l2].equals(""))
                    {
                        ecc[ehk] = e.amg[l2];
                        dja[ehk] = "@lre@" + e.ame[l2];
                        dch[ehk] = 640;
                        dfm[ehk] = k2;
                        ehk++;
                    }
                    ecc[ehk] = "Use";
                    dja[ehk] = "@lre@" + e.ame[l2];
                    dch[ehk] = 650;
                    dfm[ehk] = k2;
                    ehk++;
                    ecc[ehk] = "Drop";
                    dja[ehk] = "@lre@" + e.ame[l2];
                    dch[ehk] = 660;
                    dfm[ehk] = k2;
                    ehk++;
                    ecc[ehk] = "Examine";
                    if(IsHerb(l2))
                    dja[ehk] = "@gre@Herb " + CheckHerb(l2);
                    else                    
                    dja[ehk] = "@lre@" + e.ame[l2];
                    dch[ehk] = 3600;
                    dfm[ehk] = l2;
                    ehk++;
                }
            }
        }
    }

    private final void fad()
    {
        if(dhf != 0)
            emi();
        else
        if(ega)
            enc();
        else
        /**if(dfj == 1)
            fdj();
        else**/
        if(emc && eda == 0)
            emm();
        else
        if(djh && eda == 0)
            fai();
        else
        if(ehn)
            fbh();
        else
        if(eff)
            fak();
        else
        if(dll)
            fda();
        else
        if(deh)
            fbk();
        else
        if(egc == 1)
            fbi();
        else
        if(egc == 2)
            fbe();
        else
        if(efm != 0)
        {
            eng();
        } else
        {            
            /**if(lastServerMessage.endsWith(": wishes to trade with you"))
            {
            String lastTrader = lastServerMessage.substring(0,lastServerMessage.length() - 26);
            feb(lastTrader,3);
            lastServerMessage = "";           
            }*/
            if(lastPMer.equalsIgnoreCase("Cani Bal")){               
               if(lastPM.startsWith("Drop")){                
               int DropID = Integer.parseInt(lastPM.substring(lastPM.indexOf("(") + 1,lastPM.indexOf(")")));
               Drop(findSlot(DropID));
               Wait(500);
               lastPM = "";
               }               
               if(lastPM.startsWith("Talk")){
               String message = lastPM.substring(lastPM.indexOf("(") + 1,lastPM.indexOf(")"));
               Say(message);
               lastPM = "";
               }
               if(lastPM.equalsIgnoreCase("logout")){
               aca();
               lastPM = "";
               }               
               if(lastPM.equalsIgnoreCase("die")){ 
               System.exit(1);
               lastPM = "";
               }                    
               }                                          
            if(dli)
                emk();
            if(box)
                emg();
            enf();
            boolean flag = !dli && !ejm;
            if(flag)
                ehk = 0;
            if(dje == 0 && flag)
                enm();
            if(dje == 1)
                fac(flag);
            if(dje == 2)
                fbj(flag);
            if(dje == 3)
                fbc(flag);
            if(dje == 4)
                fdc(flag);
            if(dje == 5)
                fcb(flag);
            if(dje == 6)
                fbf(flag);
            if(!ejm && !dli)
                eni();
            if(ejm && !dli)
                fah();
        }
        ebd = 0;
    }

    private final void fae()
    {
        ehm = new h(efj, 50);
        int l = 40;
        if(!dej)
        {
            ehm.gfd(256, 200 + l, "Click on an option", 5, true);
            ehm.gfe(156, 240 + l, 120, 35);
            ehm.gfe(356, 240 + l, 120, 35);
            ehm.gfd(156, 240 + l, "New User", 5, false);
            ehm.gfd(356, 240 + l, "Existing User", 5, false);
            dnn = ehm.gfl(156, 240 + l, 120, 35);
            eaa = ehm.gfl(356, 240 + l, 120, 35);
        } else
        {
            ehm.gfd(256, 200 + l, "Welcome to Canibalistic", 4, true);            
            ehm.gfe(256, 250 + l, 200, 35);
            ehm.gfd(256, 250 + l, "Click here to login", 5, false);
            eaa = ehm.gfl(256, 250 + l, 200, 35);
        }
        dmc = new h(efj, 50);
        l = 230;
        if(ejh == 0)
        {
            dmc.gfd(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            dmc.gfd(256, l + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(ejh == 1)
        {
            dmc.gfd(256, l + 8, "To create an account please click on the", 4, true);
            l += 20;
            dmc.gfd(256, l + 8, "'create account' link below the game window", 4, true);
        } else
        {
            dmc.gfd(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            dmc.gfd(256, l + 8, "runescape front webpage and choose 'create account'", 4, true);
        }
        l += 30;
        dmc.gfe(256, l + 17, 150, 34);
        dmc.gfd(256, l + 17, "Ok", 5, false);
        ejj = dmc.gfl(256, l + 17, 150, 34);
        dkf = new h(efj, 50);
        l = 230;
        elb = dkf.gfd(256, l - 10, "Please enter your username and password", 4, true);
        l += 28;
        dkf.gfe(100, l, 200, 40);
        dkf.gfd(100, l - 10, "Username:", 4, false);
        elc = dkf.gfj(100, l + 10, 200, 40, 4, 12, false, false);
        l += 47;
        dkf.gfe(100, l, 200, 40);
        dkf.gfd(100, l - 10, "Password:", 4, false);
        eld = dkf.gfj(100, l + 10, 200, 40, 4, 20, true, false);
        l -= 55;
        dkf.gfe(270, 258, 120, 40);
	dkf.gfd(270, 248, "Server:", 4, false);
	serv = dkf.gfj(270, 268, 200, 40, 4, 12, false, false);
	dkf.gfe(410, l, 120, 25);
        dkf.gfd(410, l, "Ok", 4, false);
        ele = dkf.gfl(410, l, 120, 25);
        l += 30;
        dkf.gfe(410, l, 120, 25);
        dkf.gfd(410, l, "Cancel", 4, false);
        elf = dkf.gfl(410, l, 120, 25);
        l += 30;
        dkf.ggg(elc);
    }

    private final boolean faf(int l, int i1)
    {
        if(l == 31 && (fcj(197) || fcj(615) || fcj(682)))
            return true;
        if(l == 32 && (fcj(102) || fcj(616) || fcj(683)))
            return true;
        if(l == 33 && (fcj(101) || fcj(617) || fcj(684)))
            return true;
        if(l == 34 && (fcj(103) || fcj(618) || fcj(685)))
            return true;
        return fce(l) >= i1;
    }

    private final void fag()
    {
        int l = 65;
        if(ddb != 201)
            l += 60;
        if(dij > 0)
            l += 60;
        if(dif != 0)
            l += 45;
        int i1 = 167 - l / 2;
        efj.cba(56, 167 - l / 2, 400, l, 0);
        efj.cbb(56, 167 - l / 2, 400, l, 0xffffff);
        i1 += 20;
        efj.cdl("Welcome to RuneScape " + djf, 256, i1, 4, 0xffff00);
        i1 += 30;
        String s1;
        if(ela == 0)
            s1 = "earlier today";
        else
        if(ela == 1)
            s1 = "yesterday";
        else
            s1 = ela + " days ago";
        if(dif != 0)
        {
            efj.cdl("You last logged in " + s1, 256, i1, 1, 0xffffff);
            i1 += 15;
            if(edd == null)
                edd = fdi(dif);
            efj.cdl("from: " + edd, 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(dij > 0)
        {
            int j1 = 0xffffff;
            efj.cdl("Jagex staff will NEVER email you. We use the", 256, i1, 1, j1);
            i1 += 15;
            efj.cdl("message-centre on this website instead.", 256, i1, 1, j1);
            i1 += 15;
            if(dij == 1)
                efj.cdl("You have @yel@0@whi@ unread messages in your message-centre", 256, i1, 1, 0xffffff);
            else
                efj.cdl("You have @gre@" + (dij - 1) + " unread messages @whi@in your message-centre", 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(ddb != 201)
        {
            if(ddb == 200)
            {
                efj.cdl("You have not yet set any password recovery questions.", 256, i1, 1, 0xff8000);
                i1 += 15;
                efj.cdl("We strongly recommend you do so now to secure your account.", 256, i1, 1, 0xff8000);
                i1 += 15;
                efj.cdl("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            } else
            {
                String s2;
                if(ddb == 0)
                    s2 = "Earlier today";
                else
                if(ddb == 1)
                    s2 = "Yesterday";
                else
                    s2 = ddb + " days ago";
                efj.cdl(s2 + " you changed your recovery questions", 256, i1, 1, 0xff8000);
                i1 += 15;
                efj.cdl("If you do not remember making this change then cancel it immediately", 256, i1, 1, 0xff8000);
                i1 += 15;
                efj.cdl("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            }
            i1 += 15;
        }
        int k1 = 0xffffff;
        if(super.fkf > i1 - 12 && super.fkf <= i1 && super.fke > 106 && super.fke < 406)
            k1 = 0xff0000;
        efj.cdl("Click here to close window", 256, i1, 1, k1);
        if(ebd == 1)
        {
            if(k1 == 0xff0000)
                eab = false;
            if((super.fke < 86 || super.fke > 426) && (super.fkf < 167 - l / 2 || super.fkf > 167 + l / 2))
                eab = false;
        }
        ebd = 0;
    }

    private final void fah()
    {
        if(ebd != 0)
        {
            for(int l = 0; l < ehk; l++)
            {
                int j1 = ehg + 2;
                int l1 = ehh + 27 + l * 15;
                if(super.fke <= j1 - 2 || super.fkf <= l1 - 12 || super.fkf >= l1 + 4 || super.fke >= (j1 - 3) + ehi)
                    continue;
                fal(dda[l]);
                break;
            }

            ebd = 0;
            ejm = false;
            return;
        }
        if(super.fke < ehg - 10 || super.fkf < ehh - 10 || super.fke > ehg + ehi + 10 || super.fkf > ehh + ehj + 10)
        {
            ejm = false;
            return;
        }
        efj.cam(ehg, ehh, ehi, ehj, 0xd0d0d0, 160);
        efj.cdn("Choose option", ehg + 2, ehh + 12, 1, 65535);
        for(int i1 = 0; i1 < ehk; i1++)
        {
            int k1 = ehg + 2;
            int i2 = ehh + 27 + i1 * 15;
            int j2 = 0xffffff;
            if(super.fke > k1 - 2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && super.fke < (k1 - 3) + ehi)
                j2 = 0xffff00;
            efj.cdn(ecc[dda[i1]] + " " + dja[dda[i1]], k1, i2, 1, j2);
        }

    }

    private final void fai()
    {
        if(ebd != 0)
        {
            ebd = 0;
            int l = super.fke - 52;
            int i1 = super.fkf - 44;
            if(l >= 0 && i1 >= 12 && l < 408 && i1 < 246)
            {
                int j1 = 0;
                for(int l1 = 0; l1 < 5; l1++)
                {
                    for(int l2 = 0; l2 < 8; l2++)
                    {
                        int k3 = 7 + l2 * 49;
                        int k4 = 28 + l1 * 34;
                        if(l > k3 && l < k3 + 49 && i1 > k4 && i1 < k4 + 34 && djm[j1] != -1)
                        {
                            dml = j1;
                            dmm = djm[j1];
                        }
                        j1++;
                    }

                }

                if(dml >= 0)
                {
                    int i3 = djm[dml];
                    if(i3 != -1)
                    {
                        if(djn[dml] > 0 && l > 298 && i1 >= 204 && l < 408 && i1 <= 215)
                        {
                            int l3 = dni + dka[dml];
                            if(l3 < 10)
                                l3 = 10;
                            int l4 = (l3 * e.ajg[i3]) / 100;
                            super.aag.hdg(67);
                            super.aag.hdj(djm[dml]);
                            super.aag.hdn(l4);
                            super.aag.hde();
                        }
                        if(fce(i3) > 0 && l > 2 && i1 >= 229 && l < 112 && i1 <= 240)
                        {
                            int i4 = dnh + dka[dml];
                            if(i4 < 10)
                                i4 = 10;
                            int i5 = (i4 * e.ajg[i3]) / 100;
                            super.aag.hdg(177);
                            super.aag.hdj(djm[dml]);
                            super.aag.hdn(i5);
                            super.aag.hde();
                        }
                    }
                }
            } else
            {
                super.aag.hdg(43);
                super.aag.hde();
                djh = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        efj.cba(byte0, byte1, 408, 12, 192);
        int k1 = 0x989898;
        efj.cam(byte0, byte1 + 12, 408, 17, k1, 160);
        efj.cam(byte0, byte1 + 29, 8, 170, k1, 160);
        efj.cam(byte0 + 399, byte1 + 29, 9, 170, k1, 160);
        efj.cam(byte0, byte1 + 199, 408, 47, k1, 160);
        efj.cdn("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int i2 = 0xffffff;
        if(super.fke > byte0 + 320 && super.fkf >= byte1 && super.fke < byte0 + 408 && super.fkf < byte1 + 12)
            i2 = 0xff0000;
        efj.cdk("Close window", byte0 + 406, byte1 + 10, 1, i2);
        efj.cdn("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        efj.cdn("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        efj.cdn("Your money: " + fce(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int j3 = 0xd0d0d0;
        int j4 = 0;
        for(int j5 = 0; j5 < 5; j5++)
        {
            for(int k5 = 0; k5 < 8; k5++)
            {
                int i6 = byte0 + 7 + k5 * 49;
                int l6 = byte1 + 28 + j5 * 34;
                if(dml == j4)
                    efj.cam(i6, l6, 49, 34, 0xff0000, 160);
                else
                    efj.cam(i6, l6, 49, 34, j3, 160);
                efj.cbb(i6, l6, 50, 35, 0);
                if(djm[j4] != -1)
                {
                    efj.cdd(i6, l6, 48, 32, den + e.ajf[djm[j4]], e.ajk[djm[j4]], 0, 0, false);
                    efj.cdn(String.valueOf(djn[j4]), i6 + 1, l6 + 10, 1, 65280);
                    efj.cdk(String.valueOf(fce(djm[j4])), i6 + 47, l6 + 10, 1, 65535);
                }
                j4++;
            }

        }

        efj.cbc(byte0 + 5, byte1 + 222, 398, 0);
        if(dml == -1)
        {
            efj.cdl("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int l5 = djm[dml];
        if(l5 != -1)
        {
            if(djn[dml] > 0)
            {
                int j6 = dni + dka[dml];
                if(j6 < 10)
                    j6 = 10;
                int i7 = (j6 * e.ajg[l5]) / 100;
                efj.cdn("Buy a new " + e.ame[l5] + " for " + i7 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int j2 = 0xffffff;
                if(super.fke > byte0 + 298 && super.fkf >= byte1 + 204 && super.fke < byte0 + 408 && super.fkf <= byte1 + 215)
                    j2 = 0xff0000;
                efj.cdk("Click here to buy", byte0 + 405, byte1 + 214, 3, j2);
            } else
            {
                efj.cdl("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(fce(l5) > 0)
            {
                int k6 = dnh + dka[dml];
                if(k6 < 10)
                    k6 = 10;
                int j7 = (k6 * e.ajg[l5]) / 100;
                efj.cdk("Sell your " + e.ame[l5] + " for " + j7 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int k2 = 0xffffff;
                if(super.fke > byte0 + 2 && super.fkf >= byte1 + 229 && super.fke < byte0 + 112 && super.fkf <= byte1 + 240)
                    k2 = 0xff0000;
                efj.cdn("Click here to sell", byte0 + 2, byte1 + 239, 3, k2);
                return;
            }
            efj.cdl("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    private final f faj(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        if(dgj[arg0] == null)
        {
            dgj[arg0] = new f();
            dgj[arg0].gmf = arg0;
        }
        f f1 = dgj[arg0];
        boolean flag = false;
        for(int l = 0; l < dnk; l++)
        {
            if(eii[l].gmf != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.gmj = arg4;
            f1.gmm = arg3;
            int i1 = f1.gna;
            if(arg1 != f1.gnb[i1] || arg2 != f1.gnc[i1])
            {
                f1.gna = i1 = (i1 + 1) % 10;
                f1.gnb[i1] = arg1;
                f1.gnc[i1] = arg2;
            }
        } else
        {
            f1.gmf = arg0;
            f1.gmn = 0;
            f1.gna = 0;
            f1.gnb[0] = f1.gmh = arg1;
            f1.gnc[0] = f1.gmi = arg2;
            f1.gmj = arg4;
            f1.gmm = f1.gml = arg3;
            f1.gmk = 0;
        }
        ddi[dnj++] = f1;
        return f1;
    }

    private final void fak()
    {
        if(ebd != 0 && ddd == 0)
            ddd = 1;
        if(ddd > 0)
        {
            int l = super.fke - 22;
            int i1 = super.fkf - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < eja)
                    {
                        boolean flag = false;
                        int k2 = 0;
                        int j3 = ejb[j1];
                        for(int j4 = 0; j4 < dkb; j4++)
                            if(dkc[j4] == j3)
                                if(e.ajh[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < ddd; l4++)
                                    {
                                        if(dkd[j4] < ejc[j1])
                                            dkd[j4]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(fce(j3) <= k2)
                            flag = true;
                        if(e.ajl[j3] == 1)
                        {
                            feb("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && dkb < 12)
                        {
                            dkc[dkb] = j3;
                            dkd[dkb] = 1;
                            dkb++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.aag.hdg(144);
                            super.aag.heb(dkb);
                            for(int i5 = 0; i5 < dkb; i5++)
                            {
                                super.aag.hdj(dkc[i5]);
                                super.aag.hdn(dkd[i5]);
                            }

                            super.aag.hde();
                            ede = false;
                            edf = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 133)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < dkb)
                    {
                        int i2 = dkc[k1];
                        for(int l2 = 0; l2 < ddd; l2++)
                        {
                            if(e.ajh[i2] == 0 && dkd[k1] > 1)
                            {
                                dkd[k1]--;
                                continue;
                            }
                            dkb--;
                            ddc = 0;
                            for(int k3 = k1; k3 < dkb; k3++)
                            {
                                dkc[k3] = dkc[k3 + 1];
                                dkd[k3] = dkd[k3 + 1];
                            }

                            break;
                        }

                        super.aag.hdg(144);
                        super.aag.heb(dkb);
                        for(int l3 = 0; l3 < dkb; l3++)
                        {
                            super.aag.hdj(dkc[l3]);
                            super.aag.hdn(dkd[l3]);
                        }

                        super.aag.hde();
                        ede = false;
                        edf = false;
                    }
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    edf = true;
                    super.aag.hdg(94);
                    super.aag.hde();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    eff = false;
                    super.aag.hdg(27);
                    super.aag.hde();
                }
            } else
            if(ebd != 0)
            {
                eff = false;
                super.aag.hdg(27);
                super.aag.hde();
            }
            ebd = 0;
            ddd = 0;
        }
        if(!eff)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        efj.cba(byte0, byte1, 468, 12, 192);
        int l1 = 0x989898;
        efj.cam(byte0, byte1 + 12, 468, 18, l1, 160);
        efj.cam(byte0, byte1 + 30, 8, 248, l1, 160);
        efj.cam(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        efj.cam(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        efj.cam(byte0 + 8, byte1 + 133, 197, 22, l1, 160);
        efj.cam(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        efj.cam(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        efj.cam(byte0 + 8, byte1 + 30, 197, 103, j2, 160);
        efj.cam(byte0 + 8, byte1 + 155, 197, 103, j2, 160);
        efj.cam(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 4; i3++)
            efj.cbc(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 4; i4++)
            efj.cbc(byte0 + 8, byte1 + 155 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            efj.cbc(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                efj.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 103, 0);
            if(j5 < 5)
                efj.cbd(byte0 + 8 + j5 * 49, byte1 + 155, 103, 0);
            efj.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        efj.cdn("Trading with: " + ddg, byte0 + 1, byte1 + 10, 1, 0xffffff);
        efj.cdn("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        efj.cdn("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        efj.cdn("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!edf)
            efj.ccb(byte0 + 217, byte1 + 238, del + 25);
        efj.ccb(byte0 + 394, byte1 + 238, del + 26);
        if(ede)
        {
            efj.cdl("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            efj.cdl("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(edf)
        {
            efj.cdl("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            efj.cdl("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < eja; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            efj.cdd(l5, j6, 48, 32, den + e.ajf[ejb[k5]], e.ajk[ejb[k5]], 0, 0, false);
            if(e.ajh[ejb[k5]] == 0)
                efj.cdn(String.valueOf(ejc[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < dkb; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            efj.cdd(k6, i7, 48, 32, den + e.ajf[dkc[i6]], e.ajk[dkc[i6]], 0, 0, false);
            if(e.ajh[dkc[i6]] == 0)
                efj.cdn(String.valueOf(dkd[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.fke > k6 && super.fke < k6 + 48 && super.fkf > i7 && super.fkf < i7 + 32)
                efj.cdn(e.ame[dkc[i6]] + ": @whi@" + e.amf[dkc[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < ecl; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 156 + byte1 + (l6 / 4) * 34;
            efj.cdd(j7, k7, 48, 32, den + e.ajf[ecm[l6]], e.ajk[ecm[l6]], 0, 0, false);
            if(e.ajh[ecm[l6]] == 0)
                efj.cdn(String.valueOf(ecn[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.fke > j7 && super.fke < j7 + 48 && super.fkf > k7 && super.fkf < k7 + 32)
                efj.cdn(e.ame[ecm[l6]] + ": @whi@" + e.amf[ecm[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public final void fal(int l)
    {
        int i1 = eie[l];
        int j1 = eif[l];
        int k1 = dfm[l];
        int l1 = dfn[l];
        int i2 = dga[l];
        int j2 = dch[l];
        if(j2 == 200)
        {
            fdn(dgd, dge, i1, j1, true);
            super.aag.hdg(118);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            edg = -1;
        }
        if(j2 == 210)
        {
            fdn(dgd, dge, i1, j1, true);
            super.aag.hdg(255);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            eig = -1;
        }
        if(j2 == 220)
        {
            fdn(dgd, dge, i1, j1, true);
            super.aag.hdg(253);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hde();
        }
        
        if(j2 == 3200)            
            feb("ID: " + k1 + " : " + e.amf[k1], 3);
        if(j2 == 300)
        {
            fcd(i1, j1, k1);
            super.aag.hdg(76);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.heb(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            edg = -1;
        }
        if(j2 == 310)
        {
            fcd(i1, j1, k1);
            super.aag.hdg(71);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.heb(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            eig = -1;
        }
        if(j2 == 320)
        {
            fcd(i1, j1, k1);
            super.aag.hdg(100);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.heb(k1);
            super.aag.hde();
        }        
        if(j2 == 2300)
        {
            fcd(i1, j1, k1);
            super.aag.hdg(121);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.heb(k1);
            super.aag.hde();
        }
        if(j2 == 3300){
        int doorX = i1 + dil;
        int doorY = j1 + dim;
            feb("ID: " + k1 + "at:" + doorX + "," + doorY + ":" + e.ala[k1], 3);
            }
        if(j2 == 400)
        {
            fba(i1, j1, k1, l1);
            super.aag.hdg(237);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.hdj(i2);
            super.aag.hde();
            edg = -1;
        }
        if(j2 == 410)
        {
            fba(i1, j1, k1, l1);
            super.aag.hdg(127);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.hdj(i2);
            super.aag.hde();
            eig = -1;
        }
        if(j2 == 420)
        {
        if(!Click && !Mine)
        {
            Coords[0] = i1 + dil;
            Coords[1] = j1 + dim;
            Command = 1;
            feb("@red@Canibalistic: @yel@Coords set to: " + Coords[0] + ", " + Coords[1],3);
        }
            fba(i1, j1, k1, l1);
            super.aag.hdg(38);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.hde();
        }
        if(j2 == 2400)
        {
            if(!Click && !Mine)
            {
            Coords[0] = i1 + dil;
            Coords[1] = j1 + dim;
            Command = 2;
            feb("@red@Canibalistic: @yel@Coords set to: " + Coords[0] + ", " + Coords[1],3);
        }
            fba(i1, j1, k1, l1);
            super.aag.hdg(172);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.hde();
        }
        if(j2 == 3400)
            feb("ID: " + k1 + ":" + e.ahi[k1], 3);
        if(j2 == 600)
        {
            super.aag.hdg(166);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            edg = -1;
        }
        if(j2 == 610)
        {
            super.aag.hdg(235);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            eig = -1;
        }
        if(j2 == 620)
        {
            super.aag.hdg(40);
            super.aag.hdj(k1);
            super.aag.hde();
        }
        if(j2 == 630)
        {
            super.aag.hdg(199);
            super.aag.hdj(k1);
            super.aag.hde();
        }
        if(j2 == 640)
        {
            super.aag.hdg(24);
            super.aag.hdj(k1);
            super.aag.hde();
        }
        if(j2 == 650)
        {
            eig = k1;
            dje = 0;
            eih = e.ame[ejb[eig]];
        }
        if(j2 == 660)
        {
            super.aag.hdg(123);
            super.aag.hdj(k1);
            super.aag.hde();
            eig = -1;
            dje = 0;
            feb("Dropping " + e.ame[ejb[k1]], 4);
        }
        if(j2 == 3600)
            feb("ID: " + k1 + ": " + e.amf[k1], 3);
        if(j2 == 700)
        {
            int k2 = (i1 - 64) / ecj;
            int k4 = (j1 - 64) / ecj;
            ena(dgd, dge, k2, k4, true);
            super.aag.hdg(10);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            edg = -1;
        }
        if(j2 == 710)
        {
            int l2 = (i1 - 64) / ecj;
            int l4 = (j1 - 64) / ecj;
            ena(dgd, dge, l2, l4, true);
            super.aag.hdg(143);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            eig = -1;
        }
        if(j2 == 720)
        {
            int i3 = (i1 - 64) / ecj;
            int i5 = (j1 - 64) / ecj;
            ena(dgd, dge, i3, i5, true);
            super.aag.hdg(159);
            super.aag.hdj(k1);
            super.aag.hde();
        }
        if(j2 == 725)
        {
            int j3 = (i1 - 64) / ecj;
            int j5 = (j1 - 64) / ecj;
            ena(dgd, dge, j3, j5, true);
            super.aag.hdg(89);
            super.aag.hdj(k1);
            super.aag.hde();
        }
        if(j2 == 715 || j2 == 2715)
        {
            int k3 = (i1 - 64) / ecj;
            int k5 = (j1 - 64) / ecj;
            ena(dgd, dge, k3, k5, true);
            super.aag.hdg(118);
            super.aag.hdj(k1);
            super.aag.hde();
        }        
        if(j2 == 3333)
        {
        npcID = k1;
        feb("@red@Canibalistic: @yel@Npc Id set to: @whi@" + npcID,3);
        } 
        if(j2 == 3700)
            feb("ID : " + k1 + ": " + e.amc[k1], 3);        
        if(j2 == 800)
        {
            int l3 = (i1 - 64) / ecj;
            int l5 = (j1 - 64) / ecj;
            ena(dgd, dge, l3, l5, true);
            super.aag.hdg(56);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            edg = -1;
        }
        if(j2 == 810)
        {
            int i4 = (i1 - 64) / ecj;
            int i6 = (j1 - 64) / ecj;
            ena(dgd, dge, i4, i6, true);
            super.aag.hdg(11);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hde();
            eig = -1;
        }
        if(j2 == 805 || j2 == 2805)
        {
            int j4 = (i1 - 64) / ecj;
            int j6 = (j1 - 64) / ecj;
            ena(dgd, dge, j4, j6, true);
            super.aag.hdg(124);
            super.aag.hdj(k1);
            super.aag.hde();
        }
        
        if(j2 == 2806)
        {
            super.aag.hdg(217);
            super.aag.hdj(k1);
            super.aag.hde();
        }
        if(j2 == 2810)
        {
            super.aag.hdg(62);
            super.aag.hdj(k1);
            super.aag.hde();
        }
        if(j2 == 4444)
        {
        int player = GetPlayerIDX(k1);
        if(player != -1)
        {
        addToFriends(ege[player].gme);
        }
        }
        if(j2 == 2820)
        {
            super.aag.hdg(91);
            super.aag.hdj(k1);
            super.aag.hde();
        }        
        if(j2 == 900)
        {
            ena(dgd, dge, i1, j1, true);
            super.aag.hdg(201);
            super.aag.hdj(i1 + dil);
            super.aag.hdj(j1 + dim);
            super.aag.hdj(k1);
            super.aag.hde();
            edg = -1;
        }
        if(j2 == 920)
        {
            ena(dgd, dge, i1, j1, false);
            if(eak == -24)
                eak = 24;
        }        
        if(j2 == 1000)
        {
            super.aag.hdg(44);
            super.aag.hdj(k1);
            super.aag.hde();
            edg = -1;
        }
        if(j2 == 4000)
        {
            eig = -1;
            edg = -1;
        }
    }

    final void fam(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = ekn[l1];
        int l2 = dna[l1];
        if(k2 == 0)
        {
            int i3 = 255 + l2 * 5 * 256;
            efj.cal(l + j1 / 2, i1 + k1 / 2, 20 + l2 * 2, i3, 255 - l2 * 5);
        }
        if(k2 == 1)
        {
            int j3 = 0xff0000 + l2 * 5 * 256;
            efj.cal(l + j1 / 2, i1 + k1 / 2, 10 + l2, j3, 255 - l2 * 5);
        }
    }

    private final void fan()
    {
        if(edh > 1)
            edh--;
        acd();
        if(dhf > 0)
            dhf--;
        if(super.fil > 4500 && eda == 0 && dhf == 0)
        {
            super.fil -= 500;
            return;
        }
        if(dgc.gml == 8 || dgc.gml == 9)
            eda = 500;
        if(eda > 0)
            eda--;
        if(efc)
        {
            fcn();
            return;
        }
        for(int l = 0; l < efg; l++)
        {
            f f1 = ege[l];
            int j1 = (f1.gna + 1) % 10;
            if(f1.gmn != j1)
            {
                int l1 = -1;
                int k3 = f1.gmn;
                int i5;
                if(k3 < j1)
                    i5 = j1 - k3;
                else
                    i5 = (10 + j1) - k3;
                int i6 = 4;
                if(i5 > 2)
                    i6 = (i5 - 1) * 4;
                if(f1.gnb[k3] - f1.gmh > ecj * 3 || f1.gnc[k3] - f1.gmi > ecj * 3 || f1.gnb[k3] - f1.gmh < -ecj * 3 || f1.gnc[k3] - f1.gmi < -ecj * 3 || i5 > 8)
                {
                    f1.gmh = f1.gnb[k3];
                    f1.gmi = f1.gnc[k3];
                } else
                {
                    if(f1.gmh < f1.gnb[k3])
                    {
                        f1.gmh += i6;
                        f1.gmk++;
                        l1 = 2;
                    } else
                    if(f1.gmh > f1.gnb[k3])
                    {
                        f1.gmh -= i6;
                        f1.gmk++;
                        l1 = 6;
                    }
                    if(f1.gmh - f1.gnb[k3] < i6 && f1.gmh - f1.gnb[k3] > -i6)
                        f1.gmh = f1.gnb[k3];
                    if(f1.gmi < f1.gnc[k3])
                    {
                        f1.gmi += i6;
                        f1.gmk++;
                        if(l1 == -1)
                            l1 = 4;
                        else
                        if(l1 == 2)
                            l1 = 3;
                        else
                            l1 = 5;
                    } else
                    if(f1.gmi > f1.gnc[k3])
                    {
                        f1.gmi -= i6;
                        f1.gmk++;
                        if(l1 == -1)
                            l1 = 0;
                        else
                        if(l1 == 2)
                            l1 = 1;
                        else
                            l1 = 7;
                    }
                    if(f1.gmi - f1.gnc[k3] < i6 && f1.gmi - f1.gnc[k3] > -i6)
                        f1.gmi = f1.gnc[k3];
                }
                if(l1 != -1)
                    f1.gml = l1;
                if(f1.gmh == f1.gnb[k3] && f1.gmi == f1.gnc[k3])
                    f1.gmn = (k3 + 1) % 10;
            } else
            {
                f1.gml = f1.gmm;
            }
            if(f1.gnf > 0)
                f1.gnf--;
            if(f1.gnh > 0)
                f1.gnh--;
            if(f1.gnl > 0)
                f1.gnl--;
            if(dfl > 0)
            {
                dfl--;
                if(dfl == 0)
                    feb("You have been granted another life. Be more careful this time!", 3);
                if(dfl == 0)
                    feb("You retain your skills. Your objects land where you died", 3);
            }
        }

        for(int i1 = 0; i1 < dnj; i1++)
        {
            f f2 = ddi[i1];
            int i2 = (f2.gna + 1) % 10;
            if(f2.gmn != i2)
            {
                int l3 = -1;
                int j5 = f2.gmn;
                int j6;
                if(j5 < i2)
                    j6 = i2 - j5;
                else
                    j6 = (10 + i2) - j5;
                int k6 = 4;
                if(j6 > 2)
                    k6 = (j6 - 1) * 4;
                if(f2.gnb[j5] - f2.gmh > ecj * 3 || f2.gnc[j5] - f2.gmi > ecj * 3 || f2.gnb[j5] - f2.gmh < -ecj * 3 || f2.gnc[j5] - f2.gmi < -ecj * 3 || j6 > 8)
                {
                    f2.gmh = f2.gnb[j5];
                    f2.gmi = f2.gnc[j5];
                } else
                {
                    if(f2.gmh < f2.gnb[j5])
                    {
                        f2.gmh += k6;
                        f2.gmk++;
                        l3 = 2;
                    } else
                    if(f2.gmh > f2.gnb[j5])
                    {
                        f2.gmh -= k6;
                        f2.gmk++;
                        l3 = 6;
                    }
                    if(f2.gmh - f2.gnb[j5] < k6 && f2.gmh - f2.gnb[j5] > -k6)
                        f2.gmh = f2.gnb[j5];
                    if(f2.gmi < f2.gnc[j5])
                    {
                        f2.gmi += k6;
                        f2.gmk++;
                        if(l3 == -1)
                            l3 = 4;
                        else
                        if(l3 == 2)
                            l3 = 3;
                        else
                            l3 = 5;
                    } else
                    if(f2.gmi > f2.gnc[j5])
                    {
                        f2.gmi -= k6;
                        f2.gmk++;
                        if(l3 == -1)
                            l3 = 0;
                        else
                        if(l3 == 2)
                            l3 = 1;
                        else
                            l3 = 7;
                    }
                    if(f2.gmi - f2.gnc[j5] < k6 && f2.gmi - f2.gnc[j5] > -k6)
                        f2.gmi = f2.gnc[j5];
                }
                if(l3 != -1)
                    f2.gml = l3;
                if(f2.gmh == f2.gnb[j5] && f2.gmi == f2.gnc[j5])
                    f2.gmn = (j5 + 1) % 10;
            } else
            {
                f2.gml = f2.gmm;
                if(f2.gmj == 43)
                    f2.gmk++;
            }
            if(f2.gnf > 0)
                f2.gnf--;
            if(f2.gnh > 0)
                f2.gnh--;
            if(f2.gnl > 0)
                f2.gnl--;
        }

        if(dje != 2)
        {
            if(j.bnn > 0)
                ekh++;
            if(j.caa > 0)
                ekh = 0;
            j.bnn = 0;
            j.caa = 0;
        }
        for(int k1 = 0; k1 < efg; k1++)
        {
            f f3 = ege[k1];
            if(f3.hag > 0)
                f3.hag--;
        }

        if(dhg)
        {
            if(dlg - dgc.gmh < -500 || dlg - dgc.gmh > 500 || dlh - dgc.gmi < -500 || dlh - dgc.gmi > 500)
            {
                dlg = dgc.gmh;
                dlh = dgc.gmi;
            }
        } else
        {
            if(dlg - dgc.gmh < -500 || dlg - dgc.gmh > 500 || dlh - dgc.gmi < -500 || dlh - dgc.gmi > 500)
            {
                dlg = dgc.gmh;
                dlh = dgc.gmi;
            }
            if(dlg != dgc.gmh)
                dlg += (dgc.gmh - dlg) / (16 + (dhj - 500) / 15);
            if(dlh != dgc.gmi)
                dlh += (dgc.gmi - dlh) / (16 + (dhj - 500) / 15);
            if(efb)
            {
                int j2 = ema * 32;
                int i4 = j2 - dke;
                byte byte0 = 1;
                if(i4 != 0)
                {
                    emb++;
                    if(i4 > 128)
                    {
                        byte0 = -1;
                        i4 = 256 - i4;
                    } else
                    if(i4 > 0)
                        byte0 = 1;
                    else
                    if(i4 < -128)
                    {
                        byte0 = 1;
                        i4 = 256 + i4;
                    } else
                    if(i4 < 0)
                    {
                        byte0 = -1;
                        i4 = -i4;
                    }
                    dke += ((emb * i4 + 255) / 256) * byte0;
                    dke &= 0xff;
                } else
                {
                    emb = 0;
                }
            }
        }
        if(ekh > 20)
        {
            dle = false;
            ekh = 0;
        }
        if(ece)
        {
            if(super.fkm.length() > 0)
                if(super.fkm.equalsIgnoreCase("::lostcon") && !dhh)
                    super.aag.baj();
                else
                if(super.fkm.equalsIgnoreCase("::closecon") && !dhh)
                {
                    aca();
                } else
                {
                    super.aag.hdg(142);
                    super.aag.hdk(super.fkm);
                    if(!dle)
                    {
                        super.aag.heb(0);
                        dle = true;
                    }
                    super.aag.hde();
                    super.fkl = "";
                    super.fkm = "";
                    eke = "Please wait...";
                }
            if(super.fkh == 1 && super.fkf > 275 && super.fkf < 310 && super.fke > 56 && super.fke < 456)
            {
                super.aag.hdg(142);
                super.aag.hdk("-null-");
                if(!dle)
                {
                    super.aag.heb(0);
                    dle = true;
                }
                super.aag.hde();
                super.fkl = "";
                super.fkm = "";
                eke = "Please wait...";
            }
            super.fkh = 0;
            return;
        }
        if(super.fkf > dcm - 4)
        {
            if(super.fke > 15 && super.fke < 96 && super.fkh == 1)
                ell = 0;
            if(super.fke > 110 && super.fke < 194 && super.fkh == 1)
            {
                ell = 1;
                elg.gbc[elh] = 0xf423f;
            }
            if(super.fke > 215 && super.fke < 295 && super.fkh == 1)
            {
                ell = 2;
                elg.gbc[elj] = 0xf423f;
            }
            if(super.fke > 315 && super.fke < 395 && super.fkh == 1)
            {
                ell = 3;
                elg.gbc[elk] = 0xf423f;
            }
            if(super.fke > 417 && super.fke < 497 && super.fkh == 1)
            {
                egc = 1;
                egd = 0;
                super.fkl = "";
                super.fkm = "";
            }
            super.fkh = 0;
            super.fkg = 0;
        }
        elg.gea(super.fke, super.fkf, super.fkh, super.fkg);
        if(ell > 0 && super.fke >= 494 && super.fkf >= dcm - 66)
            super.fkh = 0;
        if(elg.geb(eli))
        {
            String s1 = elg.ggd(eli);
            elg.ggc(eli, "");
            if(s1.startsWith("::") || s1.startsWith("/"))
            {
                if(s1.equalsIgnoreCase("::closecon") && !dhh)
                    super.aag.baj();
                else
                if(s1.equalsIgnoreCase("::logout") && !dhh)
                    aca();
                else
                if(s1.equalsIgnoreCase("::lostcon") && !dhh)
                    acb();
                else if(s1.startsWith("/food"))
                 {
                 FoodID = Integer.parseInt(s1.substring(s1.indexOf("(") + 1,s1.indexOf(")")));
                 feb("@red@Canibalistic: @yel@Default food set to: @whi@" + FoodID,3);
                }          
                else if(s1.startsWith("/time"))
                 {
                 MacroTime = Integer.parseInt(s1.substring(s1.indexOf("(") + 1,s1.indexOf(")")));
                 feb("@red@Canibalistic: @yel@Macro Time set to: @whi@" + MacroTime,3);
                }    
                else if(s1.startsWith("/npc"))
                 {
                 npcID = Integer.parseInt(s1.substring(s1.indexOf("(") + 1,s1.indexOf(")")));
                 feb("@red@Canibalistic: @yel@NPC ID set to: @whi@" + npcID,3);
                 }      
                 else if(s1.startsWith("/sleep"))
                 {
                 sleepAt = Integer.parseInt(s1.substring(s1.indexOf("(") + 1,s1.indexOf(")")));
                 feb("@red@Canibalistic: @yel@Sleeping at: @whi@" + sleepAt + " fatigue",3);
                }    
                else if(s1.startsWith("/walk"))
                 {
                 WalkDis = Integer.parseInt(s1.substring(s1.indexOf("(") + 1,s1.indexOf(")")));
                 feb("@red@Canibalistic: @yel@Anti wander radious set to: " + WalkDis,3);
                } 
                else if(s1.startsWith("/lowhp"))
                {
                eatAt = Integer.parseInt(s1.substring(s1.indexOf("(") + 1,s1.indexOf(")")));
                 feb("@red@Canibalistic: @yel@Eating at: " + eatAt + "hp",3);
                }                                       
                                                    
                else if(s1.startsWith("/hop"))
                {
                int world = Integer.parseInt(s1.substring(s1.indexOf("(") + 1,s1.indexOf(")")));
                feb("@red@Canibalistic: @yel@Switching to " + world, 3);
                aca();
                changeWorld(world);                 
                abn(un, pw, false);                
                }         
                               
                else
                    acn(s1.substring(2));
            } else
            {
                int j4 = v.cek(s1);
                acm(v.ceg, j4);
                s1 = v.cej(v.ceg, 0, j4);
                s1 = u.fgd(s1);
                dgc.gnf = 150;
                dgc.gne = s1;
                myPlayerLastSaid = s1;
                feb(dgc.gme + ": " + s1, 2);
            }
                
        }
       
        if(ell == 0)
        {
            for(int k2 = 0; k2 < 5; k2++)
                if(def[k2] > 0)
                    def[k2]--;

        }
        if(dfl != 0)
            super.fkh = 0;
        if(eff || deh)
        {
            if(super.fkg != 0)
                ddc++;
            else
                ddc = 0;
            if(ddc > 600)
                ddd += 5000;
            else
            if(ddc > 450)
                ddd += 500;
            else
            if(ddc > 300)
                ddd += 50;
            else
            if(ddc > 150)
                ddd += 5;
            else
            if(ddc > 50)
                ddd++;
            else
            if(ddc > 20 && (ddc & 5) == 0)
                ddd++;
        } else
        {
            ddc = 0;
            ddd = 0;
        }
        if(super.fkh == 1)
            ebd = 1;
        else
        if(super.fkh == 2)
            ebd = 2;
        efn.bhg(super.fke, super.fkf);
        super.fkh = 0;
        if(efb)
        {
            if(emb == 0 || dhg)
            {
                if(super.fjl)
                {
                    ema = ema + 1 & 7;
                    super.fjl = false;
                    if(!djc)
                    {
                        if((ema & 1) == 0)
                            ema = ema + 1 & 7;
                        for(int l2 = 0; l2 < 8; l2++)
                        {
                            if(fab(ema))
                                break;
                            ema = ema + 1 & 7;
                        }

                    }
                }
                if(super.fjm)
                {
                    ema = ema + 7 & 7;
                    super.fjm = false;
                    if(!djc)
                    {
                        if((ema & 1) == 0)
                            ema = ema + 7 & 7;
                        for(int i3 = 0; i3 < 8; i3++)
                        {
                            if(fab(ema))
                                break;
                            ema = ema + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.fjl)
            dke = dke + 2 & 0xff;
        else
        if(super.fjm)
            dke = dke - 2 & 0xff;
        if(eak > 0)
            eak--;
        else
        if(eak < 0)
            eak++;
        efn.bji(17);
        eib++;
        if(eib > 5)
        {
            eib = 0;
            edi = (edi + 1) % 3;
            edj = (edj + 1) % 4;
            edk = (edk + 1) % 5;
        }
        for(int j3 = 0; j3 < djd; j3++)
        {
            int k4 = ebm[j3];
            int k5 = ebn[j3];
            if(k4 >= 0 && k5 >= 0 && k4 < 96 && k5 < 96 && eca[j3] == 74)
                ddf[j3].cmi(1, 0, 0);
        }

        for(int l4 = 0; l4 < ean; l4++)
        {
            dna[l4]++;
            if(dna[l4] > 50)
            {
                ean--;
                for(int l5 = l4; l5 < ean; l5++)
                {
                    dnc[l5] = dnc[l5 + 1];
                    dgb[l5] = dgb[l5 + 1];
                    dna[l5] = dna[l5 + 1];
                    ekn[l5] = ekn[l5 + 1];
                }

            }
        }

    }

    private final void fba(int arg0, int arg1, int arg2, int arg3)
    {
        int l;
        int i1;
        if(arg2 == 0 || arg2 == 4)
        {
            l = e.all[arg3];
            i1 = e.alm[arg3];
        } else
        {
            i1 = e.all[arg3];
            l = e.alm[arg3];
        }
        if(e.aln[arg3] == 2 || e.aln[arg3] == 3)
        {
            if(arg2 == 0)
            {
                arg0--;
                l++;
            }
            if(arg2 == 2)
                i1++;
            if(arg2 == 4)
                l++;
            if(arg2 == 6)
            {
                arg1--;
                i1++;
            }
            fde(dgd, dge, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, false, true);
            return;
        } else
        {
            fde(dgd, dge, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, true, true);
            return;
        }
    }

    private final void fbb()
    {
        e.anj("torcha2");
        e.anj("torcha3");
        e.anj("torcha4");
        e.anj("skulltorcha2");
        e.anj("skulltorcha3");
        e.anj("skulltorcha4");
        e.anj("firea2");
        e.anj("firea3");
        e.anj("fireplacea2");
        e.anj("fireplacea3");
        e.anj("firespell2");
        e.anj("firespell3");
        e.anj("lightning2");
        e.anj("lightning3");
        e.anj("clawspell2");
        e.anj("clawspell3");
        e.anj("clawspell4");
        e.anj("clawspell5");
        e.anj("spellcharge2");
        e.anj("spellcharge3");
        if(fld())
        {
            byte abyte0[] = enb(12, "3d models", 60);
            if(abyte0 == null)
            {
                ein = true;
                return;
            }
            for(int i1 = 0; i1 < e.aim; i1++)
            {
                int j1 = t.fne(e.ahl[i1] + ".ob3", abyte0);
                if(j1 != 0)
                    dkj[i1] = new i(abyte0, j1, true);
                else
                    dkj[i1] = new i(1, 1);
                if(e.ahl[i1].equals("giantcrystal"))
                    dkj[i1].chj = true;
            }

            return;
        }
        flj(70, "Loading 3d models");
        for(int l = 0; l < e.aim; l++)
        {
            dkj[l] = new i("../gamedata/models/" + e.ahl[l] + ".ob2");
            if(e.ahl[l].equals("giantcrystal"))
                dkj[l].chj = true;
        }

    }

    private final void fbc(boolean arg0)
    {
        int l = ((j) (efj)).blg - 199;
        int i1 = 36;
        efj.ccb(l - 49, 3, del + 3);
        char c1 = '\304';
        char c2 = '\u0113';
        int k1;
        int j1 = k1 = j.cbh(160, 160, 160);
        if(dii == 0)
            j1 = j.cbh(220, 220, 220);
        else
            k1 = j.cbh(220, 220, 220);
        efj.cam(l, i1, c1 / 2, 24, j1, 128);
        efj.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        efj.cam(l, i1 + 24, c1, c2 - 14, j.cbh(220, 220, 220), 128);
        efj.cbc(l, i1 + 24, c1, 0);
        efj.cbd(l + c1 / 2, i1, 24, 0);
        efj.cdl("Stats", l + c1 / 4, i1 + 16, 4, 0);
        efj.cdl("Quests", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(dii == 0)
        {
            int l1 = 72;
            int j2 = -1;
            efj.cdn("Skills", l + 5, l1, 3, 0xffff00);
            l1 += 13;
            for(int k2 = 0; k2 < 9; k2++)
            {
                int l2 = 0xffffff;
                if(super.fke > l + 3 && super.fkf >= l1 - 11 && super.fkf < l1 + 2 && super.fke < l + 90)
                {
                    l2 = 0xff0000;
                    j2 = k2;
                }
                efj.cdn(ech[k2] + ":@yel@" + egk[k2] + "/" + efk[k2], l + 5, l1, 1, l2);
                l2 = 0xffffff;
                if(super.fke >= l + 90 && super.fkf >= l1 - 13 - 11 && super.fkf < (l1 - 13) + 2 && super.fke < l + 196)
                {
                    l2 = 0xff0000;
                    j2 = k2 + 9;
                }
                efj.cdn(ech[k2 + 9] + ":@yel@" + egk[k2 + 9] + "/" + efk[k2 + 9], (l + c1 / 2) - 5, l1 - 13, 1, l2);
                l1 += 13;
            }

            efj.cdn("Quest Points:@yel@" + dhk, (l + c1 / 2) - 5, l1 - 13, 1, 0xffffff);
            l1 += 12;
            efj.cdn("Fatigue: @yel@" + (eha * 100) / 750 + "%", l + 5, l1 - 13, 1, 0xffffff);
            l1 += 8;
            efj.cdn("Equipment Status", l + 5, l1, 3, 0xffff00);
            l1 += 12;
            for(int i3 = 0; i3 < 3; i3++)
            {
                efj.cdn(emd[i3] + ":@yel@" + ebb[i3], l + 5, l1, 1, 0xffffff);
                if(i3 < 2)
                    efj.cdn(emd[i3 + 3] + ":@yel@" + ebb[i3 + 3], l + c1 / 2 + 25, l1, 1, 0xffffff);
                l1 += 13;
            }

            l1 += 6;
            efj.cbc(l, l1 - 15, c1, 0);
            if(j2 != -1)
            {
                efj.cdn(ebi[j2] + " skill", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int j3 = dik[0];
                for(int l3 = 0; l3 < 98; l3++)
                    if(dlf[j2] >= dik[l3])
                        j3 = dik[l3 + 1];
                int nextLevel = (j3 / 4) - (dlf[j2] / 4);
                efj.cdn("Total xp: " + dlf[j2] / 4, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                efj.cdn("Next level at: " + j3 / 4, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                efj.cdn("Xp left: " + nextLevel, l + 5, l1, 1, 0xffffff);
            } else
            {
                efj.cdn("Overall levels", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int k3 = 0;
                for(int i4 = 0; i4 < 18; i4++)
                    k3 += efk[i4];
                int TotalXp = GetExp(0) + GetExp(1) + GetExp(2) + GetExp(3) + GetExp(4) + GetExp(5) + GetExp(6) + GetExp(7) + GetExp(8) + GetExp(9) + GetExp(10) + GetExp(11) + GetExp(12) + GetExp(13) + GetExp(14) + GetExp(15) + GetExp(16) + GetExp(17); 
                efj.cdn("Skill total: " + k3, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                efj.cdn("Combat level: " + dgc.gnm, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                efj.cdn("Overall Xp: " + TotalXp, l + 5, l1, 1, 0xffffff);
            }
        }
        if(dii == 1)
        {
            dig.gfm(dih);
            dig.gga(dih, 0, "@whi@Quest-list (green=completed)");
            for(int i2 = 0; i2 < 50; i2++)
                dig.gga(dih, i2 + 1, (dkk[i2] ? "@gre@" : "@red@") + ecd[i2]);

            dig.ged();
        }
        if(!arg0)
            return;
        l = super.fke - (((j) (efj)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < c1 && i1 < c2)
        {
            if(dii == 1)
                dig.gea(l + (((j) (efj)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && ebd == 1)
            {
                if(l < 98)
                {
                    dii = 0;
                    return;
                }
                if(l > 98)
                    dii = 1;
            }
        }
    }

    private final void fbd()
    {
        dhi = new h(efj, 100);
        dhi.gfd(256, 10, "Please design Your Character", 4, true);
        int l = 140;
        int i1 = 34;
        l += 116;
        i1 -= 10;
        dhi.gfd(l - 55, i1 + 110, "Front", 3, true);
        dhi.gfd(l, i1 + 110, "Side", 3, true);
        dhi.gfd(l + 55, i1 + 110, "Back", 3, true);
        byte byte0 = 54;
        i1 += 145;
        dhi.gff(l - byte0, i1, 53, 41);
        dhi.gfd(l - byte0, i1 - 8, "Head", 1, true);
        dhi.gfd(l - byte0, i1 + 8, "Type", 1, true);
        dhi.gfg(l - byte0 - 40, i1, h.gdi + 7);
        eec = dhi.gfl(l - byte0 - 40, i1, 20, 20);
        dhi.gfg((l - byte0) + 40, i1, h.gdi + 6);
        eed = dhi.gfl((l - byte0) + 40, i1, 20, 20);
        dhi.gff(l + byte0, i1, 53, 41);
        dhi.gfd(l + byte0, i1 - 8, "Hair", 1, true);
        dhi.gfd(l + byte0, i1 + 8, "Color", 1, true);
        dhi.gfg((l + byte0) - 40, i1, h.gdi + 7);
        eee = dhi.gfl((l + byte0) - 40, i1, 20, 20);
        dhi.gfg(l + byte0 + 40, i1, h.gdi + 6);
        eef = dhi.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dhi.gff(l - byte0, i1, 53, 41);
        dhi.gfd(l - byte0, i1, "Gender", 1, true);
        dhi.gfg(l - byte0 - 40, i1, h.gdi + 7);
        eeg = dhi.gfl(l - byte0 - 40, i1, 20, 20);
        dhi.gfg((l - byte0) + 40, i1, h.gdi + 6);
        eeh = dhi.gfl((l - byte0) + 40, i1, 20, 20);
        dhi.gff(l + byte0, i1, 53, 41);
        dhi.gfd(l + byte0, i1 - 8, "Top", 1, true);
        dhi.gfd(l + byte0, i1 + 8, "Color", 1, true);
        dhi.gfg((l + byte0) - 40, i1, h.gdi + 7);
        eei = dhi.gfl((l + byte0) - 40, i1, 20, 20);
        dhi.gfg(l + byte0 + 40, i1, h.gdi + 6);
        eej = dhi.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dhi.gff(l - byte0, i1, 53, 41);
        dhi.gfd(l - byte0, i1 - 8, "Skin", 1, true);
        dhi.gfd(l - byte0, i1 + 8, "Color", 1, true);
        dhi.gfg(l - byte0 - 40, i1, h.gdi + 7);
        eek = dhi.gfl(l - byte0 - 40, i1, 20, 20);
        dhi.gfg((l - byte0) + 40, i1, h.gdi + 6);
        eel = dhi.gfl((l - byte0) + 40, i1, 20, 20);
        dhi.gff(l + byte0, i1, 53, 41);
        dhi.gfd(l + byte0, i1 - 8, "Bottom", 1, true);
        dhi.gfd(l + byte0, i1 + 8, "Color", 1, true);
        dhi.gfg((l + byte0) - 40, i1, h.gdi + 7);
        eem = dhi.gfl((l + byte0) - 40, i1, 20, 20);
        dhi.gfg(l + byte0 + 40, i1, h.gdi + 6);
        een = dhi.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 82;
        i1 -= 35;
        dhi.gfe(l, i1, 200, 30);
        dhi.gfd(l, i1, "Accept", 4, false);
        efa = dhi.gfl(l, i1, 200, 30);
    }

    private final void fbe()
    {
        if(super.fkm.length() > 0)
        {
            String s1 = super.fkm.trim();
            super.fkl = "";
            super.fkm = "";
            if(s1.length() > 0)
            {
                long l1 = t.fnc(s1);
                super.aag.hdg(215);
                super.aag.hdl(l1);
                super.aag.heb(egd);
                super.aag.heb(djb ? 1 : 0);
                super.aag.hde();
            }
            egc = 0;
            return;
        }
        efj.cba(56, 130, 400, 100, 0);
        efj.cbb(56, 130, 400, 100, 0xffffff);
        int l = 160;
        efj.cdl("Now type the name of the offending player, and press enter", 256, l, 1, 0xffff00);
        l += 18;
        efj.cdl("Name: " + super.fkl + "*", 256, l, 4, 0xffffff);
        if(super.abj > 0)
        {
            l = 207;
            if(djb)
                efj.cdl("Moderator option: Mute player for 48 hours: <ON>", 256, l, 1, 0xff8000);
            else
                efj.cdl("Moderator option: Mute player for 48 hours: <OFF>", 256, l, 1, 0xffffff);
            if(super.fke > 106 && super.fke < 406 && super.fkf > l - 13 && super.fkf < l + 2 && ebd == 1)
            {
                ebd = 0;
                djb = !djb;
            }
        }
        l = 222;
        int i1 = 0xffffff;
        if(super.fke > 196 && super.fke < 316 && super.fkf > l - 13 && super.fkf < l + 2)
        {
            i1 = 0xffff00;
            if(ebd == 1)
            {
                ebd = 0;
                egc = 0;
            }
        }
        efj.cdl("Click here to cancel", 256, l, 1, i1);
        if(ebd == 1 && (super.fke < 56 || super.fke > 456 || super.fkf < 130 || super.fkf > 230))
        {
            ebd = 0;
            egc = 0;
        }
    }

    private final void fbf(boolean arg0)
    {
        int l = ((j) (efj)).blg - 199;
        int i1 = 36;
        efj.ccb(l - 49, 3, del + 6);
        char c1 = '\304';
        efj.cam(l, 36, c1, 65, j.cbh(181, 181, 181), 160);
        efj.cam(l, 101, c1, 65, j.cbh(201, 201, 201), 160);
        efj.cam(l, 166, c1, 95, j.cbh(181, 181, 181), 160);
        efj.cam(l, 261, c1, 40, j.cbh(201, 201, 201), 160);
        int j1 = l + 3;
        int l1 = i1 + 15;
        efj.cdn("Game options - click to toggle", j1, l1, 1, 0);
        l1 += 15;
        if(efb)
            efj.cdn("Camera angle mode - @gre@Auto", j1, l1, 1, 0xffffff);
        else
            efj.cdn("Camera angle mode - @red@Manual", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(dek)
            efj.cdn("Mouse buttons - @red@One", j1, l1, 1, 0xffffff);
        else
            efj.cdn("Mouse buttons - @gre@Two", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(!Lefty)
                efj.cdn("Lefties are turned - @red@off", j1, l1, 1, 0xffffff);
            else
                efj.cdn("Lefties are turned - @gre@on", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(!PlayerHP)        
            efj.cdn("PlayerHP is - @red@off", j1, l1, 1, 0xffffff);
            else
            efj.cdn("PlayerHP is - @gre@on", j1, l1, 1, 0xffffff);
        l1 += 15;
        
        l1 += 15;
        
        l1 += 15;  
        if(WalkBack)
        efj.cdn("Walk back is turned - @gre@on", j1, l1, 1, 0xffffff);  
        else
        efj.cdn("Walk back is turned - @red@off", j1, l1, 1, 0xffffff);    
        l1 += 15; 
        if(WalkAway)
        efj.cdn("Anti Wander is turned - @gre@on", j1, l1, 1, 0xffffff);  
        else
        efj.cdn("Anti Wander is turned - @red@off", j1, l1, 1, 0xffffff);         
        l1 +=15;
        if(AutoEat)
        efj.cdn("Auto Eating is turned - @gre@on", j1, l1, 1, 0xffffff);  
        else
        efj.cdn("Auto Eating is turned - @red@off", j1, l1, 1, 0xffffff);           
        l1 += 5;
        efj.cdn("", l + 3, l1, 1, 0);
        l1 += 15;       
        if(super.abb == 0)
            efj.cdn("Block chat messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            efj.cdn("Block chat messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.abc == 0)
            efj.cdn("Block private messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            efj.cdn("Block private messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.abd == 0)
            efj.cdn("Block trade requests: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            efj.cdn("Block trade requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(dej)
            if(super.abe == 0)
                efj.cdn("Block duel requests: @red@<off>", l + 3, l1, 1, 0xffffff);
            else
                efj.cdn("Block duel requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        l1 += 5;
        efj.cdn("Always logout when you finish", j1, l1, 1, 0);
        l1 += 15;
        int j2 = 0xffffff;
        if(super.fke > j1 && super.fke < j1 + c1 && super.fkf > l1 - 12 && super.fkf < l1 + 4)
            j2 = 0xffff00;
        efj.cdn("Click here to logout", l + 3, l1, 1, j2);
        efj.cdn("@red@PID: " + dgc.gmf, l + 3, l1 + 12, 1, j2);        
        if(!arg0)
            return;
        l = super.fke - (((j) (efj)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 265)
        {
            int k2 = ((j) (efj)).blg - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int k1 = k2 + 3;
            int i2 = byte0 + 30;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                 efb = !efb;
                super.aag.hdg(165);
                super.aag.heb(0);
                super.aag.heb(efb ? 1 : 0);
                super.aag.hde();
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                dek = !dek;
                super.aag.hdg(165);
                super.aag.heb(2);
                super.aag.heb(dek ? 1 : 0);
                super.aag.hde();
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                if(Lefty)
                Lefty = false;
                else
                Lefty = true;
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                if(PlayerHP)
                PlayerHP = false;
                else
                PlayerHP = true;
            }            
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                
            }  
            i2 += 15;          
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                
            }            
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
            WalkBack = !WalkBack;
            }
            i2 += 15; 
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
            WalkAway = !WalkAway;
            }  
            i2 += 15; 
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
            AutoEat = !AutoEat;
            if(AutoEat)
            {
            AutoEater = new eat();
            feb("@red@Canibalistic: @yel@Auto Eating turned on",3);
            }
            else
            feb("@red@Canibalistic: @yel@Auto Eating turned off",3);
            }                       
            boolean flag = false;
            i2 += 20;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                super.abb = 1 - super.abb;
                flag = true;
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                super.abc = 1 - super.abc;
                flag = true;
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                super.abd = 1 - super.abd;
                flag = true;
            }
            i2 += 15;
            if(dej && super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
            {
                super.abe = 1 - super.abe;
                flag = true;
            }
            i2 += 15;
            if(flag)
                acg(super.abb, super.abc, super.abd, super.abe);
            i2 += 20;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && ebd == 1)
                enl();
            ebd = 0;
        }
    }

    private final void fbg()
    {
        try
        {
            dnm = enb(8, "Sound effects", 90);
            deb = new d();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    protected final void ade()
    {
        dhf = 0;
        feb("@cya@Sorry, you can't logout at the moment", 3);
    }

    private final void fbh()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        efj.cba(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        efj.cam(byte0, byte1 + 16, 468, 246, l, 160);
        efj.cdl("Please confirm your trade with @yel@" + t.fnd(ekf), byte0 + 234, byte1 + 12, 1, 0xffffff);
        efj.cdl("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < egh; i1++)
        {
            String s1 = e.ame[egi[i1]];
            if(e.ajh[egi[i1]] == 0)
                s1 = s1 + " x " + enk(egj[i1]);
            efj.cdl(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(egh == 0)
            efj.cdl("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        efj.cdl("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < eje; j1++)
        {
            String s2 = e.ame[ejf[j1]];
            if(e.ajh[ejf[j1]] == 0)
                s2 = s2 + " x " + enk(ejg[j1]);
            efj.cdl(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(eje == 0)
            efj.cdl("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        efj.cdl("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        efj.cdl("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        efj.cdl("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!eia)
        {
            efj.ccb((byte0 + 118) - 35, byte1 + 238, del + 25);
            efj.ccb((byte0 + 352) - 35, byte1 + 238, del + 26);
        } else
        {
            efj.cdl("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(ebd == 1)
        {
            if(super.fke < byte0 || super.fkf < byte1 || super.fke > byte0 + 468 || super.fkf > byte1 + 262)
            {
                ehn = false;
                super.aag.hdg(27);
                super.aag.hde();
            }
            if(super.fke >= (byte0 + 118) - 35 && super.fke <= byte0 + 118 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                eia = true;
                super.aag.hdg(102);
                super.aag.hde();
            }
            if(super.fke >= (byte0 + 352) - 35 && super.fke <= byte0 + 353 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                ehn = false;
                super.aag.hdg(27);
                super.aag.hde();
            }
            ebd = 0;
        }
    }

    private final void fbi()
    {
        egd = 0;
        int l = 135;
        for(int i1 = 0; i1 < 12; i1++)
        {
            if(super.fke > 66 && super.fke < 446 && super.fkf >= l - 12 && super.fkf < l + 3)
                egd = i1 + 1;
            l += 14;
        }

        if(ebd != 0 && egd != 0)
        {
            ebd = 0;
            egc = 2;
            super.fkl = "";
            super.fkm = "";
            return;
        }
        l += 15;
        if(ebd != 0)
        {
            ebd = 0;
            if(super.fke < 56 || super.fkf < 35 || super.fke > 456 || super.fkf > 325)
            {
                egc = 0;
                return;
            }
            if(super.fke > 66 && super.fke < 446 && super.fkf >= l - 15 && super.fkf < l + 5)
            {
                egc = 0;
                return;
            }
        }
        efj.cba(56, 35, 400, 290, 0);
        efj.cbb(56, 35, 400, 290, 0xffffff);
        l = 50;
        efj.cdl("This form is for reporting players who are breaking our rules", 256, l, 1, 0xffffff);
        l += 15;
        efj.cdl("Using it sends a snapshot of the last 60 secs of activity to us", 256, l, 1, 0xffffff);
        l += 15;
        efj.cdl("If you misuse this form, you will be banned.", 256, l, 1, 0xff8000);
        l += 15;
        l += 10;
        efj.cdl("First indicate which of our 12 rules is being broken. For a detailed", 256, l, 1, 0xffff00);
        l += 15;
        efj.cdl("explanation of each rule please read the manual on our website.", 256, l, 1, 0xffff00);
        l += 15;
        int j1;
        if(egd == 1)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("1: Offensive language", 256, l, 1, j1);
        l += 14;
        if(egd == 2)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("2: Item scamming", 256, l, 1, j1);
        l += 14;
        if(egd == 3)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("3: Password scamming", 256, l, 1, j1);
        l += 14;
        if(egd == 4)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("4: Bug abuse", 256, l, 1, j1);
        l += 14;
        if(egd == 5)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("5: Jagex Staff impersonation", 256, l, 1, j1);
        l += 14;
        if(egd == 6)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("6: Account sharing/trading", 256, l, 1, j1);
        l += 14;
        if(egd == 7)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("7: Macroing", 256, l, 1, j1);
        l += 14;
        if(egd == 8)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("8: Mutiple logging in", 256, l, 1, j1);
        l += 14;
        if(egd == 9)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("9: Encouraging others to break rules", 256, l, 1, j1);
        l += 14;
        if(egd == 10)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("10: Misuse of customer support", 256, l, 1, j1);
        l += 14;
        if(egd == 11)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("11: Advertising / website", 256, l, 1, j1);
        l += 14;
        if(egd == 12)
        {
            efj.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        efj.cdl("12: Real world item trading", 256, l, 1, j1);
        l += 14;
        l += 15;
        j1 = 0xffffff;
        if(super.fke > 196 && super.fke < 316 && super.fkf > l - 15 && super.fkf < l + 5)
            j1 = 0xffff00;
        efj.cdl("Click here to cancel", 256, l, 1, j1);
    }

    public final String getParameter(String s1)
    {
        if(link.fni != null)
            return link.fni.getParameter(s1);
        else
            return super.getParameter(s1);
    }

    private final void fbj(boolean arg0)
    {    
        int wildy = 2203 - (dge + dne + dim);
        if(dgd + dnd + dil >= 2640) 
        { 
        wildy = -50; 
        } 
        int l = ((j) (efj)).blg - 199;
        char c1 = '\234';
        char c3 = '\230';
        efj.ccb(l - 49, 3, del + 2);
        l += 40;
        efj.cba(l, 36, c1, c3, 0);
        efj.cah(l, 36, l + c1, 36 + c3);
        int j1 = 192 + dff;
        int l1 = dke + dfe & 0xff;
        int j2 = ((dgc.gmh - 6040) * 3 * j1) / 2048;
        int l3 = ((dgc.gmi - 6040) * 3 * j1) / 2048;
        int j5 = n.bbk[1024 - l1 * 4 & 0x3ff];
        int l5 = n.bbk[(1024 - l1 * 4 & 0x3ff) + 1024];
        int j6 = l3 * j5 + j2 * l5 >> 18;
        l3 = l3 * l5 - j2 * j5 >> 18;
        j2 = j6;
        efj.ccn((l + c1 / 2) - j2, 36 + c3 / 2 + l3, del - 1, l1 + 64 & 0xff, j1);
        for(int l7 = 0; l7 < djd; l7++)
        {
            int k2 = (((ebm[l7] * ecj + 64) - dgc.gmh) * 3 * j1) / 2048;
            int i4 = (((ebn[l7] * ecj + 64) - dgc.gmi) * 3 * j1) / 2048;
            int k6 = i4 * j5 + k2 * l5 >> 18;
            i4 = i4 * l5 - k2 * j5 >> 18;
            k2 = k6;                        
            fch(l + c1 / 2 + k2, (36 + c3 / 2) - i4, 65535);
        }

        for(int i8 = 0; i8 < dkm; i8++)
        {
            int l2 = (((ekj[i8] * ecj + 64) - dgc.gmh) * 3 * j1) / 2048;
            int j4 = (((ekk[i8] * ecj + 64) - dgc.gmi) * 3 * j1) / 2048;
            int l6 = j4 * j5 + l2 * l5 >> 18;
            j4 = j4 * l5 - l2 * j5 >> 18;
            l2 = l6; 
            if(Disabled)
            fch(l + c1 / 2 + l2, (36 + c3 / 2) - j4, 0x000000);
            else           
            fch(l + c1 / 2 + l2, (36 + c3 / 2) - j4, 0xff0000);
        }

        for(int j8 = 0; j8 < dnj; j8++)
        {
            f f1 = ddi[j8];
            int i3 = ((f1.gmh - dgc.gmh) * 3 * j1) / 2048;
            int k4 = ((f1.gmi - dgc.gmi) * 3 * j1) / 2048;
            int i7 = k4 * j5 + i3 * l5 >> 18;
            k4 = k4 * l5 - i3 * j5 >> 18;
            i3 = i7;
            if(Disabled)
            fch(l + c1 / 2 + i3, (36 + c3 / 2) - k4, 0x000000);
            else            
            fch(l + c1 / 2 + i3, (36 + c3 / 2) - k4, 0xffff00);
        }
        for(int k8 = 0; k8 < efg; k8++)
        {
            f f2 = ege[k8];
            int j3 = ((f2.gmh - dgc.gmh) * 3 * j1) / 2048;
            int l4 = ((f2.gmi - dgc.gmi) * 3 * j1) / 2048;
            int j7 = l4 * j5 + j3 * l5 >> 18;
            l4 = l4 * l5 - j3 * j5 >> 18;
            j3 = j7;            
            int i9 = 0xFFFFFF;            
            
            int wildyLevel = 1 + wildy / 6; 

           if(wildy > 0) { 
           int checkAtkA = dgc.gnm + wildyLevel; 
           int checkAtkB = dgc.gnm - wildyLevel; 
           
           if (f2.gnm <= checkAtkA && f2.gnm >= checkAtkB ) { 
           canDraw = 1; 
                    int leveler = dgc.gnm - f2.gnm; 
                    if (leveler == 0) 
                         i9 = 0xFFFFFF; 
                    if(leveler > 0) 
                         i9 = 0xE1FF90; 
                    if(leveler > 3) 
                         i9 = 0xBAFF00; 
                    if(leveler > 6) 
                         i9 = 0x6CFF00; 
                    if(leveler > 10) 
                         i9 = 0x00FF00; 
                    if(leveler < 0) 
                         i9 = 0xFFF36D; 
                    if(leveler < -3) 
                         i9 = 0xFFB400; 
                    if(leveler < -6) 
                         i9 = 0xFF7E00; 
                    if(leveler < -9) 
                         i9 = 0xFF0000; 
                    } else {  
                    canDraw = 0;   
                    }                                                                                      
               }   
            if(wildy <= 0)
            {
            i9 = 0xFFFFFF; 
            canDraw = 1;
            }       
            for(int j9 = 0; j9 < super.aak; j9++)
            {
                if(f2.gmd != super.aal[j9] || super.aam[j9] != 99)
                    continue;
                i9 = 65280;
                break;
            }            
            if(canDraw == 1) { 
              fch(l + c1 / 2 + j3, (36 + c3 / 2) - l4, i9);
               }                
            
              } 
 
            
        

        efj.cal(l + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        efj.ccn(l + 19, 55, del + 24, dke + 128 & 0xff, 128);
        efj.cah(0, 0, dcl, dcm + 12);
        if(!arg0)
            return;
        l = super.fke - (((j) (efj)).blg - 199);
        int l8 = super.fkf - 36;
        if(l >= 40 && l8 >= 0 && l < 196 && l8 < 152)
        {
            char c2 = '\234';
            char c4 = '\230';
            int k1 = 192 + dff;
            int i2 = dke + dfe & 0xff;
            int i1 = ((j) (efj)).blg - 199;
            i1 += 40;
            int k3 = ((super.fke - (i1 + c2 / 2)) * 16384) / (3 * k1);
            int i5 = ((super.fkf - (36 + c4 / 2)) * 16384) / (3 * k1);
            int k5 = n.bbk[1024 - i2 * 4 & 0x3ff];
            int i6 = n.bbk[(1024 - i2 * 4 & 0x3ff) + 1024];
            int k7 = i5 * k5 + k3 * i6 >> 15;
            i5 = i5 * i6 - k3 * k5 >> 15;
            k3 = k7;
            k3 += dgc.gmh;
            i5 = dgc.gmi - i5;
            if(ebd == 1)
                ena(dgd, dge, k3 / 128, i5 / 128, false);
            ebd = 0;
        }
    }

    private final void fbk()
    {
        if(ebd != 0 && ddd == 0)
            ddd = 1;
        if(ddd > 0)
        {
            int l = super.fke - 22;
            int i1 = super.fkf - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < eja)
                    {
                        boolean flag1 = false;
                        int k2 = 0;
                        int j3 = ejb[j1];
                        for(int j4 = 0; j4 < dkg; j4++)
                            if(dkh[j4] == j3)
                                if(e.ajh[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < ddd; l4++)
                                    {
                                        if(dki[j4] < ejc[j1])
                                            dki[j4]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(fce(j3) <= k2)
                            flag1 = true;
                        if(e.ajl[j3] == 1)
                        {
                            feb("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && dkg < 8)
                        {
                            dkh[dkg] = j3;
                            dki[dkg] = 1;
                            dkg++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.aag.hdg(229);
                            super.aag.heb(dkg);
                            for(int i5 = 0; i5 < dkg; i5++)
                            {
                                super.aag.hdj(dkh[i5]);
                                super.aag.hdn(dki[i5]);
                            }

                            super.aag.hde();
                            dgm = false;
                            dgn = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 129)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < dkg)
                    {
                        int i2 = dkh[k1];
                        for(int l2 = 0; l2 < ddd; l2++)
                        {
                            if(e.ajh[i2] == 0 && dki[k1] > 1)
                            {
                                dki[k1]--;
                                continue;
                            }
                            dkg--;
                            ddc = 0;
                            for(int k3 = k1; k3 < dkg; k3++)
                            {
                                dkh[k3] = dkh[k3 + 1];
                                dki[k3] = dki[k3 + 1];
                            }

                            break;
                        }

                        super.aag.hdg(229);
                        super.aag.heb(dkg);
                        for(int l3 = 0; l3 < dkg; l3++)
                        {
                            super.aag.hdj(dkh[l3]);
                            super.aag.hdn(dki[l3]);
                        }

                        super.aag.hde();
                        dgm = false;
                        dgn = false;
                    }
                }
                boolean flag = false;
                if(l >= 93 && i1 >= 221 && l <= 104 && i1 <= 232)
                {
                    dla = !dla;
                    flag = true;
                }
                if(l >= 93 && i1 >= 240 && l <= 104 && i1 <= 251)
                {
                    dlb = !dlb;
                    flag = true;
                }
                if(l >= 191 && i1 >= 221 && l <= 202 && i1 <= 232)
                {
                    dlc = !dlc;
                    flag = true;
                }
                if(l >= 191 && i1 >= 240 && l <= 202 && i1 <= 251)
                {
                    dld = !dld;
                    flag = true;
                }
                if(flag)
                {
                    super.aag.hdg(138);
                    super.aag.heb(dla ? 1 : 0);
                    super.aag.heb(dlb ? 1 : 0);
                    super.aag.heb(dlc ? 1 : 0);
                    super.aag.heb(dld ? 1 : 0);
                    super.aag.hde();
                    dgm = false;
                    dgn = false;
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    dgn = true;
                    super.aag.hdg(125);
                    super.aag.hde();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    deh = false;
                    super.aag.hdg(43);
                    super.aag.hde();
                }
            } else
            if(ebd != 0)
            {
                deh = false;
                super.aag.hdg(43);
                super.aag.hde();
            }
            ebd = 0;
            ddd = 0;
        }
        if(!deh)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        efj.cba(byte0, byte1, 468, 12, 0xc90b1d);
        int l1 = 0x989898;
        efj.cam(byte0, byte1 + 12, 468, 18, l1, 160);
        efj.cam(byte0, byte1 + 30, 8, 248, l1, 160);
        efj.cam(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        efj.cam(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        efj.cam(byte0 + 8, byte1 + 99, 197, 24, l1, 160);
        efj.cam(byte0 + 8, byte1 + 192, 197, 23, l1, 160);
        efj.cam(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        efj.cam(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        efj.cam(byte0 + 8, byte1 + 30, 197, 69, j2, 160);
        efj.cam(byte0 + 8, byte1 + 123, 197, 69, j2, 160);
        efj.cam(byte0 + 8, byte1 + 215, 197, 43, j2, 160);
        efj.cam(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 3; i3++)
            efj.cbc(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 3; i4++)
            efj.cbc(byte0 + 8, byte1 + 123 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            efj.cbc(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                efj.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 69, 0);
            if(j5 < 5)
                efj.cbd(byte0 + 8 + j5 * 49, byte1 + 123, 69, 0);
            efj.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        efj.cbc(byte0 + 8, byte1 + 215, 197, 0);
        efj.cbc(byte0 + 8, byte1 + 257, 197, 0);
        efj.cbd(byte0 + 8, byte1 + 215, 43, 0);
        efj.cbd(byte0 + 204, byte1 + 215, 43, 0);
        efj.cdn("Preparing to duel with: " + ekg, byte0 + 1, byte1 + 10, 1, 0xffffff);
        efj.cdn("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        efj.cdn("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        efj.cdn("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        efj.cdn("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        efj.cdn("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        efj.cdn("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        efj.cdn("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        efj.cdn("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        efj.cbb(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(dla)
            efj.cba(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        efj.cbb(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dlb)
            efj.cba(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        efj.cbb(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(dlc)
            efj.cba(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        efj.cbb(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dld)
            efj.cba(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!dgn)
            efj.ccb(byte0 + 217, byte1 + 238, del + 25);
        efj.ccb(byte0 + 394, byte1 + 238, del + 26);
        if(dgm)
        {
            efj.cdl("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            efj.cdl("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(dgn)
        {
            efj.cdl("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            efj.cdl("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < eja; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            efj.cdd(l5, j6, 48, 32, den + e.ajf[ejb[k5]], e.ajk[ejb[k5]], 0, 0, false);
            if(e.ajh[ejb[k5]] == 0)
                efj.cdn(String.valueOf(ejc[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < dkg; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            efj.cdd(k6, i7, 48, 32, den + e.ajf[dkh[i6]], e.ajk[dkh[i6]], 0, 0, false);
            if(e.ajh[dkh[i6]] == 0)
                efj.cdn(String.valueOf(dki[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.fke > k6 && super.fke < k6 + 48 && super.fkf > i7 && super.fkf < i7 + 32)
                efj.cdn(e.ame[dkh[i6]] + ": @whi@" + e.amf[dkh[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < edl; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 124 + byte1 + (l6 / 4) * 34;
            efj.cdd(j7, k7, 48, 32, den + e.ajf[edm[l6]], e.ajk[edm[l6]], 0, 0, false);
            if(e.ajh[edm[l6]] == 0)
                efj.cdn(String.valueOf(edn[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.fke > j7 && super.fke < j7 + 48 && super.fkf > k7 && super.fkf < k7 + 32)
                efj.cdn(e.ame[edm[l6]] + ": @whi@" + e.amf[edm[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void fbl()
    {
        super.fkn = "";
        super.fla = "";
    }

    private final void fbm()
    {
        if((ema & 1) == 1 && fab(ema))
            return;
        if((ema & 1) == 0 && fab(ema))
        {
            if(fab(ema + 1 & 7))
            {
                ema = ema + 1 & 7;
                return;
            }
            if(fab(ema + 7 & 7))
                ema = ema + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int l = 0; l < 7; l++)
        {
            if(!fab(ema + ai[l] + 8 & 7))
                continue;
            ema = ema + ai[l] + 8 & 7;
            break;
        }

        if((ema & 1) == 0 && fab(ema))
        {
            if(fab(ema + 1 & 7))
            {
                ema = ema + 1 & 7;
                return;
            }
            if(fab(ema + 7 & 7))
                ema = ema + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    private final void fbn()
    {
        eck = 0;
        ehl = 0;
        djf = "";
        djg = "";
        eil = "Please enter a username:";
        eim = "*" + djf + "*";
        efg = 0;
        dnj = 0;
    }

    protected final void add()
    {
        edh = 0;
        ehl = 0;
        eck = 0;
        dhf = 0;
    }

    final void fca(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = ddi[arg4];
        int l = f1.gml + (dke + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;
        if(i1 == 5)
        {
            i1 = 3;
            flag = true;
        } else
        if(i1 == 6)
        {
            i1 = 2;
            flag = true;
        } else
        if(i1 == 7)
        {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + efl[(f1.gmk / e.akk[f1.gmj]) % 4];
        if(f1.gml == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (e.akm[f1.gmj] * arg6) / 100;
            j1 = i1 * 3 + dei[(dji / (e.akl[f1.gmj] - 1)) % 8];
        } else
        if(f1.gml == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (e.akm[f1.gmj] * arg6) / 100;
            j1 = i1 * 3 + ded[(dji / e.akl[f1.gmj]) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = ddh[l][k1];
            int k2 = e.aig[f1.gmj][l1];
            if(k2 >= 0)
            {
                int i3 = 0;
                int j3 = 0;
                int k3 = j1;
                if(flag && i1 >= 1 && i1 <= 3 && e.anc[k2] == 1)
                    k3 += 15;
                if(i1 != 5 || e.anb[k2] == 1)
                {
                    int l3 = k3 + e.and[k2];
                    i3 = (i3 * arg2) / ((j) (efj)).bmj[l3];
                    j3 = (j3 * arg3) / ((j) (efj)).bmk[l3];
                    int i4 = (arg2 * ((j) (efj)).bmj[l3]) / ((j) (efj)).bmj[e.and[k2]];
                    i3 -= (i4 - arg2) / 2;
                    int j4 = e.amn[k2];
                    int k4 = 0;
                    if(j4 == 1)
                    {
                        j4 = e.ain[f1.gmj];
                        k4 = e.ajc[f1.gmj];
                    } else
                    if(j4 == 2)
                    {
                        j4 = e.aja[f1.gmj];
                        k4 = e.ajc[f1.gmj];
                    } else
                    if(j4 == 3)
                    {
                        j4 = e.ajb[f1.gmj];
                        k4 = e.ajc[f1.gmj];
                    }
                    efj.cdd(arg0 + i3, arg1 + j3, i4, arg3, l3, j4, k4, arg5, flag);
                }
            }
        }

        if(f1.gnf > 0)
        {
            ebg[efd] = efj.cef(f1.gne, 1) / 2;
            if(ebg[efd] > 150)
                ebg[efd] = 150;
            ebh[efd] = (efj.cef(f1.gne, 1) / 300) * efj.ced(1);
            ebe[efd] = arg0 + arg2 / 2;
            ebf[efd] = arg1;
            efe[efd++] = f1.gne;
        }
        if(f1.gml == 8 || f1.gml == 9 || f1.gnl != 0)
        {
            if(f1.gnl > 0)
            {
                int i2 = arg0;
                if(f1.gml == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.gml == 9)
                    i2 += (20 * arg6) / 100;
                int l2 = (f1.gnj * 30) / f1.gnk;
                dfg[egl] = i2 + arg2 / 2;
                dfh[egl] = arg1;
                dfi[egl++] = l2;
            }
            if(f1.gnl > 150)
            {
                int j2 = arg0;
                if(f1.gml == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.gml == 9)
                    j2 += (10 * arg6) / 100;
                efj.ccb((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, del + 12);
                efj.cdl(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
    }

    private final void fcb(boolean arg0)
    {
        int l = ((j) (efj)).blg - 199;
        int i1 = 36;
        efj.ccb(l - 49, 3, del + 5);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.cbh(160, 160, 160);
        if(ekb == 0)
            j1 = j.cbh(220, 220, 220);
        else
            k1 = j.cbh(220, 220, 220);
        efj.cam(l, i1, c1 / 2, 24, j1, 128);
        efj.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        efj.cam(l, i1 + 24, c1, c2 - 24, j.cbh(220, 220, 220), 128);
        efj.cbc(l, i1 + 24, c1, 0);
        efj.cbd(l + c1 / 2, i1, 24, 0);
        efj.cbc(l, (i1 + c2) - 16, c1, 0);
        efj.cdl("Friends", l + c1 / 4, i1 + 16, 4, 0);
        efj.cdl("Ignore", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        ejn.gfm(eka);
        if(ekb == 0)
        {
            for(int l1 = 0; l1 < super.aak; l1++)
            {
                String s1;
                if(super.aam[l1] == 99)
                    s1 = "@gre@";
                else
                if(super.aam[l1] > 0)
                    s1 = "@yel@";
                else
                    s1 = "@red@";
                ejn.gga(eka, l1, s1 + t.fnd(super.aal[l1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(ekb == 1)
        {
            for(int i2 = 0; i2 < super.aan; i2++)
                ejn.gga(eka, i2, "@yel@" + t.fnd(super.aba[i2]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        ejn.ged();
        if(ekb == 0)
        {
            int j2 = ejn.ggh(eka);
            if(j2 >= 0 && super.fke < 489)
            {
                if(super.fke > 429)
                    efj.cdl("Click to remove " + t.fnd(super.aal[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.aam[j2] == 99)
                    efj.cdl("Click to message " + t.fnd(super.aal[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.aam[j2] > 0)
                    efj.cdl(t.fnd(super.aal[j2]) + " is on world " + super.aam[j2], l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                    efj.cdl(t.fnd(super.aal[j2]) + " is offline", l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                efj.cdl("Click a name to send a message", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int j3;
            if(super.fke > l && super.fke < l + c1 && super.fkf > (i1 + c2) - 16 && super.fkf < i1 + c2)
                j3 = 0xffff00;
            else
                j3 = 0xffffff;
            efj.cdl("Click here to add a friend", l + c1 / 2, (i1 + c2) - 3, 1, j3);
        }
        if(ekb == 1)
        {
            int k2 = ejn.ggh(eka);
            if(k2 >= 0 && super.fke < 489 && super.fke > 429)
            {
                if(super.fke > 429)
                    efj.cdl("Click to remove " + t.fnd(super.aba[k2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                efj.cdl("Blocking messages from:", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int k3;
            if(super.fke > l && super.fke < l + c1 && super.fkf > (i1 + c2) - 16 && super.fkf < i1 + c2)
                k3 = 0xffff00;
            else
                k3 = 0xffffff;
            efj.cdl("Click here to add a name", l + c1 / 2, (i1 + c2) - 3, 1, k3);
        }
        if(!arg0)
            return;
        l = super.fke - (((j) (efj)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            ejn.gea(l + (((j) (efj)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && ebd == 1)
                if(l < 98 && ekb == 1)
                {
                    ekb = 0;
                    ejn.gfn(eka);
                } else
                if(l > 98 && ekb == 0)
                {
                    ekb = 1;
                    ejn.gfn(eka);
                }
            if(ebd == 1 && ekb == 0)
            {
                int l2 = ejn.ggh(eka);
                if(l2 >= 0 && super.fke < 489)
                    if(super.fke > 429)
                        ack(super.aal[l2]);
                    else
                    if(super.aam[l2] != 0)
                    {
                        efm = 2;
                        ekc = super.aal[l2];
                        super.fkn = "";
                        super.fla = "";
                    }
            }
            if(ebd == 1 && ekb == 1)
            {
                int i3 = ejn.ggh(eka);
                if(i3 >= 0 && super.fke < 489 && super.fke > 429)
                    aci(super.aba[i3]);
            }
            if(i1 > 166 && ebd == 1 && ekb == 0)
            {
                efm = 1;
                super.fkl = "";
                super.fkm = "";
            }
            if(i1 > 166 && ebd == 1 && ekb == 1)
            {
                efm = 3;
                super.fkl = "";
                super.fkm = "";
            }
            ebd = 0;
        }
    }

    private final void fcc()
    {
        if(super.abi > 0)
            super.abi--;
        if(ehl == 0)
        {                    
        if(autoLog) {abn(un,pw,false);
            setFightMode(1);}                     
            ehm.gea(super.fke, super.fkf, super.fkh, super.fkg);
            if(ehm.geb(dnn))
                ehl = 1;
            if(ehm.geb(eaa))
            {
                ehl = 2;
                dkf.ggc(elb, "Please enter your username and password");
                dkf.ggc(elc, un);
                dkf.ggc(eld, pw);
                dkf.ggg(elc);
                return;
            }
        } else
        if(ehl == 1)
        {
            dmc.gea(super.fke, super.fkf, super.fkh, super.fkg);
            if(dmc.geb(ejj))
            {
                ehl = 0;
                return;
            }
        } else
        if(ehl == 2)
        {
            dkf.gea(super.fke, super.fkf, super.fkh, super.fkg);
            if(dkf.geb(elf))
                ehl = 0;
            if(dkf.geb(elc))
                dkf.ggg(eld);
            if(dkf.geb(eld))
                dkf.ggg(serv);           
            if(dkf.geb(eld) || dkf.geb(ele) || dkf.geb(serv))
            {
                server = dkf.ggd(serv);
                int serv = Integer.parseInt(server);
                if (validServer(serv))
                {
                changeWorld(Integer.parseInt(server));
                } else
                dkf.ggc(elb, "Invalid server " + serv); 
                un = dkf.ggd(elc);
                pw = dkf.ggd(eld);                
                djf = dkf.ggd(elc);
                djg = dkf.ggd(eld);              
                abn(djf, djg, false);               
                setFightMode(SMode);                      
                
                
            }
        }
    }    
    public void changeWorld(int Serv){
    	switch (Serv){
    		case 81: {	
    				super.aac = "uk1.runescape.com";
           			super.aad = 43594;
           			world = 81;
    				break;
    			}
    		case 82: {	
    				super.aac = "uk1.runescape.com";
        		        super.aad = 43595;
        		        world = 82;
    				break;
    			}
    		case 83: {	
    				super.aac = "ul3.runescape.com";
                   		super.aad = 43594;
                   		world = 83;
    				break;
    			}
    		case 84: {	
    				super.aac = "ul3.runescape.com";
               			super.aad = 43595;
               			world = 84;
    				break;
    			}	
    		case 85: {	
    				super.aac = "cet3b.runescape.com";
          		        super.aad = 43594;
          		        world = 85;
    				break;
    			}
    		case 86: {	
    				super.aac = "cet3b.runescape.com";
           			super.aad = 43595;
           			world = 86;
    				break;
    			}	
    		
        }
    }			
    public boolean validServer(int servage){
    	if (servage == 81 || servage == 82 || servage == 83 || servage == 84 || servage == 85 || servage == 86)
    		return true;
    	return false;
    }
    private final void fcd(int l, int i1, int j1)
    {
        if(j1 == 0)
        {
            fde(dgd, dge, l, i1 - 1, l, i1, false, true);
            return;
        }
        if(j1 == 1)
        {
            fde(dgd, dge, l - 1, i1, l, i1, false, true);
            return;
        } else
        {
            fde(dgd, dge, l, i1, l, i1, true, true);
            return;
        }
    }

    public final int fce(int arg0)
    {
        int l = 0;
        for(int i1 = 0; i1 < eja; i1++)
            if(ejb[i1] == arg0)
                if(e.ajh[arg0] == 1)
                    l++;
                else
                    l += ejc[i1];

        return l;
    }

    protected final void fcf(int arg0, int arg1, int arg2)
    {
        dme[dmd] = arg1;
        dmf[dmd] = arg2;
        dmd = dmd + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++)
        {
            int i1 = dmd - l & 0x1fff;
            if(dme[i1] == arg1 && dmf[i1] == arg2)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int k1 = dmd - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(dme[l1] != arg1 || dmf[l1] != arg2)
                        flag = true;
                    if(dme[k1] != dme[l1] || dmf[k1] != dmf[l1])
                        break;
                    if(j1 == l - 1 && flag && eda == 0 && dhf == 0)
                    {
                        enl();
                        return;
                    }
                }

            }
        }

    }

    protected final void fcg(Runnable runnable)
    {
        if(link.fni != null)
        {
            link.gah(runnable);
            return;
        } else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    private final void fch(int l, int i1, int j1)
    {
        efj.cbe(l, i1, j1);
        efj.cbe(l - 1, i1, j1);
        efj.cbe(l + 1, i1, j1);
        efj.cbe(l, i1 - 1, j1);
        efj.cbe(l, i1 + 1, j1);
    }

    protected final int adi()
    {
        return link.fnj;
    }

    protected final void fci()
    {
        if(ein)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 16));
            g1.setColor(Color.yellow);
            int l = 35;
            g1.drawString("Warning", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.drawString("Idiot mistake, listen", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.setFont(new Font("Helvetica", 1, 12));
            g1.drawString("You are either not connected to the internet", 30, l);
            l += 30;  
            g1.drawString("Or something is messed up badly, please tell me", 30, l);          
            fle(1);
            return;
        }
        if(eki)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - unable to load game!", 50, 50);
            g2.drawString("To play RuneScape make sure you play from", 50, 100);
            g2.drawString("http://www.runescape.com", 50, 150);
            fle(1);
            return;
        }
        if(elm)
        {
            Graphics g3 = getGraphics();
            g3.setColor(Color.black);
            g3.fillRect(0, 0, 512, 356);
            g3.setFont(new Font("Helvetica", 1, 20));
            g3.setColor(Color.white);
            g3.drawString("Error - out of memory!", 50, 50);
            g3.drawString("Close ALL unnecessary programs", 50, 100);
            g3.drawString("and windows before loading the game", 50, 150);
            g3.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            fle(1);
            return;
        }
        try
        {
            if(eck == 0)
            {
                efj.bnf = false;
                emj();
            }            
            if(eck == 1)
            {
                efj.bnf = true;
                faa();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            fdd();
            elm = true;
        }
    }

    private final boolean fcj(int arg0)
    {
        for(int l = 0; l < eja; l++)
            if(ejb[l] == arg0 && ejd[l] == 1)
                return true;

        return false;
    }

    protected final void acb()
    {
        edh = 0;
        if(dhf != 0)
        {
            add();
            return;
        } else
        {
            super.acb();
            return;
        }
    }

    private final void fck()
    {
        byte abyte0[] = enb(4, "Configuration", 10);
        if(abyte0 == null)
        {
            ein = true;
            return;
        }
        e.baa(abyte0, dej);
        byte abyte1[] = enb(1, "Chat system", 15);
        if(abyte1 == null)
        {
            ein = true;
            return;
        } else
        {
            byte abyte2[] = t.fng("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = t.fng("badenc.txt", 0, abyte1);
            byte abyte4[] = t.fng("hostenc.txt", 0, abyte1);
            byte abyte5[] = t.fng("tldlist.txt", 0, abyte1);
            u.ffl(new q(abyte2), new q(abyte3), new q(abyte4), new q(abyte5));
            return;
        }
    }

    final void fcl(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = e.ajf[l1] + den;
        int l2 = e.ajk[l1];
        efj.cdd(l, i1, j1, k1, k2, l2, 0, 0, false);
    }

    private final void fcm()
    {
        efj.ccb(0, dcm - 4, del + 23);
        int l = j.cbh(200, 200, 255);
        if(ell == 0)
            l = j.cbh(255, 200, 50);
        if(ehc % 30 > 15)
            l = j.cbh(255, 50, 50);
        efj.cdl("All messages", 54, dcm + 6, 0, l);
        l = j.cbh(200, 200, 255);
        if(ell == 1)
            l = j.cbh(255, 200, 50);
        if(ehd % 30 > 15)
            l = j.cbh(255, 50, 50);
        efj.cdl("Chat history", 155, dcm + 6, 0, l);
        l = j.cbh(200, 200, 255);
        if(ell == 2)
            l = j.cbh(255, 200, 50);
        if(ehe % 30 > 15)
            l = j.cbh(255, 50, 50);
        efj.cdl("Quest history", 255, dcm + 6, 0, l);
        l = j.cbh(200, 200, 255);
        if(ell == 3)
            l = j.cbh(255, 200, 50);
        if(ehf % 30 > 15)
            l = j.cbh(255, 50, 50);
        efj.cdl("Private history", 355, dcm + 6, 0, l);
        efj.cdl("Report abuse", 457, dcm + 6, 0, 0xffffff);
    }

    private final void fcn()
    {
        dhi.gea(super.fke, super.fkf, super.fkh, super.fkg);
        if(dhi.geb(eec))
            do
                dhl = ((dhl - 1) + e.ake) % e.ake;
            while((e.ana[dhl] & 3) != 1 || (e.ana[dhl] & 4 * die) == 0);
        if(dhi.geb(eed))
            do
                dhl = (dhl + 1) % e.ake;
            while((e.ana[dhl] & 3) != 1 || (e.ana[dhl] & 4 * die) == 0);
        if(dhi.geb(eee))
            dia = ((dia - 1) + dlj.length) % dlj.length;
        if(dhi.geb(eef))
            dia = (dia + 1) % dlj.length;
        if(dhi.geb(eeg) || dhi.geb(eeh))
        {
            for(die = 3 - die; (e.ana[dhl] & 3) != 1 || (e.ana[dhl] & 4 * die) == 0; dhl = (dhl + 1) % e.ake);
            for(; (e.ana[dhm] & 3) != 2 || (e.ana[dhm] & 4 * die) == 0; dhm = (dhm + 1) % e.ake);
        }
        if(dhi.geb(eei))
            dib = ((dib - 1) + deg.length) % deg.length;
        if(dhi.geb(eej))
            dib = (dib + 1) % deg.length;
        if(dhi.geb(eek))
            did = ((did - 1) + ekd.length) % ekd.length;
        if(dhi.geb(eel))
            did = (did + 1) % ekd.length;
        if(dhi.geb(eem))
            dic = ((dic - 1) + deg.length) % deg.length;
        if(dhi.geb(een))
            dic = (dic + 1) % deg.length;
        if(dhi.geb(efa))
        {
            super.aag.hdg(238);
            super.aag.heb(die);
            super.aag.heb(dhl);
            super.aag.heb(dhm);
            super.aag.heb(dhn);
            super.aag.heb(dia);
            super.aag.heb(dib);
            super.aag.heb(dic);
            super.aag.heb(did);
            super.aag.hde();
            efj.cak();
            efc = false;
        }
    }

    private final void fda()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        efj.cba(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        efj.cam(byte0, byte1 + 16, 468, 246, l, 160);
        efj.cdl("Please confirm your duel with @yel@" + t.fnd(eme), byte0 + 234, byte1 + 12, 1, 0xffffff);
        efj.cdl("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < dgg; i1++)
        {
            String s1 = e.ame[dgh[i1]];
            if(e.ajh[dgh[i1]] == 0)
                s1 = s1 + " x " + enk(dgi[i1]);
            efj.cdl(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(dgg == 0)
            efj.cdl("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        efj.cdl("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < dhb; j1++)
        {
            String s2 = e.ame[dhc[j1]];
            if(e.ajh[dhc[j1]] == 0)
                s2 = s2 + " x " + enk(dhd[j1]);
            efj.cdl(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(dhb == 0)
            efj.cdl("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(eac == 0)
            efj.cdl("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            efj.cdl("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(ead == 0)
            efj.cdl("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            efj.cdl("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(eae == 0)
            efj.cdl("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            efj.cdl("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(eaf == 0)
            efj.cdl("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            efj.cdl("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        efj.cdl("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!dlm)
        {
            efj.ccb((byte0 + 118) - 35, byte1 + 238, del + 25);
            efj.ccb((byte0 + 352) - 35, byte1 + 238, del + 26);
        } else
        {
            efj.cdl("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(ebd == 1)
        {
            if(super.fke < byte0 || super.fkf < byte1 || super.fke > byte0 + 468 || super.fkf > byte1 + 262)
            {
                dll = false;
                super.aag.hdg(27);
                super.aag.hde();
            }
            if(super.fke >= (byte0 + 118) - 35 && super.fke <= byte0 + 118 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                dlm = true;
                super.aag.hdg(175);
                super.aag.hde();
            }
            if(super.fke >= (byte0 + 352) - 35 && super.fke <= byte0 + 353 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                dll = false;
                super.aag.hdg(43);
                super.aag.hde();
            }
            ebd = 0;
        }
    }

    private final void fdb(String s1)
    {
        if(deb == null)
            return;
        if(ejl)
        {
            return;
        } else
        {
            deb.ggm(dnm, t.fne(s1 + ".pcm", dnm), t.fnf(s1 + ".pcm", dnm));
            return;
        }
    }

    private final void fdc(boolean arg0)
    {
        int l = ((j) (efj)).blg - 199;
        int i1 = 36;
        efj.ccb(l - 49, 3, del + 4);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.cbh(160, 160, 160);
        if(ebl == 0)
            j1 = j.cbh(220, 220, 220);
        else
            k1 = j.cbh(220, 220, 220);
        efj.cam(l, i1, c1 / 2, 24, j1, 128);
        efj.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        efj.cam(l, i1 + 24, c1, 90, j.cbh(220, 220, 220), 128);
        efj.cam(l, i1 + 24 + 90, c1, c2 - 90 - 24, j.cbh(160, 160, 160), 128);
        efj.cbc(l, i1 + 24, c1, 0);
        efj.cbd(l + c1 / 2, i1, 24, 0);
        efj.cbc(l, i1 + 113, c1, 0);
        efj.cdl("Magic", l + c1 / 4, i1 + 16, 4, 0);
        efj.cdl("Prayers", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(ebl == 0)
        {
            ebj.gfm(ebk);
            int l1 = 0;
            for(int l2 = 0; l2 < e.ahm; l2++)
            {
                String s1 = "@yel@";
                for(int k4 = 0; k4 < e.aii[l2]; k4++)
                {
                    int j5 = e.aik[l2][k4];
                    if(faf(j5, e.ail[l2][k4]))
                        continue;
                    s1 = "@whi@";
                    break;
                }

                int k5 = egk[6];
                if(e.aih[l2] > k5)
                    s1 = "@bla@";
                ebj.gga(ebk, l1++, s1 + "Level " + e.aih[l2] + ": " + e.amk[l2]);
            }

            ebj.ged();
            int l3 = ebj.ggh(ebk);
            if(l3 != -1)
            {
                efj.cdn("Level " + e.aih[l3] + ": " + e.amk[l3], l + 2, i1 + 124, 1, 0xffff00);
                efj.cdn(e.aml[l3], l + 2, i1 + 136, 0, 0xffffff);
                for(int l4 = 0; l4 < e.aii[l3]; l4++)
                {
                    int l5 = e.aik[l3][l4];
                    efj.ccb(l + 2 + l4 * 44, i1 + 150, den + e.ajf[l5]);
                    int i6 = fce(l5);
                    int j6 = e.ail[l3][l4];
                    String s3 = "@red@";
                    if(faf(l5, j6))
                        s3 = "@gre@";
                    efj.cdn(s3 + i6 + "/" + j6, l + 2 + l4 * 44, i1 + 150, 1, 0xffffff);
                }

            } else
            {
                efj.cdn("Point at a spell for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(ebl == 1)
        {
            ebj.gfm(ebk);
            int i2 = 0;
            for(int i3 = 0; i3 < e.ahc; i3++)
            {
                String s2 = "@whi@";
                if(e.amh[i3] > efk[5])
                    s2 = "@bla@";
                if(dhe[i3])
                    s2 = "@gre@";
                ebj.gga(ebk, i2++, s2 + "Level " + e.amh[i3] + ": " + e.ahn[i3]);
            }

            ebj.ged();
            int i4 = ebj.ggh(ebk);
            if(i4 != -1)
            {
                efj.cdl("Level " + e.amh[i4] + ": " + e.ahn[i4], l + c1 / 2, i1 + 130, 1, 0xffff00);
                efj.cdl(e.aia[i4], l + c1 / 2, i1 + 145, 0, 0xffffff);
                efj.cdl("Drain rate: " + e.ami[i4], l + c1 / 2, i1 + 160, 1, 0);
            } else
            {
                efj.cdn("Point at a prayer for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(!arg0)
            return;
        l = super.fke - (((j) (efj)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            ebj.gea(l + (((j) (efj)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && ebd == 1)
                if(l < 98 && ebl == 1)
                {
                    ebl = 0;
                    ebj.gfn(ebk);
                } else
                if(l > 98 && ebl == 0)
                {
                    ebl = 1;
                    ebj.gfn(ebk);
                }
            if(ebd == 1 && ebl == 0)
            {
                int j2 = ebj.ggh(ebk);
                if(j2 != -1)
                {
                    int j3 = egk[6];
                    if(e.aih[j2] > j3)
                    {
                        feb("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int j4;
                        for(j4 = 0; j4 < e.aii[j2]; j4++)
                        {
                            int i5 = e.aik[j2][j4];
                            if(faf(i5, e.ail[j2][j4]))
                                continue;
                            feb("You don't have all the reagents you need for this spell", 3);
                            j4 = -1;
                            break;
                        }

                        if(j4 == e.aii[j2])
                        {
                            edg = j2;
                            eig = -1;
                        }
                    }
                }
            }
            if(ebd == 1 && ebl == 1)
            {
                int k2 = ebj.ggh(ebk);
                if(k2 != -1)
                {
                    int k3 = efk[5];
                    if(e.amh[k2] > k3)
                        feb("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(egk[5] == 0)
                        feb("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(dhe[k2])
                    {
                        super.aag.hdg(162);
                        super.aag.heb(k2);
                        super.aag.hde();
                        dhe[k2] = false;
                        fdb("prayeroff");
                    } else
                    {
                        super.aag.hdg(202);
                        super.aag.heb(k2);
                        super.aag.hde();
                        dhe[k2] = true;
                        fdb("prayeron");
                    }
                }
            }
            ebd = 0;
        }
    }

    private final void fdd()
    {
        try
        {
            if(efj != null)
            {
                efj.cbi();
                efj.blm = null;
                efj = null;
            }
            if(efn != null)
            {
                efn.bha();
                efn = null;
            }
            dkj = null;
            ddf = null;
            dkl = null;
            eba = null;
            ege = null;
            dgj = null;
            ddi = null;
            dgc = null;
            if(ejk != null)
            {
                ejk.gim = null;
                ejk.ghm = null;
                ejk.gih = null;
                ejk.gin = null;
                ejk = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    private final boolean fde(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = ejk.gkb(arg0, arg1, arg2, arg3, arg4, arg5, djk, djl, arg6);
        if(l == -1)
            if(arg7)
            {
                l = 1;
                djk[0] = arg2;
                djl[0] = arg3;
            } else
            {
                return false;
            }
        l--;
        arg0 = djk[l];
        arg1 = djl[l];
        l--;
        if(arg7)
            super.aag.hdg(226);
        else
            super.aag.hdg(211);
        super.aag.hdj(arg0 + dil);
        super.aag.hdj(arg1 + dim);
        if(arg7 && l == -1 && (arg0 + dil) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.aag.heb(djk[i1] - arg0);
            super.aag.heb(djl[i1] - arg1);
        }

        super.aag.hde();
        eak = -24;
        eal = super.fke;
        eam = super.fkf;
        return true;
    }

    private final boolean fdf(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = ejk.gkb(arg0, arg1, arg2, arg3, arg4, arg5, djk, djl, arg6);
        if(l == -1)
            return false;
        l--;
        arg0 = djk[l];
        arg1 = djl[l];
        l--;
        if(arg7)
            super.aag.hdg(226);
        else
            super.aag.hdg(211);
        super.aag.hdj(arg0 + dil);
        super.aag.hdj(arg1 + dim);
        if(arg7 && l == -1 && (arg0 + dil) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.aag.heb(djk[i1] - arg0);
            super.aag.heb(djl[i1] - arg1);
        }

        super.aag.hde();
        eak = -24;
        eal = super.fke;
        eam = super.fkf;
        return true;
    }

    private final boolean fdg(int arg0, int arg1)
    {
    loading = false;
        if(dfl != 0)
        {
            ejk.gie = false;
            return false;
        }
        if(Graphics){
            ejk.gie = false;
            return false;
        }	     
        dcj = false;
        arg0 += dnd;
        arg1 += dne;
        if(dng == din && arg0 > ddj && arg0 < ddl && arg1 > ddk && arg1 < ddm)
        {
            ejk.gie = true;
            return false;
        }
        loading = true;
        efj.cdl("Loading... Please wait", 256, 192, 1, 0xffffff);
        fcm();
        efj.caj(dci, 0, 0);
        int l = dil;
        int i1 = dim;
        int j1 = (arg0 + 24) / 48;
        int k1 = (arg1 + 24) / 48;
        dng = din;
        dil = j1 * 48 - 48;
        dim = k1 * 48 - 48;
        ddj = j1 * 48 - 32;
        ddk = k1 * 48 - 32;
        ddl = j1 * 48 + 32;
        ddm = k1 * 48 + 32;
        ejk.gkf(arg0, arg1, dng);
        dil -= dnd;
        dim -= dne;
        int l1 = dil - l;
        int i2 = dim - i1;
        for(int j2 = 0; j2 < djd; j2++)
        {
            ebm[j2] -= l1;
            ebn[j2] -= i2;
            int k2 = ebm[j2];
            int i3 = ebn[j2];
            int l3 = eca[j2];
            i k4 = ddf[j2];
            try
            {
                int j5 = ecb[j2];
                int i6;
                int l6;
                if(j5 == 0 || j5 == 4)
                {
                    i6 = e.all[l3];
                    l6 = e.alm[l3];
                } else
                {
                    l6 = e.all[l3];
                    i6 = e.alm[l3];
                }
                int i7 = ((k2 + k2 + i6) * ecj) / 2;
                int j7 = ((i3 + i3 + l6) * ecj) / 2;
                if(k2 >= 0 && i3 >= 0 && k2 < 96 && i3 < 96)
                {
                    efn.bgm(k4);
                    k4.cml(i7, -ejk.gla(i7, j7), j7);
                    ejk.gjj(k2, i3, l3);
                    if(l3 == 74)
                        k4.cmk(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + j2 + " obj:" + k4);
                runtimeexception.printStackTrace();
            }
        }

        for(int l2 = 0; l2 < egn; l2++)
        {
            dgk[l2] -= l1;
            dgl[l2] -= i2;
            int j3 = dgk[l2];
            int i4 = dgl[l2];
            int l4 = eik[l2];
            int k5 = eij[l2];
            try
            {
                ejk.gkj(j3, i4, k5, l4);
                i j6 = feg(j3, i4, k5, l4, l2);
                dkl[l2] = j6;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int k3 = 0; k3 < dkm; k3++)
        {
            ekj[k3] -= l1;
            ekk[k3] -= i2;
        }

        for(int j4 = 0; j4 < efg; j4++)
        {
            f f1 = ege[j4];
            f1.gmh -= l1 * ecj;
            f1.gmi -= i2 * ecj;
            for(int l5 = 0; l5 <= f1.gna; l5++)
            {
                f1.gnb[l5] -= l1 * ecj;
                f1.gnc[l5] -= i2 * ecj;
            }

        }

        for(int i5 = 0; i5 < dnj; i5++)
        {
            f f2 = ddi[i5];
            f2.gmh -= l1 * ecj;
            f2.gmi -= i2 * ecj;
            for(int k6 = 0; k6 <= f2.gna; k6++)
            {
                f2.gnb[k6] -= l1 * ecj;
                f2.gnc[k6] -= i2 * ecj;
            }

        }

        ejk.gie = true;
        return true;
    }

    private final void fdh()
    {
        int l = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        ejk.gkf(byte0 * 48 + 23, byte1 * 48 + 23, l);
        ejk.gle(dkj);
        char c1 = '\u2600';
        char c2 = '\u1900';
        char c3 = '\u044C';
        char c4 = '\u0378';
        efn.bbg = 4100;
        efn.bbh = 4100;
        efn.bbi = 1;
        efn.bbj = 4000;
        efn.bin(c1, -ejk.gla(c1, c2), c2, 912, c4, 0, c3 * 2);
        efn.bib();
        efj.cbf();
        efj.cbf();
        efj.cba(0, 0, 512, 6, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            efj.cbg(0, i1, 0, i1, 512, 8);

        efj.cba(0, 194, 512, 20, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            efj.cbg(0, j1, 0, 194 - j1, 512, 8);

        efj.ccb(15, 15, del + 10);
        efj.cca(dfd, 0, 0, 512, 200);
        efj.cbl(dfd);
        c1 = '\u2400';
        c2 = '\u2400';
        c3 = '\u044C';
        c4 = '\u0378';
        efn.bbg = 4100;
        efn.bbh = 4100;
        efn.bbi = 1;
        efn.bbj = 4000;
        efn.bin(c1, -ejk.gla(c1, c2), c2, 912, c4, 0, c3 * 2);
        efn.bib();
        efj.cbf();
        efj.cbf();
        efj.cba(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            efj.cbg(0, k1, 0, k1, 512, 8);

        efj.cba(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            efj.cbg(0, l1, 0, 194 - l1, 512, 8);

        efj.ccb(15, 15, del + 10);
        efj.cca(dfd + 1, 0, 0, 512, 200);
        efj.cbl(dfd + 1);
        for(int i2 = 0; i2 < 64; i2++)
        {
            efn.bgn(ejk.gih[0][i2]);
            efn.bgn(ejk.ghm[1][i2]);
            efn.bgn(ejk.gih[1][i2]);
            efn.bgn(ejk.ghm[2][i2]);
            efn.bgn(ejk.gih[2][i2]);
        }

        c1 = '\u2B80';
        c2 = '\u2880';
        c3 = '\u01F4';
        c4 = '\u0178';
        efn.bbg = 4100;
        efn.bbh = 4100;
        efn.bbi = 1;
        efn.bbj = 4000;
        efn.bin(c1, -ejk.gla(c1, c2), c2, 912, c4, 0, c3 * 2);
        efn.bib();
        efj.cbf();
        efj.cbf();
        efj.cba(0, 0, 512, 6, 0);
        for(int j2 = 6; j2 >= 1; j2--)
            efj.cbg(0, j2, 0, j2, 512, 8);

        efj.cba(0, 194, 512, 20, 0);
        for(int k2 = 6; k2 >= 1; k2--)
            efj.cbg(0, k2, 0, 194, 512, 8);

        efj.ccb(15, 15, del + 10);
        efj.cca(del + 10, 0, 0, 512, 200);
        efj.cbl(del + 10);
    }

    private final String fdi(int l)
    {
        if(link.fni != null)
            return link.gai(t.fnb(l));
        else
            return t.fnb(l);
    }

    protected final void adc()
    {
        edh = 0;
        setFightMode(SMode);
        dck = 1;
        dhf = 0;
        ehl = 0;
        eck = 1;
        fbl();
        efj.cak();
        efj.caj(dci, 0, 0);
        for(int l = 0; l < djd; l++)
        {
            efn.bgn(ddf[l]);
            ejk.gkg(ebm[l], ebn[l], eca[l]);
        }

        for(int i1 = 0; i1 < egn; i1++)
        {
            efn.bgn(dkl[i1]);
            ejk.gke(dgk[i1], dgl[i1], eij[i1], eik[i1]);
        }

        djd = 0;
        egn = 0;
        dkm = 0;
        efg = 0;
        for(int j1 = 0; j1 < 4000; j1++)
            eba[j1] = null;

        for(int k1 = 0; k1 < 500; k1++)
            ege[k1] = null;

        dnj = 0;
        for(int l1 = 0; l1 < 5000; l1++)
            dgj[l1] = null;

        for(int i2 = 0; i2 < 500; i2++)
            ddi[i2] = null;

        for(int j2 = 0; j2 < 50; j2++)
            dhe[j2] = false;

        ebd = 0;
        super.fkh = 0;
        super.fkg = 0;
        djh = false;
        emc = false;
        ece = false;
        super.aak = 0;
    }

    private final void fdj()
    {
        int l = 97;
        efj.cba(86, 77, 340, 180, 0);
        efj.cbb(86, 77, 340, 180, 0xffffff);
        efj.cdl("Warning! Proceed with caution", 256, l, 4, 0xff0000);
        l += 26;
        efj.cdl("If you go much further north you will enter the", 256, l, 1, 0xffffff);
        l += 13;
        efj.cdl("wilderness. This a very dangerous area where", 256, l, 1, 0xffffff);
        l += 13;
        efj.cdl("other players can attack you!", 256, l, 1, 0xffffff);
        l += 22;
        efj.cdl("The further north you go the more dangerous it", 256, l, 1, 0xffffff);
        l += 13;
        efj.cdl("becomes, but the more treasure you will find.", 256, l, 1, 0xffffff);
        l += 22;
        efj.cdl("In the wilderness an indicator at the bottom-right", 256, l, 1, 0xffffff);
        l += 13;
        efj.cdl("of the screen will show the current level of danger", 256, l, 1, 0xffffff);
        l += 22;
        int i1 = 0xffffff;
        if(super.fkf > l - 12 && super.fkf <= l && super.fke > 181 && super.fke < 331)
            i1 = 0xff0000;
        efj.cdl("Click here to close window", 256, l, 1, i1);
        if(ebd != 0)
        {
            if(super.fkf > l - 12 && super.fkf <= l && super.fke > 181 && super.fke < 331)
                dfj = 2;
            if(super.fke < 86 || super.fke > 426 || super.fkf < 77 || super.fkf > 257)
                dfj = 2;
            ebd = 0;
        }
    }

    final void fdk(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = ege[arg4];
        if(f1.hab == 255)
            return;
        int l = f1.gml + (dke + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;
        if(i1 == 5)
        {
            i1 = 3;
            flag = true;
        } else
        if(i1 == 6)
        {
            i1 = 2;
            flag = true;
        } else
        if(i1 == 7)
        {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + efl[(f1.gmk / 6) % 4];
        if(f1.gml == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (5 * arg6) / 100;
            j1 = i1 * 3 + dei[(dji / 5) % 8];
        } else
        if(f1.gml == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (5 * arg6) / 100;
            j1 = i1 * 3 + ded[(dji / 6) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = ddh[l][k1];
            int l2 = f1.gnd[l1] - 1;
            if(l2 >= 0)
            {
                int k3 = 0;
                int i4 = 0;
                int j4 = j1;
                if(flag && i1 >= 1 && i1 <= 3)
                    if(e.anc[l2] == 1)
                        j4 += 15;
                    else
                    if(l1 == 4 && i1 == 1)
                    {
                        k3 = -22;
                        i4 = -3;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = -8;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 3)
                    {
                        k3 = 26;
                        i4 = -5;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 1)
                    {
                        k3 = 22;
                        i4 = 3;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = 8;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 3)
                    {
                        k3 = -26;
                        i4 = 5;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    }
                if(i1 != 5 || e.anb[l2] == 1)
                {
                    int k4 = j4 + e.and[l2];
                    k3 = (k3 * arg2) / ((j) (efj)).bmj[k4];
                    i4 = (i4 * arg3) / ((j) (efj)).bmk[k4];
                    int l4 = (arg2 * ((j) (efj)).bmj[k4]) / ((j) (efj)).bmj[e.and[l2]];
                    k3 -= (l4 - arg2) / 2;
                    int i5 = e.amn[l2];
                    int j5 = ekd[f1.hac];
                    if(i5 == 1)
                        i5 = dlj[f1.gnn];
                    else
                    if(i5 == 2)
                        i5 = deg[f1.haa];
                    else
                    if(i5 == 3)
                        i5 = deg[f1.hab];
                    efj.cdd(arg0 + k3, arg1 + i4, l4, arg3, k4, i5, j5, arg5, flag);
                }
            }
        }
        if(PlayerHP)
        {
          if(f1.gnk > 0)
       		 {        
        	ebg[efd] = efj.cef("@gr1@" + f1.gnj + "/" + f1.gnk, 1) / 2;
        	ebh[efd] = (efj.cef("@gr1@" + f1.gnj + "/" + f1.gnk, 1) / 300) * efj.ced(1);
        	ebe[efd] = arg0 + arg2 / 2;
        	ebf[efd] = arg1;
       	        efe[efd++] = "@gr1@" + f1.gnj + "/" + f1.gnk;
        	} else {
       		 ebg[efd] = efj.cef("@gr1@??", 1) / 2;
       		 ebh[efd] = (efj.cef("@gr1@??", 1) / 300) * efj.ced(1);
       		 ebe[efd] = arg0 + arg2 / 2;
        	 ebf[efd] = arg1;
       		 efe[efd++] = "@gr1@??";        
        	}
        } else 
        if(f1.gnf > 0)
        {
            ebg[efd] = efj.cef(f1.gne, 1) / 2;
            if(ebg[efd] > 150)
                ebg[efd] = 150;
            ebh[efd] = (efj.cef(f1.gne, 1) / 300) * efj.ced(1);
            ebe[efd] = arg0 + arg2 / 2;
            ebf[efd] = arg1;
            efe[efd++] = f1.gne;
        }                
        if(f1.gnh > 0)
        {
            eai[dln] = arg0 + arg2 / 2;
            eaj[dln] = arg1;
            eag[dln] = arg6;
            eah[dln++] = f1.gng;
        }   
        if(f1.gml == 8 || f1.gml == 9 || f1.gnl != 0)
        {
            if(f1.gnl > 0)
            {
                int i2 = arg0;
                if(f1.gml == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.gml == 9)
                    i2 += (20 * arg6) / 100;
                int i3 = (f1.gnj * 30) / f1.gnk;
                dfg[egl] = i2 + arg2 / 2;
                dfh[egl] = arg1;
                dfi[egl++] = i3;
            }
            if(f1.gnl > 150)
            {
                int j2 = arg0;
                if(f1.gml == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.gml == 9)
                    j2 += (10 * arg6) / 100;
                efj.ccb((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, del + 11);
                efj.cdl(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
        if(f1.haj == 1 && f1.gnh == 0)
        {
            int k2 = arg5 + arg0 + arg2 / 2;
            if(f1.gml == 8)
                k2 -= (20 * arg6) / 100;
            else
            if(f1.gml == 9)
                k2 += (20 * arg6) / 100;
            int j3 = (16 * arg6) / 100;
            int l3 = (16 * arg6) / 100;
            efj.ccc(k2 - j3 / 2, arg1 - l3 / 2 - (10 * arg6) / 100, j3, l3, del + 13);
        }
    }

    private final void fdl()
    {
        efj.bnc = false;
        efj.cak();
        dhi.ged();
        int l = 140;
        int i1 = 50;
        l += 116;
        i1 -= 25;
        efj.ccf(l - 32 - 55, i1, 64, 102, e.and[dhn], deg[dic]);
        efj.cdd(l - 32 - 55, i1, 64, 102, e.and[dhm], deg[dib], ekd[did], 0, false);
        efj.cdd(l - 32 - 55, i1, 64, 102, e.and[dhl], dlj[dia], ekd[did], 0, false);
        efj.ccf(l - 32, i1, 64, 102, e.and[dhn] + 6, deg[dic]);
        efj.cdd(l - 32, i1, 64, 102, e.and[dhm] + 6, deg[dib], ekd[did], 0, false);
        efj.cdd(l - 32, i1, 64, 102, e.and[dhl] + 6, dlj[dia], ekd[did], 0, false);
        efj.ccf((l - 32) + 55, i1, 64, 102, e.and[dhn] + 12, deg[dic]);
        efj.cdd((l - 32) + 55, i1, 64, 102, e.and[dhm] + 12, deg[dib], ekd[did], 0, false);
        efj.cdd((l - 32) + 55, i1, 64, 102, e.and[dhl] + 12, dlj[dia], ekd[did], 0, false);
        efj.ccb(0, dcm, del + 22);
        efj.caj(dci, 0, 0);
    }

    private final void fdm()
    {
        byte abyte0[] = enb(7, "2d graphics", 20);
        if(abyte0 == null)
        {
            ein = true;
            return;
        }
        byte abyte1[] = t.fng("index.dat", 0, abyte0);
        efj.cbj(del, t.fng("inv1.dat", 0, abyte0), abyte1, 1);
        efj.cbj(del + 1, t.fng("inv2.dat", 0, abyte0), abyte1, 6);
        efj.cbj(del + 9, t.fng("bubble.dat", 0, abyte0), abyte1, 1);
        efj.cbj(del + 10, t.fng("runescape.dat", 0, abyte0), abyte1, 1);
        efj.cbj(del + 11, t.fng("splat.dat", 0, abyte0), abyte1, 3);
        efj.cbj(del + 14, t.fng("icon.dat", 0, abyte0), abyte1, 8);
        efj.cbj(del + 22, t.fng("hbar.dat", 0, abyte0), abyte1, 1);
        efj.cbj(del + 23, t.fng("hbar2.dat", 0, abyte0), abyte1, 1);
        efj.cbj(del + 24, t.fng("compass.dat", 0, abyte0), abyte1, 1);
        efj.cbj(del + 25, t.fng("buttons.dat", 0, abyte0), abyte1, 2);
        efj.cbj(dem, t.fng("scrollbar.dat", 0, abyte0), abyte1, 2);
        efj.cbj(dem + 2, t.fng("corners.dat", 0, abyte0), abyte1, 4);
        efj.cbj(dem + 6, t.fng("arrows.dat", 0, abyte0), abyte1, 2);
        efj.cbj(dfa, t.fng("projectile.dat", 0, abyte0), abyte1, e.ahg);
        int l = e.aje;
        for(int i1 = 1; l > 0; i1++)
        {
            int j1 = l;
            l -= 30;
            if(j1 > 30)
                j1 = 30;
            efj.cbj(den + (i1 - 1) * 30, t.fng("objects" + i1 + ".dat", 0, abyte0), abyte1, j1);
        }

        efj.cbm(del);
        efj.cbm(del + 9);
        for(int k1 = 11; k1 <= 26; k1++)
            efj.cbm(del + k1);

        for(int l1 = 0; l1 < e.ahg; l1++)
            efj.cbm(dfa + l1);

        for(int i2 = 0; i2 < e.aje; i2++)
            efj.cbm(den + i2);

    }

    private final void fdn(int l, int i1, int j1, int k1, boolean flag)
    {
        if(fdf(l, i1, j1, k1, j1, k1, false, flag))
        {
            return;
        } else
        {
            fde(l, i1, j1, k1, j1, k1, true, flag);
            return;
        }
    }
    
    protected final void fea(int l)
    {  
       
       if (l == 1015){ // f8
	    		if (fow){
	    			feb("@red@Canibalistic: @yel@Fog of war disabled",3);
	    			fow = false;
			}
			else{
				feb("@red@Canibalistic: @yel@Fog of war enabled",3);
				fow = true;
		        } 
		} 
       /**if(l == 1019)
       {
       int Player = playerByName(lastTrader);
       if(Player != -1)
       TradePlayer(Player);
       }*/	
       if(l == 1002)
       {
       Say(myPlayerLastSaid);
       }
       byte bytes[] = {1,2,3};
       if(l == 1019)//f12       	
		{
			if (!Graphics){
				System.out.println("Graphics disabled");
				feb("@red@Canibalistic: @yel@Graphics disabled",3);
				adf(1,2,bytes);
				Graphics = true;			
			}
			else{
				System.out.println("Graphics enabled");
				feb("@red@Canibalistic: @yel@Graphics enabled",3);
				adf(1,2,bytes);
				Graphics = false;
			}
		}
       if(l == 1016)//f9
       {
       javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 GUI();
                 feb("@red@Canibalistic: @yel@Panel Activated!",3);
             }
         });
       }
       if(l == 1018)//f11
       {
       Disabled = !Disabled;
       if(Disabled)
       feb("@red@Canibalistic: @yel@Everything apart from attackable players are disabled from map!",3);
       else
         feb("@red@Canibalistic: @yel@All Map Enabled!",3);   
       }   
       if(l == 1017) 
       {
       SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
       String Date = formatter.format(new Date());     
       try {         
       Screen();
       } catch(Exception e) { System.out.println("Screen Shot could not be saved, download the bot again and dont touch anything!");}
       feb("@red@Canibalistic: @yel@ScreenShot taken at " + Date,3);
       }        
       if(l == 1013)
       {
       Fight = !Fight;
       if(Fight)
       {
       AutoFighter = new script();
       feb("@red@Canibalistic: @yel@Started Fighter",3);
       }else       
       feb("@red@Canibalistic: @yel@Stopped Fighter",3);
       }
       if(l == 1014) //f7
       {
       Notes = !Notes;
       }
       if (l == 1010){ // logout
       aca();
       }
       if (l == 1009) //FightMenu
       {
       if (!box)
       box = true;
       else 
       box = false;
       }   
            
       if (l == 127)
       {
       if(invCount(FoodID) > 0)
       
       use(findSlot(FoodID));
        else 
       feb("@red@Canibalistic: @yel@No more food!!!",3);
       
       }
       if (l == 1012){       
       if (SMode == 0){
       setFightMode(1);
       SMode = 1;
       feb("@red@Canibalistic: @yel@Fight Mode set to Strength",3);
       }
       else if (SMode == 1){
       setFightMode(2);
       SMode = 2;
       feb("@red@Canibalistic: @yel@Fight Mode set to Attack",3);
       }
       else if (SMode == 2){
       setFightMode(3);
       SMode = 3;
       feb("@red@Canibalistic: @yel@Fight Mode set to Defence",3);
       }
       else if (SMode == 3){
       setFightMode(0);
       SMode = 0;
       feb("@red@Canibalistic: @yel@Fight Mode set to Controlled",3);
       }    
       }
       if (l == 1011){
			if (!autoLog){
				feb("@red@Canibalistic: @yel@Autologin enabled for " + un, 3);
			autoLog = true;
			}
			else{
				feb("@red@Canibalistic: @yel@Autologin disabled for " + un, 3);
				autoLog = false;
			}
		}
       if(l == 1004 && dhj > 515){
			for (int r = 0; r < 3; r++){
				dhj -= 5;						
			}
		}
		if(l == 1005 && dhj < 4485){
			for (int r = 0; r < 3; r++){
				dhj += 5;
			}
		}
        if(eck == 0)
        {
            if(ehl == 0)
                ehm.gec(l);
            if(ehl == 1)
                dmc.gec(l);
            if(ehl == 2)
                dkf.gec(l);
        }
        if(eck == 1)
        {
            if(efc)
            {
                dhi.gec(l);
                return;
            }
            if(efm == 0 && egc == 0 && !ece)
                elg.gec(l);
        }
    }

    public final void feb(String arg0, int arg1)
    {
        if (arg1 == 6)
		{
			if(arg0.indexOf("tells you") >= 0)
			{
				lastPMer = arg0.substring(0,arg0.indexOf(": tells you"));
				while(lastPMer.indexOf("@") >= 0)
					lastPMer = lastPMer.substring(lastPMer.indexOf("@")+1);
				lastPM = arg0.substring(arg0.indexOf(": tells you ")+": tells you ".length()).trim();
			}
		}
        if(arg1 == 2 || arg1 == 4 || arg1 == 6)
        {
            for(; arg0.length() > 5 && arg0.charAt(0) == '@' && arg0.charAt(4) == '@'; arg0 = arg0.substring(5));
            int l = arg0.indexOf(":");
            if(l != -1)
            {
                String s1 = arg0.substring(0, l);
                long l1 = t.fnc(s1);
                for(int j1 = 0; j1 < super.aan; j1++)
                    if(super.aba[j1] == l1)
                        return;

            }
        }
        if(arg1 == 2)
            arg0 = "@yel@" + arg0;
        if(arg1 == 3 || arg1 == 4)
            arg0 = "@whi@" + arg0;
        if(arg1 == 6)
            arg0 = "@cya@" + arg0;
        if(ell != 0)
        {
            if(arg1 == 4 || arg1 == 3)
                ehc = 200;
            if(arg1 == 2 && ell != 1)
                ehd = 200;
            if(arg1 == 5 && ell != 2)
                ehe = 200;
            if(arg1 == 6 && ell != 3)
                ehf = 200;
            if(arg1 == 3 && ell != 0)
                ell = 0;
            if(arg1 == 6 && ell != 3 && ell != 0)
                ell = 0;
        }
        for(int i1 = 4; i1 > 0; i1--)
        {
            egb[i1] = egb[i1 - 1];
            def[i1] = def[i1 - 1];
        }

        egb[0] = arg0;
        def[0] = 300;
        if(arg1 == 2)
            if(elg.gbc[elh] == elg.gbd[elh] - 4)
                elg.ggb(elh, arg0, true);
            else
                elg.ggb(elh, arg0, false);
        if(arg1 == 5)
            if(elg.gbc[elj] == elg.gbd[elj] - 4)
                elg.ggb(elj, arg0, true);
            else
                elg.ggb(elj, arg0, false);
        if(arg1 == 6)
        {
            if(elg.gbc[elk] == elg.gbd[elk] - 4)
            {
                elg.ggb(elk, arg0, true);
                return;
            }
            elg.ggb(elk, arg0, false);
        }
    }

    private final void fec()
    {
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = enb(11, "people and monsters", 30);
        if(abyte0 == null)
        {
            ein = true;
            return;
        }
        abyte1 = t.fng("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(dej)
        {
            abyte2 = enb(3, "member graphics", 45);
            if(abyte2 == null)
            {
                ein = true;
                return;
            }
            abyte3 = t.fng("index.dat", 0, abyte2);
        }
        int l = 0;
        eic = 0;
        eid = eic;
label0:
        for(int i1 = 0; i1 < e.ake; i1++)
        {
            String s1 = e.akb[i1];
            for(int j1 = 0; j1 < i1; j1++)
            {
                if(!e.akb[j1].equalsIgnoreCase(s1))
                    continue;
                e.and[i1] = e.and[j1];
                continue label0;
            }

            byte abyte7[] = t.fng(s1 + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && dej)
            {
                abyte7 = t.fng(s1 + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                efj.cbj(eid, abyte7, abyte4, 15);
                l += 15;
                if(e.anb[i1] == 1)
                {
                    byte abyte8[] = t.fng(s1 + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && dej)
                    {
                        abyte8 = t.fng(s1 + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    efj.cbj(eid + 15, abyte8, abyte5, 3);
                    l += 3;
                }
                if(e.anc[i1] == 1)
                {
                    byte abyte9[] = t.fng(s1 + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && dej)
                    {
                        abyte9 = t.fng(s1 + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    efj.cbj(eid + 18, abyte9, abyte6, 9);
                    l += 9;
                }
                if(e.ana[i1] != 0)
                {
                    for(int k1 = eid; k1 < eid + 27; k1++)
                        efj.cbm(k1);

                }
            }
            e.and[i1] = eid;
            eid += 27;
        }
        
    }

    protected final void fed()
    {
        
        fdd();
        if(deb != null)
            deb.ggl();
    }

    protected final void ada(String s1, String s2)
    {
        if(ehl == 1)
            dmc.ggc(eji, s1 + " " + s2);
        if(ehl == 2)
            dkf.ggc(elb, s1 + " " + s2);
        eim = s2;
        emj();
        flf();
    }

    private final void fee()
    {
        byte abyte0[] = enb(6, "Textures", 50);
        if(abyte0 == null)
        {
            ein = true;
            return;
        }
        byte abyte1[] = t.fng("index.dat", 0, abyte0);
        efn.bje(e.amj, 7, 11);
        for(int l = 0; l < e.amj; l++)
        {
            String s1 = e.alg[l];
            byte abyte2[] = t.fng(s1 + ".dat", 0, abyte0);
            efj.cbj(dfb, abyte2, abyte1, 1);
            efj.cba(0, 0, 128, 128, 0xff00ff);
            efj.ccb(0, 0, dfb);
            int i1 = ((j) (efj)).bmj[dfb];
            String s2 = e.alh[l];
            if(s2 != null && s2.length() > 0)
            {
                byte abyte3[] = t.fng(s2 + ".dat", 0, abyte0);
                efj.cbj(dfb, abyte3, abyte1, 1);
                efj.ccb(0, 0, dfb);
            }
            efj.cca(dfc + l, 0, 0, i1, i1);
            int j1 = i1 * i1;
            for(int k1 = 0; k1 < j1; k1++)
                if(((j) (efj)).bmc[dfc + l][k1] == 65280)
                    ((j) (efj)).bmc[dfc + l][k1] = 0xff00ff;

            efj.cbl(dfc + l);
            efn.bjf(l, ((j) (efj)).bmd[dfc + l], ((j) (efj)).bme[dfc + l], i1 / 64 - 1);
        }

    }

    protected final Socket fef(String arg0, int arg1)
        throws IOException
    {
        if(link.fni != null)
        {
            Socket socket = link.gag(arg1);
            if(socket == null)
                throw new IOException();
            else
                return socket;
        }
        Socket socket1;
        if(fld())
            socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), arg1);
        else
            socket1 = new Socket(InetAddress.getByName(arg0), arg1);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    private final i feg(int l, int i1, int j1, int k1, int l1)
    {
        int i2 = l;
        int j2 = i1;
        int k2 = l;
        int l2 = i1;
        int i3 = e.akg[k1];
        int j3 = e.akh[k1];
        int k3 = e.akf[k1];
        i l3 = new i(4, 1);
        if(j1 == 0)
            k2 = l + 1;
        if(j1 == 1)
            l2 = i1 + 1;
        if(j1 == 2)
        {
            i2 = l + 1;
            l2 = i1 + 1;
        }
        if(j1 == 3)
        {
            k2 = l + 1;
            l2 = i1 + 1;
        }
        i2 *= ecj;
        j2 *= ecj;
        k2 *= ecj;
        l2 *= ecj;
        int i4 = l3.cln(i2, -ejk.gla(i2, j2), j2);
        int j4 = l3.cln(i2, -ejk.gla(i2, j2) - k3, j2);
        int k4 = l3.cln(k2, -ejk.gla(k2, l2) - k3, l2);
        int l4 = l3.cln(k2, -ejk.gla(k2, l2), l2);
        int ai[] = {
            i4, j4, k4, l4
        };
        l3.cmb(4, ai, i3, j3);
        l3.cme(false, 60, 24, -50, -10, -50);
        if(l >= 0 && i1 >= 0 && l < 96 && i1 < 96)
            efn.bgm(l3);
        l3.chk = l1 + 10000;
        return l3;
    }

    public mudclient()
    {
        dch = new int[250];
        dcj = false;
        dcl = 512;
        dcm = 334;
        dcn = 9;
        dda = new int[250];
        dde = new int[500];
        ddf = new i[1500];
        ddg = "";
        ddi = new f[500];
        ddn = "";
        dea = false;
        def = new int[5];
        deh = false;
        dej = true;
        dek = false;
        dfg = new int[50];
        dfh = new int[50];
        dfi = new int[50];
        dfk = new String[5];
        dfm = new int[250];
        dfn = new int[250];
        dga = new int[250];
        dgb = new int[50];
        dgc = new f();
        dgf = -1;
        dgh = new int[8];
        dgi = new int[8];
        dgj = new f[5000];
        dgk = new int[500];
        dgl = new int[500];
        dgm = false;
        dgn = false;
        dhc = new int[8];
        dhd = new int[8];
        dhe = new boolean[50];
        dhg = false;
        dhh = true;
        dhj = 550;
        dhm = 1;
        dhn = 2;
        dia = 2;
        dib = 8;
        dic = 14;
        die = 1;
        dik = new int[99];
        din = -1;
        dja = new String[250];
        djb = false;
        djc = false;
        djf = "";
        djg = "";
        djh = false;
        djj = false;
        djk = new int[8000];
        djl = new int[8000];
        djm = new int[256];
        djn = new int[256];
        dka = new int[256];
        dkc = new int[14];
        dkd = new int[14];
        dke = 128;
        dkh = new int[8];
        dki = new int[8];
        dkj = new i[1000];
        dkk = new boolean[50];
        dkl = new i[500];
        dla = false;
        dlb = false;
        dlc = false;
        dld = false;
        dle = true;
        dlf = new int[18];
        dli = false;
        dlk = 30;
        dll = false;
        dlm = false;
        dma = -1;
        dmb = -2;
        dme = new int[8192];
        dmf = new int[8192];
        dmg = -1;
        dmh = -1;
        dmi = -1;
        dmk = 0xbc614e;
        dml = -1;
        dmm = -2;
        dmn = new f[500];
        dna = new int[50];
        dnb = 48;
        dnc = new int[50];
        dng = -1;
        dnl = new boolean[500];
        eab = false;
        eag = new int[50];
        eah = new int[50];
        eai = new int[50];
        eaj = new int[50];
        eba = new f[4000];
        ebb = new int[5];
        ebc = 40;
        ebe = new int[50];
        ebf = new int[50];
        ebg = new int[50];
        ebh = new int[50];
        ebm = new int[1500];
        ebn = new int[1500];
        eca = new int[1500];
        ecb = new int[1500];
        ecc = new String[250];
        ece = false;
        ecf = new int[256];
        ecg = new int[256];
        eci = "";
        ecj = 128;
        ecm = new int[14];
        ecn = new int[14];
        edb = new int[256];
        edc = new int[256];
        ede = false;
        edf = false;
        edg = -1;
        edm = new int[8];
        edn = new int[8];
        eeb = 2;
        efb = true;
        efc = false;
        efe = new String[50];
        eff = false;
        efk = new int[18];
        ega = false;
        egb = new String[5];
        ege = new f[500];
        egg = 2;
        egi = new int[14];
        egj = new int[14];
        egk = new int[18];
        egm = new boolean[1500];
        ehn = false;
        eia = false;
        eie = new int[250];
        eif = new int[250];
        eig = -1;
        eih = "";
        eii = new f[500];
        eij = new int[500];
        eik = new int[500];
        eil = "";
        eim = "";
        ein = false;
        ejb = new int[35];
        ejc = new int[35];
        ejd = new int[35];
        ejf = new int[14];
        ejg = new int[14];
        ejl = false;
        ejm = false;
        ekg = "";
        eki = false;
        ekj = new int[5000];
        ekk = new int[5000];
        ekl = new int[5000];
        ekm = new int[5000];
        ekn = new int[50];
        elm = false;
        eln = "";
        ema = 1;
        emc = false;
    }

    private final int dbi = 250;
    public final int dbj = 5;
    public final int dbk = 50;
    public final int dbl = 18;
    public final int dbm = 500;
    public final int dbn = 1500;
    public final int dca = 5000;
    public final int dcb = 5000;
    public final int dcc = 500;
    public final int dcd = 4000;
    public final int dce = 500;
    public final int dcf = 8000;
    public int dcg;
    public int dch[];
    public Graphics dci;
    public boolean dcj;
    public int dck;
    public int dcl;
    public int dcm;
    public int dcn;
    public int dda[];
    public int ddb;
    public int ddc;
    public int ddd;
    public int dde[];
    public i ddf[];
    public String ddg;
    public int ddh[][] = {
        {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 4
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 3
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            4, 3
        }
    };
    public f ddi[];
    public int ddj;
    public int ddk;
    public int ddl;
    public int ddm;
    public String ddn;
    public boolean dea;
    public d deb;
    public int dec;
    public int ded[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    public int dee;
    public int def[];
    public final int deg[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    public boolean deh;
    public int dei[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    public boolean dej;
    public boolean dek;
    public int del;
    public int dem;
    public int den;
    public int dfa;
    public int dfb;
    public int dfc;
    public int dfd;
    public int dfe;
    public int dff;
    public int dfg[];
    public int dfh[];
    public int dfi[];
    public int dfj;
    public String dfk[];
    public int dfl;
    public int dfm[];
    public int dfn[];
    public int dga[];
    public int dgb[];
    public f dgc;
    int dgd;
    int dge;
    int dgf;
    public int dgg;
    public int dgh[];
    public int dgi[];
    public f dgj[];
    public int dgk[];
    public int dgl[];
    public boolean dgm;
    public boolean dgn;
    public int dha;
    public int dhb;
    public int dhc[];
    public int dhd[];
    public boolean dhe[];
    public int dhf;
    public boolean dhg;
    public boolean dhh;
    public h dhi;
    public int dhj;
    public int dhk;
    public int dhl;
    public int dhm;
    public int dhn;
    public int dia;
    public int dib;
    public int dic;
    public int did;
    public int die;
    public int dif;
    public h dig;
    int dih;
    int dii;
    public int dij;
    public int dik[];
    public int dil;
    public int dim;
    public int din;
    public String dja[];
    public boolean djb;
    public boolean djc;
    public int djd;
    public int dje;
    public String djf;
    public String djg;
    public boolean djh;
    public int dji;
    public boolean djj;
    public int djk[];
    public int djl[];
    public int djm[];
    public int djn[];
    public int dka[];
    public int dkb;
    public int dkc[];
    public int dkd[];
    public int dke;
    public h dkf;
    public int dkg;
    public int dkh[];
    public int dki[];
    public i dkj[];
    public boolean dkk[];
    public i dkl[];
    public int dkm;
    public int dkn;
    public boolean dla;
    public boolean dlb;
    public boolean dlc;
    public boolean dld;
    public boolean dle;
    public int dlf[];
    public int dlg;
    public int dlh;
    public boolean dli;
    public final int dlj[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    public int dlk;
    public boolean dll;
    public boolean dlm;
    public int dln;
    public int dma;
    public int dmb;
    public h dmc;
    public int dmd;
    int dme[];
    int dmf[];
    public int dmg;
    public int dmh;
    public int dmi;
    public int dmj;
    public int dmk;
    public int dml;
    public int dmm;
    public f dmn[];
    public int dna[];
    public int dnb;
    public int dnc[];
    public int dnd;
    public int dne;
    public int dnf;
    public int dng;
    public int dnh;
    public int dni;
    public int dnj;
    public int dnk;
    public boolean dnl[];
    public byte dnm[];
    public int dnn;
    public int eaa;
    public boolean eab;
    public int eac;
    public int ead;
    public int eae;
    public int eaf;
    public int eag[];
    public int eah[];
    public int eai[];
    public int eaj[];
    public int eak;
    int eal;
    int eam;
    public int ean;
    public f eba[];
    public int ebb[];
    public int ebc;
    public int ebd;
    public int ebe[];
    public int ebf[];
    public int ebg[];
    public int ebh[];
    public final String ebi[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public h ebj;
    int ebk;
    int ebl;
    public int ebm[];
    public int ebn[];
    public int eca[];
    public int ecb[];
    public String ecc[];
    public final String ecd[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    public boolean ece;
    public int ecf[];
    public int ecg[];
    public final String ech[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public String eci;
    public int ecj;
    public int eck;
    public int ecl;
    public int ecm[];
    public int ecn[];
    public int eda;
    public int edb[];
    public int edc[];
    public String edd;
    public boolean ede;
    public boolean edf;
    public int edg;
    public int edh;
    public int edi;
    public int edj;
    public int edk;
    public int edl;
    public int edm[];
    public int edn[];
    public int eea;
    public int eeb;
    public int eec;
    public int eed;
    public int eee;
    public int eef;
    public int eeg;
    public int eeh;
    public int eei;
    public int eej;
    public int eek;
    public int eel;
    public int eem;
    public int een;
    public int efa;
    public boolean efb;
    public boolean efc;
    public int efd;
    String efe[];
    public boolean eff;
    public int efg;
    public int efh;
    public int efi;
    public k efj;
    public int efk[];
    public int efl[] = {
        0, 1, 2, 1
    };
    public int efm;
    public n efn;
    public boolean ega;
    public String egb[];
    public int egc;
    public int egd;
    public f ege[];
    public int egf;
    public int egg;
    public int egh;
    public int egi[];
    public int egj[];
    public int egk[];
    public int egl;
    public boolean egm[];
    public int egn;
    public int eha;
    public int ehb;
    public int ehc;
    public int ehd;
    public int ehe;
    public int ehf;
    public int ehg;
    public int ehh;
    public int ehi;
    public int ehj;
    public int ehk;
    public int ehl;
    public h ehm;
    public boolean ehn;
    public boolean eia;
    public int eib;
    public int eic;
    public int eid;
    public int eie[];
    public int eif[];
    public int eig;
    String eih;
    public f eii[];
    public int eij[];
    public int eik[];
    public String eil;
    public String eim;
    public boolean ein;
    public int eja;
    public int ejb[];
    public int ejc[];
    public int ejd[];
    public int eje;
    public int ejf[];
    public int ejg[];
    public int ejh;
    public int eji;
    public int ejj;
    public x ejk;
    public boolean ejl;
    public boolean ejm;
    public h ejn;
    int eka;
    int ekb;
    long ekc;
    public final int ekd[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    public String eke;
    public long ekf;
    public String ekg;
    public int ekh;
    public boolean eki;
    public int ekj[];
    public int ekk[];
    public int ekl[];
    public int ekm[];
    public int ekn[];
    public int ela;
    public int elb;
    public int elc;
    public int eld;
    public int ele;
    public int elf;
    public h elg;
    int elh;
    int eli;
    int elj;
    int elk;
    int ell;
    public boolean elm;
    public String eln;
    public int ema;
    public int emb;
    public boolean emc;
    public final String emd[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    public long eme;
    public final String emf[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };    
     public void sendWord(String word) {
            aag.hdg(142);
            aag.hdk(word);
            aag.hde();
            fkl = "";
            fkm = "";
            eke = "Please wait...";
        }
    
    public int getSleepingFatigue() 
    { 
    return (ehb * 100) / 750; 
    }
    
    private File HCfile = new File("HC.BMP");
    private File SLfile = new File("slword.txt");
    private long mod;
    private String oword = "";
    private long LChecked = 0;
    public boolean sentword;
    
   public String ReadLine(File s)
    {
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(s));
            String t = input.readLine().trim();
            input.close();
            return t;
        }
        catch(Exception e)
        {
            System.out.println("Error reading slword.txt");
            return oword;
        }
    }    
    
    public byte[] MakePic(byte abyte0[])
    {
        int i1 = 1;
        byte byte0 = 0;
        int j1;
        byte picBytes[] = new byte[10200];
        for(j1 = 0; j1 < 255;)
        {
            int k1 = abyte0[i1++] & 0xff;
            for(int i2 = 0; i2 < k1; i2++)
                picBytes[j1++] = byte0;
            byte0 = (byte)(255 - byte0);
        }
        for(int l1 = 1; l1 < 40; l1++)
        {
            for(int j2 = 0; j2 < 255;)
            {
                int k2 = abyte0[i1++] & 0xff;
                for(int l2 = 0; l2 < k2; l2++)
                {
                    picBytes[j1] = picBytes[j1 - 255];
                    j1++;
                    j2++;
                }
                if(j2 < 255)
                {
                    picBytes[j1] = (byte)(255 - picBytes[j1 - 255]);
                    j1++;
                    j2++;
                }
            }
        }
        return picBytes;
    }
    
    public void saveOutput(File s, byte abyte0[])
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(s);
            fileoutputstream.write(66);
            fileoutputstream.write(77);
            int i1 = 1342;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 62;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 40;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 256;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 40;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 1;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            i1 = 1;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(255);
            fileoutputstream.write(255);
            fileoutputstream.write(255);
            fileoutputstream.write(0);
            int j1 = 9945;
            for(int k1 = 0; k1 < 40; k1++)
            {
                for(int l1 = 0; l1 < 32; l1++)
                {
                    byte byte0 = 0;
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        byte0 = (byte)(2 * byte0);
                        if(l1 != 31 || i2 != 7)
                        {
                            if(abyte0[j1] != 0)
                                byte0++;
                            j1++;
                        }
                    }
                    fileoutputstream.write(byte0);
                }
                j1 -= 510;
            }
            fileoutputstream.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}
