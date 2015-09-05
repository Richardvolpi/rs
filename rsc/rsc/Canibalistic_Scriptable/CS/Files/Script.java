import java.util.Random;

public abstract class Script
{
    protected mudclient rs;
    private Random r = new Random();
    
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
    public boolean InArray(int iarray[], int i)
    {
    for(int a = 0;a < iarray.length;a++)
        if(iarray[a] == i)
           return true;
    return false;
    }
    public void W(){ while(rs.loading) Wait(100);  while(!LoggedIn())  Wait(100); }
    public boolean Running()
    {
    return rs.running;
    }    
    public void Display(String Message, int x)
    {
    
    rs.fdj(Message,x);
    }
    public void Wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch(Exception e) { }
    }
    public void ChangeWorld(int server)
    {
    	rs.changeWorld(server);
    }
    public void Logout()
    {
    
    	rs.aca();
    }    
    public void AutoLogin(boolean to)
    {
    	rs.autoLog = to;
    }
    public int GetWorld()
    {
    	return rs.world;
    }
    public String GetAuthName()
    {
    	return rs.Username;
    }
    public long GetMillies()
    {
    
    	return System.currentTimeMillis();
    }
    public void PrintLine(String msg)
    {
    	System.out.println(msg);
    }
    public void Print(String msg)
    {
    	System.out.print(msg);
    }
    public int StringToInteger(String str)
    {
    	return Integer.parseInt(str);
    }
    public int GetDistance(int x, int y)
    {
    	return Math.abs(x - GetX()) + Math.abs(y - GetY());
    }  
    public int Rand(int from, int to) 
    {
        return from + r.nextInt(to);
    }
    public void Stop()
    {
    	rs.runCommand("stop");
    }
    /**-------------------------This Player Methods-------------------------**/
    
    public int GetX() 
    {       
         W(); 
        return (rs.djc.gmh - 64) / rs.ehd + rs.dni;
    }
    public int GetY() 
    {      
         W(); 
        return (rs.djc.gmi - 64) / rs.ehd + rs.dnj;
    }
    public boolean Walking() 
    {      
         
        return ((rs.djc.gna + 1) % 10 != rs.djc.gmn);
    }
    public boolean Sleeping() 
    {      
         
        return rs.den;
    }
    public int Fatigue() 
    {     W();      
         
      return (rs.dhj * 100) / 750;
    }
    public int WhileSleepingFatigue() 
    {      
         W(); 
        return (rs.dhk * 100) / 750;
    }
    public int Combat() 
    {      
         
        return rs.djc.gnm;
    }
    public int QuestPoints() 
    {      
         
        return rs.ema;
    }
    public int GetStat(int idx) 
    {             
         
            return rs.dmf[idx];        
    }
    public int GetCurrentStat(int idx) 
    {              
         
            return rs.dfk[idx];        
    }
    public String GetStatName(int idx) 
    {              
         
            return rs.dfn[idx];        
    }
    public int GetStatXp(int idx) 
    {              
         
            return rs.edn[idx] / 4;
    }
    public int GetFightMode() 
    {      
         
        return rs.dkh;
    }
    public void SetFightMode(int idx) 
    {       
             W(); 
            rs.dkh = idx;
            rs.aag.hcn(74);
            rs.aag.hdb(rs.dkh);
            rs.aag.hdl();        
    }   
    public boolean MemberServer() 
    {      
         W(); 
        return rs.egi;
    }
    public String GetUsername() 
    {      
         W(); 
        return rs.ekc;
    }
    public boolean LoggedIn() 
    {      
         
        return rs.ehe == 1;
    }
    public boolean InCombat()
    {      
         
    return rs.djc.gml == 8 || rs.djc.gml == 9;
    }
    
    /**-------------------------Walking and Location Methods-------------------------**/
    
    private int maxDist = 16 * 16;     
    
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
    public int getDistance(int x1, int y1, int x2, int y2) {
          
         
        int dx = x1 - x2;
        int dy = y1 - y2;
        
        return (dx * dx) + (dy + dy);
    }
    public boolean Walk(int x, int y) 
    {        
    try {  
            W();   
         
        int playerX = GetX();
        int playerY = GetY();
        
        if(getDistance(playerX, playerY, x, y) > maxDist)
            return false;
        
        int i = (rs.dnh.gjl(playerX - rs.dni, playerY - rs.dnj, x - rs.dni, y - rs.dnj, x - rs.dni, y - rs.dnj, rs.dnn, rs.eaa, false));
        if(i < 0)
            return false;
        else {
           
            rs.dga[rs.ejf] = 920;
            rs.dfl[rs.ejf] = x - rs.dni;
            rs.dfm[rs.ejf] = y - rs.dnj;
            rs.emg(rs.ejf++);
            return true;
        }
        } catch(Exception e) {  return false;}
    }
    public void WalkTillThere(int x, int y)
    {
    while(GetX() != x && GetY() != y)
    	{
    	Walk(x,y);
    	Wait(500);
    	}
    }
    public boolean CanReach(int x, int y) 
    {
          
         W(); 
        int i = (rs.dnh.gjl(rs.djd, rs.djd, x - rs.dni, y - rs.dnj, x - rs.dni, y - rs.dnj, rs.dnn, rs.eaa, false));
        return (i > -1 ? true : false);
    }
    public int WildLevel()
    {      
         
        return 1 + 2203 - (rs.dje + rs.eaj + rs.dnj) / 6;
    }
    public boolean Wild()
    {           
        return !(GetY() + rs.eaj > 2203);
    }
    
    /**-------------------------Object Methods-------------------------**/
    
    public int CountObjects() 
    {      
         
        return rs.efd;
    }
    public int GetObjectType(int idx) 
    {             
          
            return rs.ela[idx];        
    }
    public String GetObjectName(int type) 
    {      
         
        return e.ajm[type];
    }
    public String GetObjectInfo(int type) 
    {      
         
        return e.ajn[type];
    }
    public String GetObjectCmd1(int type) 
    {      
         
        return e.aka[type];
    }
    public String GetObjectCmd2(int type) 
    {      
         
        return e.akb[type];
    }
    public int GetObjectAt(int x, int y) {          
         W(); 
        x -= rs.dni;
        y -= rs.dnj;
        
        for(int i = 0; i < CountObjects(); i++) {
            if(rs.ekm[i] == x && rs.ekn[i] == y)
                return GetObjectType(i);
        }
        
        return -1;
    }
    public void objectCmd1(int idx) 
    {       
    try {
              W();       
            rs.dga[rs.ejf] = 420;
            rs.dfl[rs.ejf] = rs.ekm[idx];
            rs.dfm[rs.ejf] = rs.ekn[idx];
            rs.djk[rs.ejf] = rs.elb[idx];
            rs.djl[rs.ejf] = rs.ela[idx];
            rs.emg(rs.ejf++);   
         } catch(Exception e) {  }            
    }
    public void objectCmd2(int idx) 
    {       
    try{
               W();       
            rs.dga[rs.ejf] = 2400;
            rs.dfl[rs.ejf] = rs.ekm[idx];
            rs.dfm[rs.ejf] = rs.ekn[idx];
            rs.djk[rs.ejf] = rs.elb[idx];
            rs.djl[rs.ejf] = rs.ela[idx];
            rs.emg(rs.ejf++);
            } catch(Exception e) {  }
     }
     public void AtObjectById(int id, int x, int y)
     {
        W();
        x -= rs.dni;
        y -= rs.dnj;
        
        for(int i = 0; i < CountObjects(); i++) {
            if(id == i && rs.ekm[i] == x && rs.ekn[i] == y) {
                         objectCmd1(i);                    
                
            }
        }
                
      }
     public void AtObjectById2(int id, int x, int y) 
      {      
        W(); 
        x -= rs.dni;
        y -= rs.dnj;
        
        for(int i = 0; i < CountObjects(); i++) {
            if(id == i && rs.ekm[i] == x && rs.ekn[i] == y) {
                         objectCmd2(i);                    
                
            }
        }
                
       }
     public void AtObject(int x, int y) 
     {      
        W(); 
        x -= rs.dni;
        y -= rs.dnj;
        
        for(int i = 0; i < CountObjects(); i++) {
            if(rs.ekm[i] == x && rs.ekn[i] == y) {
                         objectCmd1(i);                    
                
            }
        }
                
      }
      public void AtObject2(int x, int y) 
      {      
        W(); 
        x -= rs.dni;
        y -= rs.dnj;
        
        for(int i = 0; i < CountObjects(); i++) {
            if(rs.ekm[i] == x && rs.ekn[i] == y) {
                         objectCmd2(i);                    
                
            }
        }
                
       }
      public int[] GetNearestObject(int id)
       {    
       W();      
        int min[] = {-1,-1,-1};
        int mint = Integer.MAX_VALUE;
        for(int j = 0; j < CountObjects(); j++)
        if(GetObjectType(j) == id)
        {
            int ObjectX = rs.ekm[j] + rs.dni; 
            int ObjectY = rs.ekn[j] + rs.dnj; 
            int temp = Math.abs(ObjectX - GetX()) + Math.abs(ObjectY - GetY());
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
      W();     
           int min[] = {-1,-1,-1};
    int mint = Integer.MAX_VALUE;
    for(int j = 0; j < CountObjects(); j++)
        if(InArray(id,GetObjectType(j)))
        {
            int ObjectX = rs.ekm[j] + rs.dni; 
            int ObjectY = rs.ekn[j] + rs.dnj; 
            int temp = Math.abs(ObjectX - GetX()) + Math.abs(ObjectY - GetY());
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
      
     /**-------------------------Wall Object Methods (including doors)-------------------------**/
     
     public int CountWallObjects() 
     {      
         
        return rs.ehc;
     }
     public int GetWallObjectType(int idx) 
     {            
                  
            return rs.eda[idx];        
     }
     public String GetWallObjectName(int type) 
     {      
         
        return e.ahi[type];
     }
     public String GetWallObjectInfo(int type) 
     {      
         
        return e.ahe[type];
     }
     public String GetWallObjectCmd1(int type) 
     {      
         
       return e.ahk[type];
     }
     public String GetWallObjectCmd2(int type) 
     {      
         
        return e.ahl[type];
     }
     public int GetWallObjectAt(int x, int y) 
     {      
        W(); 
        x -= rs.dni;
        y -= rs.dnj;
        
        for(int i = 0; i < CountWallObjects(); i++) {
            if(rs.dhg[i] == x && rs.dhh[i] == y)
                return GetWallObjectType(i);
        }
        
        return -1;
     }
     public void wallObjectCmd1(int idx) 
     {       
             try {
             W(); 
            rs.dga[rs.ejf] = 320;
            rs.dfl[rs.ejf] = rs.dhg[idx];
            rs.dfm[rs.ejf] = rs.dhh[idx];
            rs.djk[rs.ejf] = rs.ecn[idx];
            rs.emg(rs.ejf++);
            } catch(Exception e) {  }        
     }
     public void wallObjectCmd2(int idx)
     {     
     try { 
             W(); 
            rs.dga[rs.ejf] = 2300;
            rs.dfl[rs.ejf] = rs.dhg[idx];
            rs.dfm[rs.ejf] = rs.dhh[idx];
            rs.djk[rs.ejf] = rs.ecn[idx];
            rs.emg(rs.ejf++);
            } catch(Exception e) {  }        
     }
     public void AtWallObject(int x, int y) 
     {      
       W(); 
        x -= rs.dni;
        y -= rs.dnj;
        
        for(int i = 0; i < CountWallObjects(); i++) {
            if(rs.dhg[i] == x && rs.dhh[i] == y) {                
                    wallObjectCmd1(i);                
            }
        }
      }
      public void AtWallObject2(int x, int y) 
     {      
        W(); 
        x -= rs.dni;
        y -= rs.dnj;
        
        for(int i = 0; i < CountWallObjects(); i++) {
            if(rs.dhg[i] == x && rs.dhh[i] == y) {                
                    wallObjectCmd2(i);                
            }
        }
      }
      public int[] GetNearestWallObject(int id)
       {
            W();        
        int min[] = {-1,-1,-1};
        int mint = Integer.MAX_VALUE;
        for(int j = 0; j < CountWallObjects(); j++)
        if(GetWallObjectType(j) == id)
        {
            int WallObjectX = rs.dhg[j] + rs.dni; 
            int WallObjectY = rs.dhh[j] + rs.dnj; 
            int temp = Math.abs(WallObjectX - GetX()) + Math.abs(WallObjectY - GetY());
            if(temp < mint)
            {
                min[0] = j;
                min[1] = WallObjectX;
                min[2] = WallObjectY;
                mint = temp;
            }
        }
       return min;
     }
        
        /**-------------------------Inventory methods-------------------------**/
        
        public int CountInv() 
        {      
         
        return rs.ede;
        }
        public int CountInv(int idx) 
        {      
         
        return rs.fac(idx);
        }
        public int GetItemAtSlot(int idx) 
        {         
              
            return rs.edf[idx];        
        }
        public int FindSlot(int type) 
        {              
        for(int i = 0; i < CountInv(); i++) {
            if(GetItemAtSlot(i) == type)
                return i;
        }
        return -1;
        }
        public String GetItemName(int type) 
        {      
         
        return e.aib[type];
        }      
        public String GetItemInfo(int type) 
        {      
         
        return e.aic[type];
        }
        public String GetItemCommand(int type) 
        {      
         
        return e.aid[type];
        }
        public boolean CanWear(int type) 
        {      
         
        return e.aii[type] != 0;
        }   
        public boolean CanStake(int type) 
        {      
         
        return (e.aig[type] != 1);
        }   
        public boolean IsFood(int type) 
        {         
        return GetItemCommand(type).equalsIgnoreCase("eat");
        }
        public boolean IsItemWorn(int idx) 
        {            
        if(CanWear(GetItemAtSlot(idx)) == false) {
            System.out.println("IsItemWorn(): item at slot is not wearable: " + idx);
            return false;
        } else {
            return rs.edh[idx] == 1;
        }
        }
        public void EquipItem(int idx) 
        { 
        try {    
        W();       
        if(CanWear(GetItemAtSlot(idx)) == false) {
            System.out.println("EquipItem(): item is not wearable: " + idx);
        } else if(IsItemWorn(idx) == true) {
            System.out.println("EquipItem(): item is already being worn: " + idx);
        } else {
           
            rs.dga[rs.ejf] = 630;
            rs.dfm[rs.ejf] = idx;
            rs.emg(rs.ejf++);
        }
        } catch(Exception e) {  }
        }
        public void UnequipItem(int idx) 
        {
        try {           
        if(CanWear(GetItemAtSlot(idx)) == false) {
            System.out.println("UnequipItem(): item at slot is not wearable: " + idx);
        } else {
            W(); 
            rs.dga[rs.ejf] = 620;
            rs.djk[rs.ejf] = idx;
            rs.emg(rs.ejf++);
        }
        } catch(Exception e) {  }
        }
        public void UseItem(int idx) 
        {   
        try {
             W();     
            rs.dga[rs.ejf] = 640;
            rs.djk[rs.ejf] = idx;
            rs.emg(rs.ejf++);  
            } catch(Exception e) {  }      
        }
        public void DropItem(int idx) 
        {   
        try {
             W();    
            rs.dga[rs.ejf] = 660;
            rs.djk[rs.ejf] = idx;
            rs.emg(rs.ejf++);    
            } catch(Exception e) {  }    
        }        
        public void UseItemWithItem(int item1position, int item2position) 
        {   
        try {
             W();     
            rs.dga[rs.ejf] = 610;
            rs.djk[rs.ejf] = item1position;
            rs.djl[rs.ejf] = item2position;
            rs.emg(rs.ejf++);
            } catch(Exception e) {  }        
        }         
        public void UseItemWithGroundItem(int itemposition, int groundItemIDX) 
        {   
           try {
              W();    
            rs.dga[rs.ejf] = 210;
            rs.dfl[rs.ejf] = rs.dml[groundItemIDX];
            rs.dfm[rs.ejf] = rs.dmm[groundItemIDX];
            rs.djk[rs.ejf] = rs.dmn[groundItemIDX];
            rs.djl[rs.ejf] = itemposition;
            rs.emg(rs.ejf++);    
            } catch(Exception e) {  }    
        }
        public void UseItemWithObject(int itemposition, int objectIDX) 
        {   
        try {
             W();     
            rs.dga[rs.ejf] = 410;
            rs.dfl[rs.ejf] = rs.ekm[objectIDX];
            rs.dfm[rs.ejf] = rs.ekn[objectIDX];
            rs.djk[rs.ejf] = rs.elb[objectIDX];
            rs.djl[rs.ejf] = rs.ela[objectIDX];
            rs.djm[rs.ejf] = itemposition;
            rs.emg(rs.ejf++);   
            } catch(Exception e) {  }     
        }
        public void UseItemWithWallObject(int itemposition, int wallObjectIDX) 
        {   
        try {
             W();     
            rs.dga[rs.ejf] = 310;
            rs.dfl[rs.ejf] = rs.dhg[wallObjectIDX];
            rs.dfm[rs.ejf] = rs.dhh[wallObjectIDX];
            rs.djk[rs.ejf] = rs.ecn[wallObjectIDX];
            rs.djl[rs.ejf] = itemposition;
            rs.emg(rs.ejf++);  
            } catch(Exception e) {  }     
        }
        
        /**-------------------------Bank methods-------------------------**/
        
       public boolean IsBankOpen()
       {      
         
        return rs.dmb;
       }
       public void CloseBank() 
       {    
                
            rs.aag.hcn(78);
            rs.aag.hdl();
            rs.dmb = false;        
       }
       public int CountBank() 
       {      
         
        return rs.elm;
       }
       public int GetBankItemType(int idx) 
       {          
             
        return rs.eam[idx];
       }
       public int CountBank(int idx) 
       {          
       if(GetBankItemType(idx) < 0) {
            return 0;
        }
        return rs.ean[idx];
       }
       public int FindBankSlot(int type) {
        for(int i = 0; i < CountBank(); i++) {
            if(GetBankItemType(i) == type)
                return i;
        }
        return -1;
       }
       public void DepositItem(int idx, int amount) 
       {    
            W();         
            rs.aag.hcn(190);
            rs.aag.hdj(idx);
            rs.aag.hdj(amount);
            rs.aag.hdl();            
       }
       public void WithdrawItem(int type, int amount) 
       {       
             
          W(); 
        int idx = FindBankSlot(type);                    
            rs.aag.hcn(131);
            rs.aag.hdj(type);
            rs.aag.hdj(amount);
            rs.aag.hdl();             
       }
       
       /**-------------------------Shop Methods-------------------------**/
       
       public boolean InShop() 
       {      
         
        return rs.dck;
       }
       public void CloseShop() 
       {   
           W();   
        rs.aag.hcn(43);
        rs.aag.hdl();
        rs.dmk = false;
       }
       public int getShopItemType(int idx) 
       {          
             
        return rs.djm[idx];
       }
       public int FindShopSlot(int type) 
       {           
        for(int i = 0; i < 39; i++) {
            if(getShopItemType(i) == type)
                return i;
        }
        return -1;
       }
       public int CountShop(int type) 
       {         
                     
        return rs.efb[type];
       }
       public int GetItemPrice(int type) 
       {      
           
        int i = FindShopSlot(type);       
        int mod = rs.dmd + rs.efc[i];
        if(mod < 10)
            mod = 10;        
        return (mod * e.aif[type]) / 100;
       }
       public int GetItemBuyPrice(int type)
        {        
                 
        int i = FindShopSlot(type);    
        int mod = rs.dmd + rs.efc[i];
        if(mod < 10)
            mod = 10;        
        return (mod * e.aif[type]) / 100;
        }
       public void SellItem(int type) 
       { W();  
                 
        rs.aag.hcn(177);
        rs.aag.hdj(type);
        rs.aag.hdh(GetItemPrice(type));
        rs.aag.hdl();        
       }
       public int BuyItem(int type) 
       {    
             
          W();    
        int idx = FindShopSlot(type);
        int price = GetItemBuyPrice(type);
               
        rs.aag.hcn(67);
        rs.aag.hdj(type);
        rs.aag.hdh(price);
        rs.aag.hdl();
        return 1;
       }
       
       /**-------------------------Ground Item Methods-------------------------**/
       
       public int CountGroundItems() 
       {      
         
        return rs.dhd;
       }
       public int GetGroundItemType(int idx) 
       {           
            
            return rs.dmn[idx];        
       }
       public int GetGroundItemAt(int x, int y) 
       {      
      
        x -= rs.dni;
        y -= rs.dnj;        
        for(int i = 0; i < CountGroundItems(); i++) {
            if(rs.dml[i] == x && rs.dmm[i] == y)
                return GetGroundItemType(i);
        }
        
        return -1;
       }
       public void PickUpItem(int idx) 
       {    
       try{
            W();       
            rs.dga[rs.ejf] = 220;
            rs.dfl[rs.ejf] = rs.dml[idx];
            rs.dfm[rs.ejf] = rs.dmm[idx];
            rs.djk[rs.ejf] = rs.dmn[idx];
            rs.emg(rs.ejf++);   
            } catch(Exception e) {  }     
       }
       public void PickUpItemAt(int x, int y)
       {            
          W(); 
        x -= rs.dni;
        y -= rs.dnj;
        
        for(int i = 0; i < CountGroundItems(); i++) {
            if(rs.dml[i] == x && rs.dmm[i] == y) {                
                    PickUpItem(i);                
            }
        }
      }
       public int[] GetNearestItem(int id)
      {      
       W(); 
       int min[] = {-1,-1,-1};
       int mint = Integer.MAX_VALUE;
       for(int j = 0; j < CountGroundItems(); j++)
        if(GetGroundItemType(j) == id)
        {
            int ItemX = rs.dml[j] + rs.dni; 
            int ItemY = rs.dmm[j] + rs.dnj; 
            int temp = Math.abs(ItemX - GetX()) + Math.abs(ItemY - GetY());
            if(temp < mint)
            {
                min[0] = j;
                min[1] = ItemX;
                min[2] = ItemY;
                mint = temp;
            }
         }
          return min;
       }
       public int[] GetNearestItem(int[] id)
         {      
       W(); 
          int min[] = {-1,-1,-1};
          int mint = Integer.MAX_VALUE;
         for(int j = 0; j < CountGroundItems(); j++)
           if(InArray(id,GetGroundItemType(j)))
           {
              int ItemX = rs.dml[j] + rs.dni; 
              int ItemY = rs.dmm[j] + rs.dnj; 
              int temp = Math.abs(ItemX - GetX()) + Math.abs(ItemY - GetY());
              if(temp < mint)
               {
                min[0] = j;
                min[1] = ItemX;
                min[2] = ItemY;
                mint = temp;
              }
           }
          return min;
        }
       /**-------------------------NPC Methods-------------------------**/
       
        public int CountNpc() 
        {      
         
        return rs.ebb;
        }
        public int GetNpcType(int idx) 
        {           
            
            return rs.dgf[idx].gmj;        
        }
        public String GetNpcName(int type) 
        {      
         
        return e.ahd[type];
        }
        public String GetNpcInfo(int type) 
        {      
         
        return e.ahe[type];
        }        
        public boolean NpcWalking(int idx) 
        {          
             
            return rs.dgf[idx].gna + 1 % 10 != rs.dgf[idx].gmn;        
        }
        public boolean NpcInCombat(int idx) 
        {            
           
            return rs.dgf[idx].gml == 8 || rs.dgf[idx].gml == 9;        
        }
        public boolean CanAttackNpc(int idx) 
        {             
          
            return e.alf[GetNpcType(idx)] > 0;        
        }        
        public int GetNpcCurrentHp(int idx) 
        {             
          
            return rs.dgf[idx].gnk;
        }
        public int GetNpcMaxHp(int idx) 
        {            
           
            return rs.dgf[idx].gnl;        
        }
        public void TalkToNpc(int idx) 
        {   
        try {
            W();        
            rs.dga[rs.ejf] = 720;
            rs.dfl[rs.ejf] = rs.dgf[idx].gmh;
            rs.dfm[rs.ejf] = rs.dgf[idx].gmi;
            rs.djk[rs.ejf] = rs.dgf[idx].gmf;
            rs.emg(rs.ejf++);   
            } catch(Exception e) {  }     
        }
        public void TheiveNpc(int idx)
        {
        try {
            W();    
            rs.dga[rs.ejf] = 725;
            rs.dfl[rs.ejf] = rs.dgf[idx].gmh;
            rs.dfm[rs.ejf] = rs.dgf[idx].gmi;
            rs.djk[rs.ejf] = rs.dgf[idx].gmf;
            rs.emg(rs.ejf++);    
            } catch(Exception e) {  }    
        }
        public void AttackNpc(int idx) 
        {    
            try {
            W();     
            rs.dga[rs.ejf] = 715;
            rs.dfl[rs.ejf] = rs.dgf[idx].gmh;
            rs.dfm[rs.ejf] = rs.dgf[idx].gmi;
            rs.djk[rs.ejf] = rs.dgf[idx].gmf;
            rs.emg(rs.ejf++);    
            } catch(Exception e) {  }    
                  
        }
        public int[] GetNearestNpc(int id)
         {      
         W(); 
        int min[] = {-1,-1,-1};
        int mint = Integer.MAX_VALUE;
        for(int j = 0; j < CountNpc(); j++)
        if(GetNpcType(j) == id && rs.dgf[j].gml != 8 && rs.dgf[j].gml != 9)
        {
            int NpcX = ((rs.dgf[j].gmh - 64) / rs.ehd) + rs.dni;
            int NpcY = ((rs.dgf[j].gmi - 64) / rs.ehd) + rs.dnj;
            int temp = Math.abs(NpcX - GetX()) + Math.abs(NpcY - GetY());
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
    
        public int[] GetNearestNpc(int[] id)
          {      
       W(); 
          int min[] = {-1,-1,-1};
          int mint = Integer.MAX_VALUE;
          for(int j = 0; j < CountNpc(); j++)
          if(InArray(id,GetNpcType(j)) && rs.dgf[j].gml != 8 && rs.dgf[j].gml != 9)
            {
            int NpcX = ((rs.dgf[j].gmh - 64) / rs.ehd) + rs.dni;
            int NpcY = ((rs.dgf[j].gmi - 64) / rs.ehd) + rs.dnj;
            int temp = Math.abs(NpcX - GetX()) + Math.abs(NpcY - GetY());
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
        
        /**-------------------------Prayer Methods-------------------------**/
        
        public boolean IsPrayerOn(int type) 
        {             
          
        return rs.eeh[type];
        }
        public void togglePrayer(int type) 
        {      
            
        if(!IsPrayerOn(type)) {
            W(); 
            rs.aag.hcn(202);
            rs.aag.hdb(type);
            rs.aag.hdl();
            rs.eeh[type] = true;            
        } else {
            W(); 
            rs.aag.hcn(162);
            rs.aag.hdb(type);
            rs.aag.hdl();
            rs.eeh[type] = false;           
        }
        }
        
        /**-------------------------Magic Methods-------------------------**/
        
           
        
        public void CastOnSelf(int type) 
        {    try {
                 W();   
            rs.dga[rs.ejf] = 1000;
            rs.djk[rs.ejf] = type;
            rs.emg(rs.ejf++);     
            } catch(Exception e) {  }   
        }
        public void CastOnItem(int type, int itemPos) 
        {   
        try{
                W(); 
            rs.dga[rs.ejf] = 600;
            rs.djk[rs.ejf] = itemPos;
            rs.djl[rs.ejf] = type;
            rs.emg(rs.ejf++);
            } catch(Exception e) {  }
        }
        public void CastOnGroundItem(int type, int groundItemPosition) 
        {   
        try {
            W();                
            rs.dga[rs.ejf] = 200;
            rs.dfl[rs.ejf] = rs.dml[groundItemPosition];
            rs.dfm[rs.ejf] = rs.dmm[groundItemPosition];
            rs.djk[rs.ejf] = rs.dmn[groundItemPosition];
            rs.djl[rs.ejf] = type;
            rs.emg(rs.ejf++);
            } catch(Exception e) {  }
        }
        public void CastOnObject(int type, int objectPosition) 
        {   
        try {
                W();  
            rs.dga[rs.ejf] = 400;
            rs.dfl[rs.ejf] = rs.ekm[objectPosition];
            rs.dfm[rs.ejf] = rs.ekn[objectPosition];
            rs.djk[rs.ejf] = rs.elb[objectPosition];
            rs.djl[rs.ejf] = rs.ela[objectPosition];
            rs.dga[rs.ejf] = type;
            rs.emg(rs.ejf++);
            } catch(Exception e) {  }
        }
        public void CastOnWallObject(int type, int wallObjectPosition) 
        {   
        try {
                 W();     
            rs.dga[rs.ejf] = 300;
            rs.dfl[rs.ejf] = rs.dhg[wallObjectPosition];
            rs.dfm[rs.ejf] = rs.dhh[wallObjectPosition];
            rs.djk[rs.ejf] = rs.ecn[wallObjectPosition];
            rs.djl[rs.ejf] = type;
            rs.emg(rs.ejf++);  
            } catch(Exception e) {  }      
        }
        public void CastOnNpc(int type, int npcIDX) 
        {   
        try {
                  W();  
            rs.dga[rs.ejf] = 700;
            rs.dfl[rs.ejf] = rs.dgf[npcIDX].gmh;
            rs.dfm[rs.ejf] = rs.dgf[npcIDX].gmi;
            rs.djk[rs.ejf] = rs.dgf[npcIDX].gmf;
            rs.djl[rs.ejf] = type;
            rs.emg(rs.ejf++);
            } catch(Exception e) {  }        
        }
        
              
        /**-------------------------Quest Menu Methods-------------------------**/
        
        public boolean QuestMenu() 
        {      
         
        return rs.dck;
        }
        public void CloseQuestMenu() 
        {       
        if(QuestMenu())
            rs.dck = false;
        }
        public int CountQuestItems() 
        {      
         
        return rs.egk;
        }
        public String GetQuestMenuText(int idx) 
        {           
           
        return rs.dda[idx];
        }
        public void AnswerByName(String s) 
        {           
         W();      
            for(int i = 0; i < CountQuestItems(); i++) {
                if(GetQuestMenuText(i).equalsIgnoreCase(s)) {                    
                    rs.aag.hcn(189);
                    rs.aag.hdb(i);
                    rs.aag.hdl();
                    CloseQuestMenu();
                    
                }
            }              
        }
        public void Answer(int idx) 
        {   W(); 
                  
            rs.aag.hcn(189);
            rs.aag.hdb(idx);
            rs.aag.hdl();
            CloseQuestMenu();           
         }
         
       /**-------------------------Last Message Methods-------------------------**/
                
        public String GetLastServerMessage()
        {      
        
        return rs.lastServerMessage;
        }        
        public String GetMyPlayerLastSaid()
        {      
      
        return rs.myPlayerLastSaid;
        }
        public String GetLastChatMessage()
        {      
       
        return rs.lastChatMessage;
        }
        public String GetLastChatter()
        {      
      
        return rs.lastChatter;
        }
        public String GetLastPM()
        {      
        
        return rs.lastPM;
        }
        public String GetLastPMer()
        {     
        
        return rs.lastPMer;
        }
        public String GetLastQuestMessage()
        {
        return rs.lastQuestMessage;
        }
        public String GetLastQuestNpc()
        {
        return GetNpcName(rs.lastQuestNpcId);
        }        
        public void ResetMessages()
        {      
       
         rs.lastServerMessage = "";         
         rs.myPlayerLastSaid = "";
         rs.lastChatMessage = "";
         rs.lastChatter = "";
         rs.lastPM = "";
         rs.lastPMer = "";
         rs.lastQuestMessage = "";
         rs.lastQuestNpcId = -1;
        }
}