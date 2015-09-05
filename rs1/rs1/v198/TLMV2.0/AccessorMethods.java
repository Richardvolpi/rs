import java.util.Random;

/**
 * all methods return -1, false, or an empty sting on error.
 * @version 1.0
 * @updated 20.10.2004 11:38 am
 */
public class AccessorMethods {
    public Bot rs;
    public boolean loggedIn() { return false; }
    public boolean isMobFighting(f mob) { return false; }
    public f getPlayer() { return new f(); }
    
    private Random r = new Random();
    /**
     * generates random numbers
     * @param base the lowest possible random number
     * @param range the maximum amount allowed greater than base
     * @return random number between base and range
     */
    public int random(int base, int range) {
        return base + r.nextInt(range);
    }
    
    /**************************************************************************/
    /*                        this.player methods                             */
    /**************************************************************************/
    
    //rs.ekl == thisPlayer;
    
    /**
     * get current x coordinate
     * @return the current player's x coordinate
     */
    public int getX() {
        return (rs.ekl.gmh - 64) / rs.eik + rs.dlb;
    }
    
    /**
     * get current y coordinate
     * @return the current player's y coordinate
     */
    public int getY() {
        return (rs.ekl.gmi - 64) / rs.eik + rs.dlc;
    }
    
    /**
     * get current coordinates
     * @return the current player's x and y coordinates
     */
    public Tile getPos() {
        return new Tile((rs.ekl.gmh - 64) / rs.eik + rs.dlb, (rs.ekl.gmi - 64) / rs.eik + rs.dlc);
    }
    
    /**
     * checks if current player is walking
     * @return true if the current player is walking
     */
    public boolean isWalking() {
        return ((rs.ekl.gna + 1) % 10 != rs.ekl.gmn);
    }
    
    /**
     * get this players current fatigue level
     * @return fatigue level
     */
    public int getFatigueLevel() {
        return (rs.een * 100) / 750;
    }
    
    /**
     * get max skill level
     * warning: this method does not have a range check,
     *  so make sure that you pass correct values to it
     *
     * "Attack" = 0, "Thieving" = 17, the rest fall inbetween
     * index = "Attack", "Defense", "Strength", "Hits", "Ranged",
     *    "Prayer", "Magic", "Cooking", "Woodcut", "Fletching",
     *    "Fishing", "Firemaking", "Crafting", "Smithing",
     *    "Mining", "Herblaw", "Agility", "Thieving"
     * @param idx skill index
     * @return max skill level
     */
    public int getMaxSkillLevel(int idx) {
        return rs.eab[idx];
    }
    
    /**
     * get current skill level
     * warning: this method does not have a range check,
     *  so make sure that you pass correct values to it
     *
     * check getMaxSkillLevel() for an explaination of skill index
     * @param idx skill index
     * @return current skill level
     */
    public int getSkillLevel(int idx) {
        return rs.dhc[idx];
    }
    
    /**
     * get current skill experience
     * warning: this method does not have a range check,
     *  so make sure that you pass correct values to it
     *
     * check getMaxSkillLevel() for an explaination of skill index
     * @param idx skill index
     * @return current skill exp
     */
    public int getSkillExp(int idx) {
        return rs.dga[idx];
    }
    
    /**
     * get current hitpoints
     * provided as a convienence method
     * @return current hit points
     */
    public int getHP() {
        return rs.dhc[3];
    }
    
    /**
     * get max hitpoints
     * provided as a convienence method
     * @return max hit points
     */
    public int getMaxHP() {
        return rs.eab[3];
    }
    
    /**
     * get current combat style
     * index combat index =
     *    0 = controlled
     *    1 = aggressive
     *    2 = accurate
     *    3 = defensive
     * @return current combat style
     *
     */
    public int getCombatStyle() {
        return rs.dik;
    }
    
    /**
     * set current combat style
     * check getCombatStyle() for an explanation of the combat index
     * @param idx combat index
     */
    public void setCombatStyle(int idx) {
        
    }
    
    /**************************************************************************/
    /*                 walking, distance, location methods                    */
    /**************************************************************************/
    
    private int maxDist = 16 * 16;
    
    /**
     * this class provides a convienient way to store and pass coordinates
     */
    class Tile {
        
        /**
         * x coordinate
         */
        public int x;
        /**
         * y coordinate
         */
        public int y;
        
        /**
         * constructor
         * @param x x coordinate
         * @param y y coordinate
         */
        public Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        /**
         * get distance from this coordinate to coordinate
         * @param x x coordinate
         * @param y y coordinate
         * @return distance in d^2
         */
        public int distanceFrom(int x, int y) {
            int dx = this.x - x;
            int dy = this.y - y;
            
            return (dx * dx) + (dy * dy);
        }
        
        /**
         * get distance from this coordinate to coordinate
         * @param c a coordinate
         * @return distance in d^2
         */
        public int distanceFrom(Tile c) {
            int dx = x - c.x;
            int dy = y - c.y;
            
            return (dx * dx) + (dy * dy);
        }
        
        /**
         * checks if this coordinate is in an area
         * @param x1 x coordinate for point 1
         * @param y1 y coordinate for point 1
         * @param x2 x coordinate for point 2
         * @param y2 y coordinate for point 2
         * @return true if this coordinate is in area
         */
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
    
    /**
     * walks to an x and y coordinate
     * @param x x coordinate
     * @param y y coordinate
     * @return true if walk command was successfully sent
     */
    public boolean walkTo(int x, int y) {
        int playerX = getX();
        int playerY = getY();
        
        if(getDistance(playerX, playerY, x, y) > maxDist)
            return false;
        
        int i = (rs.eed.gjn(playerX - rs.dlb, playerY - rs.dlc, x - rs.dlb, y - rs.dlc, x - rs.dlb, y - rs.dlc, rs.ejm, rs.ejn, false));
        if(i < 0)
            return false;
        else {
            rs.eec[rs.djc] = 920;
            rs.eib[rs.djc] = x - rs.dlb;
            rs.eic[rs.djc] = y - rs.dlc;
            rs.fcc(rs.djc++);
            return true;
        }
    }
    
    
    /**
     * walks to an x and y coordinate
     * @param c a coordinate
     * @return true if walk command was successfully sent
     */
    public boolean walkTo(Tile c) {
        int playerX = getX();
        int playerY = getY();
        int x = c.x;
        int y = c.y;
        
        if(getDistance(playerX, playerY, x, y) > maxDist)
            return false;
        
        int i = (rs.eed.gjn(playerX - rs.dlb, playerY - rs.dlc, x - rs.dlb, y - rs.dlc, x - rs.dlb, y - rs.dlc, rs.ejm, rs.ejn, false));
        if(i < 0)
            return false;
        else {
            rs.eec[rs.djc] = 920;
            rs.eib[rs.djc] = x - rs.dlb;
            rs.eic[rs.djc] = y - rs.dlc;
            rs.fcc(rs.djc++);
            return true;
        }
    }
    
    /**
     * attempts to walk to an area specified by: (x -r, y - r, x + r, y + r)
     * @param x x coordinate
     * @param y y coordinate
     * @param r range allowed greater and less than x and y
     * @return true if walk command was successfully sent
     */
    public boolean walkToArea(int x, int y, int r) {
        return walkToArea(x - r, y - r, x + r, y + r);
    }
    
    /**
     * attempts to walk to an area specified by: (x1, y1, x2, y2)
     * @param x1 x coordinate for point1
     * @param y1 y coordinate for point1
     * @param x2 x coordinate for point2
     * @param y2 y coordinate for point2
     * @return true if walk command was successfully sent
     */
    public boolean walkToArea(int x1, int y1, int x2, int y2) {
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
        
        return walkTo(random(x1, x2), random(y1, y2));
    }
    
    /**
     * returns the distance between 2 points
     * @param x1 x coordinate for point1
     * @param y1 y coordinate for point1
     * @param x2 x coordinate for point2
     * @param y2 y coordinate for point2
     * @return distance in d^2
     */
    public int getDistance(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        
        return (dx * dx) + (dy + dy);
    }
    
    /**
     * checks if a location is reachable from your current position
     * @param x x coordinate
     * @param y y coordinate
     * @return true if location is reachable
     */
    public boolean isReachable(int x, int y) {
        int i = (rs.eed.gjn(rs.ekm, rs.ekm, x - rs.dlb, y - rs.dlc, x - rs.dlb, y - rs.dlc, rs.ejm, rs.ejn, false));
        return (i > -1 ? true : false);
    }
    
    /**
     * checks if a location is reachable from your current position
     * @param c a coordinate
     * @return true if location is reachable
     */
    public boolean isReachable(Tile c) {
        int i = (rs.eed.gjn(rs.ekm, rs.ekm, c.x - rs.dlb, c.y - rs.dlc, c.x - rs.dlb, c.y - rs.dlc, rs.ejm, rs.ejn, false));
        return (i > -1 ? true : false);
    }
    
    /**
     * checks if an area is reachable
     * @param x1 x coordinate for point1
     * @param y1 y coordinate for point1
     * @param x2 x coordinate for point2
     * @param y2 y coordinate for point2
     * @return true is area is reachable
     */
    public boolean isAreaReachable(int x1, int y1, int x2, int y2) {
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
        
        int i = (rs.eed.gjn(rs.ekm, rs.ekm, x1 - rs.dlb, y1 - rs.dlc, x2 - rs.dlb, y2 - rs.dlc, rs.ejm, rs.ejn, false));
        return (i > -1 ? true : false);
    }
    
    /**
     * checks if current player is in specified area
     * @param x1 x coordinate for point1
     * @param y1 y coordinate for point1
     * @param x2 x coordinate for point2
     * @param y2 y coordinate for point2
     * @return true if current player is in specified area
     */
    public boolean inArea(int x1, int y1, int x2, int y2) {
        return (getX() < x1 && getX() > x2 && getY() < y1 && getY() > y2);
    }
    
    /**
     * returns the length of the path required to reach coordinates
     * @param x1 the starting x coordinate
     * @param y1 the starting y coordinate
     * @param x2 the ending x coordinate
     * @param y2 the ending y coordinate
     * @return path length, -1 if destination is not reachable
     */
    public int getPathLength(int x1, int y1, int x2, int y2) {
        x1 -= rs.dlb;
        y1 -= rs.dlc;
        x2 -= rs.dlb;
        y2 -= rs.dlc;
        
        int i = (rs.eed.gjn(x1, y1, x2, y2, x2, y2, rs.ejm, rs.ejn, false));
        
        if(i < 0)
            return -1;
        
        int len = 0;
        
        for(i--; i >= 0; i--) {
            int dx = x1 - rs.ejm[i];
            int dy = y1 - rs.ejn[i];
            x1 = rs.ejm[i];
            y1 = rs.ejn[i];
            
            System.out.println("dx = " + dx + "; dy = " + dy + "; len = " + len);
            
            if(dx < 0) dx = -dx;
            if(dy < 0) dy = -dy;
            
            if(dx > dy) len += dx;
            else len += dy;
        }
        
        System.out.println("total = " + len);
        return len;
    }
    
    
    /**************************************************************************/
    /*                          object methods                                */
    /**************************************************************************/
    
    /**
     * get the number of objects in the current zone
     * @return number of objects
     */
    public int getNumObjects() {
        return rs.dma;
    }
    
    /**
     * get the type of an object
     * @param idx object index
     * @return object type
     */
    public int getObjectType(int idx) {
        
        if(idx < 0 || idx >= rs.dma) {
            System.out.println("getObjectType(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.dji[idx];
        }
    }
    
    /**
     * get the name of an object
     * @param type object type
     * @return object name
     */
    public String getObjectName(int type) {
        return e.ajl[type];
    }
    
    /**
     * get the description of an object
     * @param type object type
     * @return object description
     */
    public String getObjectDesc(int type) {
        return e.ajm[type];
    }
    
    /**
     * get command 1 of an object
     * @param type object type
     * @return object command 1
     */
    public String getObjectCmd1(int type) {
        return e.ajn[type];
    }
    
    /**
     * get command 2 of an object
     * @param type object type
     * @return object command 2
     */
    public String getObjectCmd2(int type) {
        return e.aka[type];
    }
    
    /**
     * get the index of object at coordinates, if any
     * @param x x coordinate of an object
     * @param y y coordinate of an object
     * @return object index, -1 if object not found
     */
    public int getObjectAt(int x, int y) {
        x -= rs.dlb;
        y -= rs.dlc;
        
        for(int i = 0; i < rs.dma; i++) {
            if(rs.djg[i] == x && rs.djh[i] == y)
                return i;
        }
        
        return -1;
    }
    
    /**
     * get the coordinates of an object at index
     * @param idx object index
     * @return object's x and y coordinates, null if object not found
     */
    public Tile getObjectPos(int idx) {
        
        if(idx < 0 || idx >= rs.dma) {
            System.out.println("getObjectPos(): index is out of range: " + idx);
            return null;
        } else {
            return new Tile(rs.djg[idx] + rs.dlb, rs.djh[idx] + rs.dlc);
        }
    }
    
    /**
     * use command 1 of an object
     * @param idx object index
     */
    public void objectCmd1(int idx) {
        
        if(idx < 0 || idx >= rs.dma) {
            System.out.println("objectCmd1(): index is out of range: " + idx);
        } else {
            rs.eec[rs.djc] = 420;
            rs.eib[rs.djc] = rs.djg[idx];
            rs.eic[rs.djc] = rs.djh[idx];
            rs.dmh[rs.djc] = rs.djj[idx];
            rs.dmi[rs.djc] = rs.dji[idx];
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * use command 2 of an object
     * @param idx object index
     */
    public void objectCmd2(int idx) {
        
        if(idx < 0 || idx >= rs.dma) {
            System.out.println("objectCmd1(): index is out of range: " + idx);
        } else {
            rs.eec[rs.djc] = 2400;
            rs.eib[rs.djc] = rs.djg[idx];
            rs.eic[rs.djc] = rs.djh[idx];
            rs.dmh[rs.djc] = rs.djj[idx];
            rs.dmi[rs.djc] = rs.dji[idx];
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * use command 1 or 2 of an object at coordinates if it matches a string
     * @param x x coordinate of an object
     * @param y y coordinate of an object
     * @param cmd the command to use
     * @return true if command was sent
     */
    public boolean objectCommandAt(int x, int y, String cmd) {
        x -= rs.dlb;
        y -= rs.dlc;
        
        for(int i = 0; i < rs.dma; i++) {
            if(rs.djg[i] == x && rs.djh[i] == y) {
                if(getObjectCmd1(i).equalsIgnoreCase(cmd)) {
                    objectCmd1(i);
                    return true;
                } else if(getObjectCmd2(i).equalsIgnoreCase(cmd)) {
                    objectCmd2(i);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    /**************************************************************************/
    /*                       wall object methods                              */
    /**************************************************************************/
    
    
    /**
     * get the number of wall objects in the current zone
     * @return number of wall objects
     */
    public int getNumWallObjects() {
        return rs.ecd;
    }
    
    /**
     * get the type of a wall object at index
     * @param idx wall object index
     * @return wall object type
     */
    public int getWallObjectType(int idx) {
        
        if(idx < 0 || idx >= rs.ecd) {
            System.out.println("getWallObjectType(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.dib[idx];
        }
    }
    
    /**
     * get the name of a wall object
     * @param type wall object type
     * @return wall object name
     */
    public String getWallObjectName(int type) {
        return e.aie[type];
    }
    
    /**
     * get the description of a wall object
     * @param type wall object type
     * @return wall object description
     */
    public String getWallObjectDesc(int type) {
        return e.aif[type];
    }
    
    /**
     * get command 1 of a wall object
     * @param type wall object type
     * @return wall object command 1
     */
    public String getWallObjectCmd1(int type) {
        return e.aig[type];
    }
    
    /**
     * get command 2 of a wall object
     * @param type wall object type
     * @return wall object command 2
     */
    public String getWallObjectCmd2(int type) {
        return e.aih[type];
    }
    
    /**
     * get the index of a wall object with coordinates
     * @param x x coordinate of a wall object
     * @param y y coordinate of a wall object
     * @return wall object index, -1 if object not found
     */
    public int getWallObjectAt(int x, int y) {
        x -= rs.dlb;
        y -= rs.dlc;
        
        for(int i = 0; i < rs.ecd; i++) {
            if(rs.dih[i] == x && rs.dii[i] == y)
                return i;
        }
        
        return -1;
    }
    
    /**
     * get the coordinates of a wall object with index
     * @param idx wall object index
     * @return coordinates of wall object, null if object not found
     */
    public Tile getWallObjectPos(int idx) {
        
        if(idx < 0 || idx >= rs.ecd) {
            System.out.println("getWallObjectAt(): index is out of range: " + idx);
            return null;
        } else {
            return new Tile(rs.dih[idx] + rs.dlb, rs.dii[idx] + rs.dlc);
        }
    }
    
    /**
     * use command 1 of a wall object
     * @param idx wall object index
     */
    public void wallObjectCmd1(int idx) {
        
        if(idx < 0 || idx >= rs.ecd) {
            System.out.println("wallObjectCmd1(): index is out of range: " + idx);
        } else {
            rs.eec[rs.djc] = 320;
            rs.eib[rs.djc] = rs.dih[idx];
            rs.eic[rs.djc] = rs.dii[idx];
            rs.dmh[rs.djc] = rs.dia[idx];
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * use command 2 of a wall object
     * @param idx wall object index
     */
    public void wallObjectCmd2(int idx) {
        
        if(idx < 0 || idx >= rs.ecd) {
            System.out.println("wallObjectCmd1(): index is out of range: " + idx);
        } else {
            rs.eec[rs.djc] = 2300;
            rs.eib[rs.djc] = rs.dih[idx];
            rs.eic[rs.djc] = rs.dii[idx];
            rs.dmh[rs.djc] = rs.dia[idx];
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * use command 1 or 2 of an object at coordinates if it matches a string
     * @param x x coordinate of a wall object
     * @param y y coordinate of a wall object
     * @param cmd the command to use
     */
    public void wallObjectAt(int x, int y, String cmd) {
        x -= rs.dlb;
        y -= rs.dlc;
        
        for(int i = 0; i < rs.ecd; i++) {
            if(rs.dih[i] == x && rs.dii[i] == y) {
                if(getWallObjectCmd1(i).equalsIgnoreCase(cmd))
                    wallObjectCmd1(i);
                else if(getWallObjectCmd2(i).equalsIgnoreCase(cmd))
                    wallObjectCmd2(i);
            }
        }
    }
    
    /**************************************************************************/
    /*                         inventory methods                              */
    /**************************************************************************/
    
    /**
     * get the number of items in inventory
     * @return items in inventory
     */
    public int getNumInvItems() {
        return rs.dfk;
    }
    
    /**
     * gets the number of a certain item in iventory
     * @param idx inventory slot
     * @return number of an item
     */
    public int getNumInvItem(int idx) {
        return rs.enf(idx);
    }
    
    /**
     * get item type at a inventory slot (0 - 29)
     * @param idx inventory slot
     * @return item type
     */
    public int getItemAtSlot(int idx) {
        
        if(idx < 0 || idx >= rs.dfk) {
            System.out.println("getItemAtSlot(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.dfl[idx];
        }
    }
    
    /**
     * get an item name
     * @param type item type
     * @return item name
     */
    public String getItemName(int type) {
        return e.alb[type];
    }
    
    /**
     * get an item description
     * @param type item type
     * @return item description
     */
    public String getItemDesc(int type) {
        return e.alc[type];
    }
    
    /**
     * get an item command
     * @param type item type
     * @return item command
     */
    public String getItemCmd(int type) {
        return e.alb[type];
    }
    
    /**
     * checks if an item can be worn
     * @param type item type
     * @return true if item can be worn
     */
    public boolean isItemWearable(int type) {
        return e.ahf[type] != 0;
    }
    
    /**
     * checks if an item is stackable
     * @param type item type    
     * 
     * @return true if item is stackable
     */
    public boolean isItemStackable(int type) {
        return e.ahd[type] != 1;
    }
    
    /**
     * checks if you can eat an item
     * @param type item type
     * @return true if you can eat item
     */
    public boolean isItemFood(int type) {
        return e.alb[type].toLowerCase().equals("eat");
    }
    
    /**
     * look forward though inventory for item with certain type
     * @param type item type
     * @return inventory slot, -1 if not found
     */
    public int getInvSlot(int type) {
        
        for(int i = 0; i < rs.dfk; i++) {
            if(rs.dfl[i] == type)
                return i;
        }
        
        return -1;
    }
    
    /**
     * checks if an item is currently being worn
     * @param idx inventory slot
     * @return true if item is worn
     */
    public boolean isItemWorn(int idx) {
        
        if(idx < 0 || idx >= rs.dfk) {
            System.out.println("isItemWorn(): index is out of range: " + idx);
            return false;
        } else if(e.ahf[rs.dfl[idx]] == 0) {
            System.out.println("isItemWorn(): item at slot is not wearable: " + idx);
            return false;
        } else {
            return rs.dfn[idx] == 1;
        }
    }
    
    /**
     * equip item at slot
     * @param idx inventory slot
     */
    public void equipItem(int idx) {
        
        if(idx < 0 || idx >= rs.dfk) {
            System.out.println("equipItem(): index is out of range: " + idx);
        } else if(e.ahf[rs.dfl[idx]] == 0) {
            System.out.println("equipItem(): item is not wearable: " + idx);
        } else if(rs.dfn[idx] == 1) {
            System.out.println("equipItem(): item is already being worn: " + idx);
        } else {
            rs.eec[rs.djc] = 630;
            rs.dmh[rs.djc] = idx;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * unequip item at slot
     * @param idx inventory slot
     */
    public void unequipItem(int idx) {
        
        if(idx < 0 || idx >= rs.dfk) {
            System.out.println("unequipItem(): index is out of range: " + idx);
        } else if(e.ahf[rs.dfl[idx]] == 0) {
            System.out.println("unequipItem(): item at slot is not wearable: " + idx);
        } else {
            rs.eec[rs.djc] = 620;
            rs.dmh[rs.djc] = idx;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * use command of item at slot
     * @param idx inventory slot
     */
    public void itemCmd(int idx) {
        
        if(idx < 0 || idx >= rs.dfk) {
            System.out.println("itemCmd(): index is out of range: " + idx);
        } else {
            rs.eec[rs.djc] = 640;
            rs.dmh[rs.djc] = idx;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * drop item at slot
     * @param idx inventory slot
     */
    public void dropItem(int idx) {
        
        if(idx < 0 || idx >= rs.dfk) {
            System.out.println("dropItem(): index is out of range: " + idx);
        } else {
            rs.eec[rs.djc] = 660;
            rs.dmh[rs.djc] = idx;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * use an item with another item
     * @param item1 inventory slot
     * @param item2 inventory slot
     */
    public void useItemWithItem(int item1, int item2) {
        
        if(item1 < 0 || item1 >= rs.dfk) {
            System.out.println("useItemWithItem(): item1 is out of range: " + item1);
        } else if(item2 < 0 || item2 > rs.dfk) {
            System.out.println("useItemWithItem(): item2 is out of range: " + item2);
        } else {
            rs.eec[rs.djc] = 610;
            rs.dmh[rs.djc] = item1;
            rs.dmi[rs.djc] = item2;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * use item with ground item
     * @param item inventory slot
     * @param groundItem ground item index
     */
    public void useItemWithGroundItem(int item, int groundItem) {
        
        if(item < 0 || item >= rs.dfk) {
            System.out.println("useItemWithGroundItem(): item is out of range: " + item);
        } else if(groundItem < 0 || groundItem > rs.dnn) {
            System.out.println("useItemWithGroundItem(): groundItem is out of range: " + groundItem);
        } else {
            rs.eec[rs.djc] = 210;
            rs.eib[rs.djc] = rs.dkc[groundItem];
            rs.eic[rs.djc] = rs.dkd[groundItem];
            rs.dmh[rs.djc] = rs.dke[groundItem];
            rs.dmi[rs.djc] = item;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * use an item with an object
     * @param item inventory slot
     * @param object object index
     */
    public void useItemWithObject(int item, int object) {
        
        if(item < 0 || item >= rs.dfk) {
            System.out.println("useItemWithObject(): item is out of range: " + item);
        } else if(object < 0 || object > rs.dma) {
            System.out.println("useItemWithObject(): object is out of range: " + object);
        } else {
            rs.eec[rs.djc] = 410;
            rs.eib[rs.djc] = rs.djg[object];
            rs.eic[rs.djc] = rs.djh[object];
            rs.dmh[rs.djc] = rs.djj[object];
            rs.dmi[rs.djc] = rs.dji[object];
            rs.dmj[rs.djc] = item;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * use an item with a wall object
     * @param item inventory slot
     * @param wallObject wall object index
     */
    public void useItemWithWallObject(int item, int wallObject) {
        
        if(item < 0 || item >= rs.dfk) {
            System.out.println("useItemWithWallObject(): item is out of range: " + item);
        } else if(wallObject < 0 || wallObject > rs.ecd) {
            System.out.println("useItemWithWallObject(): wallObject is out of range: " + wallObject);
        } else {
            rs.eec[rs.djc] = 310;
            rs.eib[rs.djc] = rs.djg[wallObject];
            rs.eic[rs.djc] = rs.djh[wallObject];
            rs.dmh[rs.djc] = rs.djj[wallObject];
            rs.dmi[rs.djc] = rs.dji[wallObject];
            rs.dmj[rs.djc] = item;
            rs.fcc(rs.djc++);
        }
    }
    
    /**************************************************************************/
    /*                           bank methods                                 */
    /**************************************************************************/
    
    /**
     * checks if your bank account is open
     * @return true if bank account window is open
     */
    public boolean isBankOpen() {
        return rs.edn;
    }
    
    /**
     * closes your bank account
     */
    public void closeBankAcc() {
        
        if(!rs.edn) {
            System.out.println("closeBank(): bank account is not open");
        } else {
            rs.aag.hda(50);
            rs.aag.hdm();
            rs.edn = false;
        }
    }
    
    /**
     * gets the total number of items in your bank and inventory
     * do not try to deposit something if it is not in this array
     * @return number of items in bank and inventory
     */
    public int getNumBankItems() {
        return rs.eej;
    }
    
    /**
     * gets the type of a bank item
     * @param idx bank item slot
     * @return item type
     */
    public int getBankItemType(int idx) {
        
        if(idx < 0 || idx >= rs.eej) {
            System.out.println("getBankItemType(): index is out of range: " + idx);
            return -1;
        }
        
        return rs.ejf[idx];
    }
    
    /**
     * gets the number of a bank item
     * @param idx bank item slot
     * @return number of bank item
     */
    public int getNumBankItem(int idx) {
        
        if(idx < 0 || idx >= rs.eej) {
            System.out.println("getNumBankItem(): index is out of range: " + idx);
            return -1;
        } else if(rs.ejf[idx] < 0) {
            return 0;
        }
        
        return rs.ejg[idx];
    }
    
    /**
     * find an bank item by type
     * @param type item type
     * @return bank item slot, -1 if not found
     */
    public int getBankItem(int type) {
        
        for(int i = 0; i < rs.eej; i++) {
            if(rs.ejf[i] == type) 
                return i;
        }
        
        return -1;
    }
    
    /**
     * deposit item
     * sends correct command
     * @param idx inventory slot
     * @return 0 if nothing was done, else the amount that was deposited
     */
    public int depositItem(int idx) {
        
        int amount = rs.enf(idx); 
        if(amount >= 2500) {
            amount = 2500;
        } else if(amount >= 500) {
            amount = 500;
        } else if(amount >= 100) {
            amount = 100;
        } else if(amount >= 25) {
            amount = 25;
        } else if(amount >= 5) {
            amount = 5;
        } else if(amount >= 1) {
            amount = 1;
        } else return 0;
        
        return depositItem(idx, amount) ? amount : -1; 
        
    }
    
    private boolean depositItem(int idx, int amount) {
        
        if(amount < 0 || amount > rs.enf(idx)) {
            System.out.println("depositItem(): amount is out of range: " + amount);
            return false;
        } else if(getBankItem(idx) == -1) {
            System.out.println("depositItem(): could not deposit item: " + idx);
            return false;
        } else {
            rs.aag.hda(145);
            rs.aag.hdk(idx);
            rs.aag.hdk(amount);
            rs.aag.hdm();
            return true;
        }
        
        
        
    }
    
    /**
     * withdraw item
     * sends correct command
     * nonstackable items may only be withdrawn one at a time
     * @param type item type
     * @return 0 if nothing was done, else the amount that was withdrawn.
     */
    public int withdrawItem(int type) {
        
        int idx = getBankItem(type);
        if(idx == -1) {
            return 0;
        }
        
        int amount = getNumBankItem(idx);
        if(e.ahd[type] == 1 && amount > 1) {
            amount = 1;
        } else if(amount >= 2500) {
            amount = 2500;
        } else if(amount >= 500) {
            amount = 500;
        } else if(amount >= 100) {
            amount = 100;
        } else if(amount >= 25) {
            amount = 25;
        } else if(amount >= 5) {
            amount = 5;
        } else if(amount >= 1) {
            amount = 1;
        } else return 0;
        
        return withdrawItem(type, amount) ? amount : -1;
    }
    
    private boolean withdrawItem(int type, int amount) {
        
        int idx = getBankItem(type);
        if(idx == -1) {
            System.out.println("withdrawItem(): could not find item in bank: " + type);
            return false;
        } else if(amount < 0 || amount > getNumBankItem(idx)) {
            System.out.println("withdrawItem(): amount is out of range: " + amount);
            return false;
        } else {
            rs.aag.hda(83);
            rs.aag.hdk(type);
            rs.aag.hdk(amount);
            rs.aag.hdm();
            return true;
        }
        
    }
    
    /**************************************************************************/
    /*                            shop methods                                */
    /**************************************************************************/
    
    /**
     * gets the amount of geepee in inventory.
     * @return number of geepee
     */
    public int getGeePee() {
        return rs.enf(10);
    }
    
    /**
     * checks if shop window is open
     * @return true if shop window is open
     */
    public boolean isShopOpen() {
        return rs.dhb; 
    }
    
    /**
     * closes shop window
     */
    public void closeShop() {
        
        if(!rs.dhb) {
            System.out.println("closeShop(): shop window is not open");
        }
        
        rs.aag.hda(56);
        rs.aag.hdm();
        rs.dhb = false;
    }
    
    /**
     * gets the type of a shop item.
     * @param idx shop item index
     * @return item type
     */
    public int getShopItemType(int idx) {
        if(idx < 0 || idx > 39) {
            System.out.println("getShopItemType(): index is out of range: " + idx);
            return -1;
        }
        
        return rs.dhk[idx];
    }
    
    /**
     * find shop item index by type
     * @param type item type
     * @return shop item index, -1 if item not found
     */
    public int getShopItem(int type) {
        
        for(int i = 0; i < 39; i++) {
            if(rs.dhk[i] == type)
                return i;
        }
        
        return -1;
    }
       
    /**
     * gets the number of a shop item
     * @param type item type
     * @return number of shop item
     */
    public int getNumShopItem(int type) {
        
        if(!rs.dhb) {
            System.out.println("getNumShopItem(): shop window is not open");
            return -1;
        } else if(getShopItem(type) == -1) {
            System.out.println("getNumShopItem(): item not found in shop inventory");
            return -1;
        }
        return rs.dhl[type];
    }
    
    /**
     * gets the current item sale price
     * @param type item type
     * @return shop item sale price
     */
    public int getItemSalePrice(int type) {
        
        if(!rs.dhb) {
            System.out.println("getItemSalePrice(): shop window is not open");
            return -1;
        } 
        
        int i = getShopItem(type);
        if(i == -1) {
            System.out.println("getItemSalePrice(): item not found in shop inventory");
            return -1;
        }
        
        int mod = rs.efg + rs.dhm[i];
        if(mod < 10)
            mod = 10;
        
        return (mod * e.ahc[type]) / 100;
    }
    
    /**
     * gets the current item buy price
     * @param type item type
     * @return shop item buy price
     */
    public int getItemBuyPrice(int type) {
        
        if(!rs.dhb) {
            System.out.println("getItemBuyPrice(): shop window is not open");
            return -1;
        } 
        
        int i = getShopItem(type);
        if(i == -1) {
            System.out.println("getItemBuyPrice(): item not found in shop inventory");
            return -1;
        }
        
        int mod = rs.eff + rs.dhm[i];
        if(mod < 10)
            mod = 10;
        
        return (mod * e.ahc[type]) / 100;
    }
    
    /**
     * sells an item
     * @param type item type
     * @return 0 if nothing was done, 1 if successful
     */
    public int sellItem(int type) {
        
        if(!rs.dhb) {
            System.out.println("sellItem(): shop window is not open");
            return -1;
        }
        
        if(rs.enf(type) < 1) {
            return 0;
        }
        
        int idx = getShopItem(type);
        if(idx < 0) {
            System.out.println("sellItem(): item cannot be sold to this store: " + type);
            return -1;
        }
        
        rs.aag.hda(211);
        rs.aag.hdk(type);
        rs.aag.hdb(getItemSalePrice(type));
        rs.aag.hdm();
        return 1;
    }
    
    /**
     * buys an item
     * @param type item type
     * @return 0 if nothing was done, 1 if successful
     */
    public int buyItem(int type) {
        
        if(!rs.dhb) {
            System.out.println("buyItem(): shop window is not open");
            return -1;
        }
        
        int idx = getShopItem(type);
        int price = getItemBuyPrice(type);
        if(idx < 0 || rs.dhl[idx] < 1 || rs.enf(10) < price) {
            return 0;
        }
        
        rs.aag.hda(157);
        rs.aag.hdk(type);
        rs.aag.hdb(price);
        rs.aag.hdm();
        return 1;
    }
    
    
    
    /**************************************************************************/
    /*                       ground item methods                              */
    /**************************************************************************/
    
    /**
     * get the number of ground items in the current zone
     * @return number of ground items
     */
    public int getNumGroundItems() {
        return rs.dnn;
    }
    
    /**
     * get type of ground item
     * @param idx ground item index
     * @return ground item type
     */
    public int getGroundItemType(int idx) {
        
        if(idx < 0 || idx >= rs.dnn) {
            System.out.println("getGroundItemType(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.dke[idx];
        }
    }
    
    /**
     * get ground item index of item at coordinates
     * @param x x coordinate of a ground item
     * @param y y coordinate of a ground item
     * @return ground item index, -1 if not found
     */
    public int getGroundItemAt(int x, int y) {
        x -= rs.dlb;
        y -= rs.dlc;
        
        for(int i = 0; i < rs.dnn; i++) {
            if(rs.dkc[i] == x && rs.dkd[i] == y)
                return i;
        }
        
        return -1;
    }
    
    /**
     * get the coordinates of a ground item
     * @param idx ground item index
     * @return ground item cooordinates
     */
    public Tile getGroundItemPos(int idx) {
        
        if(idx < 0 || idx >= rs.dnn) {
            System.out.println("getGroundItemPos(): index is out of range: " + idx);
            return null;
        } else {
            return new Tile(rs.dkc[idx] + rs.dlb, rs.dkd[idx] + rs.dlc);
        }
    }
    
    /**
     * pick up ground item
     * @param idx ground item index
     */
    public void pickupGroundItem(int idx) {
        
        if(idx < 0 || idx >= rs.dnn) {
            System.out.println("pickupGroundItem(): index is out of range: " + idx);
        } else {
            rs.eec[rs.djc] = 220;
            rs.eib[rs.djc] = rs.dkc[idx];
            rs.eic[rs.djc] = rs.dkd[idx];
            rs.dmh[rs.djc] = rs.dke[idx];
            rs.fcc(rs.djc++);
        }
    }
    
    /**************************************************************************/
    /*                            npc methods                                 */
    /**************************************************************************/
    
    /**
     * get the number of npcs in current zone
     * @return number of npcs
     */
    public int getNumNpcs() {
        return rs.efl;
    }
    
    /**
     * get the type of an npc
     * @param idx npc index
     * @return npc type
     */
    public int getNpcType(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("getNpcType(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.dka[idx].gmj;
        }
    }
    
    /**
     * get npc name
     * @param type npc type
     * @return npc name
     */
    public String getNpcName(int type) {
        return e.amf[type];
    }
    
    /**
     * get npc description
     * @param type npc type
     * @return npc description
     */
    public String getNpcDesc(int type) {
        return e.amg[type];
    }
    
    /**
     * get npc combat level
     * @param type npc type
     * @return npc combat level
     */
    public int getNpcLevel(int type) {
        return (e.ale[type] + e.alh[type] + e.alf[type] + e.alg[type]) / 4;
    }
    
    /**
     * get npc command
     * @param type npc type
     * @return npc command
     */
    public String getNpcCmd(int type) {
        return e.amh[type];
    }
    
    /**
     * search npc array for npc by type
     * @param type npc type
     * @return npc index
     */
    public int getNpcByType(int type) {
        
        for(int i = 0; i < rs.efl; i++) {
            if(rs.dka[i].gmj == type)
                return i;
        }
        
        return -1;
    }
    
    /**
     * search npc array for npc by id
     * @param id npc id
     * @return npc index
     */
    public int getNpcById(int id) {
        
        for(int i = 0; i < rs.efl; i++) {
            if(rs.dka[i].gmf == id)
                return i;
        }
        
        return -1;
    }
    
    /**
     * get the id of an npc
     * @param idx npc index
     * @return npc id
     */
    public int getNpcId(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("getNpcId(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.dka[idx].gmf;
        }
    }
    
    /**
     * get the coordinates of an npc
     * @param idx npc index
     * @return npc coordinates
     */
    public Tile getNpcPos(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("getNpcPos(): index is out of range: " + idx);
            return null;
        } else {
            return new Tile((rs.dka[idx].gmh - 64) / rs.eik + rs.dlb, (rs.dka[idx].gmi - 64) / rs.eik + rs.dlc);
        }
    }
    
    /**
     * check if an npc is walking
     * @param idx npc index
     * @return true if npc is walking
     */
    public boolean isNpcWalking(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("isNpcWalking(): index is out of range: " + idx);
            return false;
        } else {
            return rs.dka[idx].gna + 1 % 10 != rs.dka[idx].gmn;
        }
    }
    
    /**
     * checks if npc is in combat
     * @param idx npc index
     * @return true if npc is in combat
     */
    public boolean isNpcInCombat(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("isNpcInCombat(): index is out of range: " + idx);
            return false;
        } else {
            return rs.dka[idx].gml == 8 || rs.dka[idx].gml == 9;
        }
    }
    
    /**
     * check if npc is attackable
     * @param idx npc index
     * @return true if npc is attackable
     */
    public boolean canAttackNpc(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("isNpcAttackable(): index is out of range: " + idx);
            return false;
        } else {
            return e.ali[rs.dka[idx].gmj] > 0;
        }
    }
    
    /**
     * attack npc
     * @param idx npc index
     */
    public void attackNpc(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("attackNpc(): index is out of range: " + idx);
        } else if(e.ali[rs.dka[idx].gmj] <= 0) {
            System.out.println("attackNpc(): npc is not attackable: " + idx);
        } else {
            rs.eec[rs.djc] = 715;
            rs.eib[rs.djc] = rs.dka[idx].gmh;
            rs.eic[rs.djc] = rs.dka[idx].gmi;
            rs.dmh[rs.djc] = rs.dka[idx].gmf;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * get npc current health
     * @param idx npc index
     * @return npc current health
     */
    public int getNpcHits(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("getNpcHealth(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.dka[idx].gnk;
        }
    }
    
    /**
     * get npc max health
     * @param idx npc index
     * @return npc max health
     */
    public int getNpcMaxHits(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("getNpcMaxHealth(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.dka[idx].gnl;
        }
    }
    
    /**
     * use npc command
     * @param idx npc index
     */
    public void npcCmd(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("npcCmd(): index is out of range: " + idx);
        } else if(e.amh[rs.dka[idx].gmj].equals("")) {
            System.out.println("npcCmd(): npc does not have available command: " + idx);
        } else {
            rs.eec[rs.djc] = 725;
            rs.eib[rs.djc] = rs.dka[idx].gmh;
            rs.eic[rs.djc] = rs.dka[idx].gmi;
            rs.dmh[rs.djc] = rs.dka[idx].gmf;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * talk to npc
     * @param idx npc index
     */
    public void talkToNpc(int idx) {
        
        if(idx < 0 || idx >= rs.efl) {
            System.out.println("talkToNpc(): index is out of range: " + idx);
        } else {
            rs.eec[rs.djc] = 720;
            rs.eib[rs.djc] = rs.dka[idx].gmh;
            rs.eic[rs.djc] = rs.dka[idx].gmi;
            rs.dmh[rs.djc] = rs.dka[idx].gmf;
            rs.fcc(rs.djc++);
        }
    }
    
    /**************************************************************************/
    /*                          player methods                                */
    /**************************************************************************/
     
    /**
     * get the number of players in the current zone
     * @return number of player
     */
    
    public int getNumPlayers() {
        return rs.dic;
    }
    
    /**
     * gets a player id
     * @param idx player index
     * @return player id
     */
    public int getPlayerId(int idx) {
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("getPlayerId(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.elf[idx].gmf;
        }
                
    }
    
    /**
     * search player array for player by id
     * @param id player id
     * @return player index
     */
    public int getPlayerById(int id) {
        
        for(int i = 0; i < rs.dic; i++) {
            if(rs.elf[i].gmf == id)
                return i;
        }
        
        return -1;
    }
    
    /**
     * gets the coordinates of a player
     * @param idx player index
     * @return player coordinates
     */
    public Tile getPlayerPos(int idx) {
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("getPlayerPos(): index is out of range: " + idx);
            return null;
        } else {
            return new Tile((rs.elf[idx].gmh - 64) / rs.eik + rs.dlb, (rs.elf[idx].gmi - 64) / rs.eik + rs.dlc);
        }
    }
    
    /**
     * checks if a player is walking
     * @param idx player index
     * 
     * @return true if player is walking
     */
    public boolean isPlayerWalking(int idx) {
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("isPlayerWalking(): index is out of range: " + idx);
            return false;
        } else {
            return rs.elf[idx].gna + 1 % 10 != rs.elf[idx].gmn;
        }
    }
    
    /**
     * checks if a player is in combat
     * @param idx player index
     * @return true if player is in combat
     */
    public boolean isPlayerInCombat(int idx) {
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("isPlayerInCombat(): index is out of range: " + idx);
            return false;
        } else {
            return rs.dka[idx].gml == 8 || rs.dka[idx].gml == 9;
        }
    }
    
    /**
     * gets player current health
     * @param idx player index
     * @return player current health
     */
    public int getPlayerHits(int idx) {
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("getPlayerHits(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.elf[idx].gnk;
        }
    }
    
    /**
     * gets player max health
     * @param idx player index
     * @return player max health
     */
    public int getPlayerMaxHits(int idx) {
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("getPlayerMaxHits(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.elf[idx].gnl;
        }
    }
    
    /**
     * gets a player name
     * @param idx player index
     * @return player name
     */
    public String getPlayerName(int idx) {
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("getPlayerName(): index is out of range: " + idx);
            return "";
        } else {
            return rs.elf[idx].gme;
        }
    }
    
    /**
     * gets a player combat level
     * @param idx player index
     * @return player combat level
     */
    public int getPlayerLevel(int idx) {
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("getPlayerLevel(): index is out of range: " + idx);
            return -1;
        } else {
            return rs.elf[idx].gnm;
        }
    }
    
    /**
     * gets the coordinates of where a player is walking to
     * @param idx player index
     * @return player destination coordinates
     */
    public Tile getPlayerDestination(int idx) {
        int i = rs.elf[idx].gna;
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("getPlayerDestination(): index is out of range: " + idx);
	} else if(i + 1 % 10 == rs.elf[idx].gmn) {
            return new Tile((rs.elf[idx].gmh - 64) / rs.eik + rs.dlb, (rs.elf[idx].gmi - 64) / rs.eik + rs.dlc);
        }
        
        return new Tile((rs.elf[idx].gnb[i] - 64) / rs.eik + rs.dlb, (rs.elf[idx].gnc[i] - 64) / rs.eik + rs.dlb);
	
    }
    
    /**
     * checks if you can attack player according to wilderness rules (levels, etc)
     * @param idx player index
     * 
     * @return true if you can attack player
     */
    public boolean canAttackPlayer(int idx) {
        
        /*
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("canAttackPlayer(): index is out of range: " + idx);
            return false;
        }
        
        f player = rs.elf[idx];
        if(rs.ekl.gnm <= 0 || player.gnm <= 0) {
            return false;
        }
        
        int x = 2203 - (rs.ekn + rs.dml + rs.dlc);
        if(rs.ekm + rs.dmk + rs.dlb >= 2640)
            x = -50;
        
        if(x > 0 || (rs.elf[idx].gmi - 64) / rs.eik + rs.dml + rs.dlc < 2203) {
            
        }
         */
        
        return true;
    }
    
    /**
     * attack player
     * @param idx player index
     */
    public void attackPlayer(int idx) {
        
        if(idx < 0 || idx >= rs.dic) {
            System.out.println("attackPlayer(): index is out of range: " + idx);
        } else if(getY() + rs.dml > 2203) {
            System.out.println("attackPlayer(): you are not in wilderness");
        } else if((rs.elf[idx].gmi - 64) / rs.eik + rs.dlc + rs.dml > 2203) {
            System.out.println("attackPlayer(): player is not in wilderness");
        } else {
            rs.eec[rs.djc] = 805;
            rs.eib[rs.djc] = rs.elf[idx].gmh;
            rs.eic[rs.djc] = rs.elf[idx].gmi;
            rs.dmh[rs.djc] = rs.elf[idx].gmf;
            rs.fcc(rs.djc++);
        }
    }
    
    
    /**************************************************************************/
    /*                         prayer methods                                 */
    /**************************************************************************/
    
    /**
     * get the minimum prayer level
     * @param type prayer type
     * @return minimun prayer level
     */
    public int getMinPrayerLevel(int type) {
        
        if(type < 0 || type > 13) {
            System.out.println("getRequiredPrayerLevel(): type is out of range: " + type);
            return -1;
        }
        
        return e.aji[type];
    }
    
    /**
     * check if prayer is on
     * @param type prayer type
     * @return true if prayer is on
     */
    public boolean isPrayerOn(int type) {
        
        if(type < 0 || type > 13) {
            System.out.println("getRequiredPrayerLevel(): type is out of range: " + type);
            return false;
        }
        
        return rs.ddj[type];
    }
    
    /**
     * toggle prayer on or off
     * @param type prayer type
     * @return true is prayer was toggled
     */
    public boolean togglePrayer(int type) {
        
        if(type < 0 || type > 13) {
            System.out.println("togglePrayer(): type is out of range: " + type);
            return false;
        } else if(rs.dhc[5] == 0) {
            System.out.println("togglePrayer(): out of prayer points");
            return false;
        } else if(e.aji[type] > rs.eab[5]) {
            System.out.println("togglePrayer(): prayer level not high enough");
            return false;
        } else if(!rs.ddj[type]) {
            rs.aag.hda(17);
            rs.aag.hea(type);
            rs.aag.hdm();
            rs.ddj[type] = true;
            return true;
        } else {
            rs.aag.hda(164);
            rs.aag.hea(type);
            rs.aag.hdm();
            rs.ddj[type] = false;
            return true;
        }
    }
    
    /**************************************************************************/
    /*                          magic methods                                 */
    /**
     * gets spell name
     * @param type spell type
     * @return spell name
     */
    
    
    public String getSpellName(int type) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("getSpellName(): type is out of range: " + type);
            return "";
        }
        
        return e.alk[type];
    }
    
    /**
     * gets spell description
     * @param type spell type
     * @return spell description
     */
    public String getSpellDesc(int type) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("getSpellDesc(): type is out of range: " + type);
            return "";
        }
        
        return e.all[type];
    }
    
    /**
     * checks if you can cast a spell
     * @param type spell type
     * @return true if you can cast spell
     */
    public boolean canCastSpell(int type) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("canCastSpell(): type is out of tange: " + type);
            return false;
        } else if(e.akc[type] > rs.dhc[6]) {
            System.out.println("canCastSpell(): you do not have the magic level required: " + type);
            return false;
        }
        
        for(int i = 0; i < e.akd[type]; i++) {
            if(!rs.fcn(e.akf[type][i], e.akg[type][i])) {
                System.out.println("canCastSpell(): you do not have the runes required: " + type);
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * cast a spell on yourself
     * @param type spell type
     */
    public void castOnSelf(int type) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("castOnSelf(): type is out of range: " + type);
        } else if(e.ake[type] > 1) {
            System.out.println("castOnSelf(): this spell cannot be cast on self: " + type);
        } else if(canCastSpell(type)) {
            rs.eec[rs.djc] = 1000;
            rs.dmh[rs.djc] = type;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * cast spell on inventory item
     * @param type spell type
     * @param idx inventory slot
     */
    public void castOnItem(int type, int idx) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("castOnItem(): type is out of range: " + type);
        } else if(idx < 0 || idx >= rs.dfk) {
            System.out.println("castOnItem(): index is out of range: " + idx);
        } else if(e.ake[type] != 3) {
            System.out.println("castOnItem(): this spell cannot be cast on self: " + type);
        } else if(canCastSpell(type)) {
            rs.eec[rs.djc] = 600;
            rs.dmh[rs.djc] = idx;
            rs.dmi[rs.djc] = type;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * cast a spell on ground item
     * @param type spell type
     * @param idx ground item index
     */
    public void castOnGroundItem(int type, int idx) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("castOnGroundItem(): type is out of range: " + type);
        } else if(idx < 0 || idx >= rs.dnn) {
            System.out.println("castOnGroundItem(): index is out of range: " + idx);
        } else if(e.ake[type] > 1) {
            System.out.println("castOnGroundItem(): this spell cannot be cast on self: " + type);
        } else if(canCastSpell(type)) {
            rs.eec[rs.djc] = 200;
            rs.eib[rs.djc] = rs.dkc[idx];
            rs.eic[rs.djc] = rs.dkd[idx];
            rs.dmh[rs.djc] = rs.dke[idx];
            rs.dmi[rs.djc] = type;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * cast a spell on object
     * @param type spell type
     * @param idx object index
     */
    public void castOnObject(int type, int idx) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("castOnObject(): type is out of range: " + type);
        } else if(idx < 0 || idx >= rs.dma) {
            System.out.println("castOnObject(): index is out of range: " + idx);
        } else if(e.ake[type] != 5) {
            System.out.println("castOnObject(): this spell cannot be cast on self: " + type);
        } else if(canCastSpell(type)) {
            rs.eec[rs.djc] = 400;
            rs.eib[rs.djc] = rs.djg[idx];
            rs.eic[rs.djc] = rs.djh[idx];
            rs.dmh[rs.djc] = rs.djj[idx];
            rs.dmi[rs.djc] = rs.dji[idx];
            rs.dmj[rs.djc] = type;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * cast a spell on wall object
     * @param type spell type
     * @param idx wall object index
     */
    public void castOnWallObject(int type, int idx) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("castOnWallObject(): type is out of range: " + type);
        } else if(idx < 0 || idx >= rs.ecd) {
            System.out.println("castOnWallObject(): index is out of range: " + idx);
        } else if(e.ake[type] != 4) {
            System.out.println("castOnWallObject(): this spell cannot be cast on self: " + type);
        } else if(canCastSpell(type)) {
            rs.eec[rs.djc] = 300;
            rs.eib[rs.djc] = rs.dih[idx];
            rs.eic[rs.djc] = rs.dii[idx];
            rs.dmh[rs.djc] = rs.dia[idx];
            rs.dmi[rs.djc] = type;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * cast a spell on npc
     * @param type spell type
     * @param idx npc index
     */
    public void castOnNpc(int type, int idx) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("castOnNpc(): type is out of range: " + type);
        } else if(idx < 0 || idx >= rs.efl) {
            System.out.println("castOnNpc(): index is out of range: " + idx);
        } else if(e.ake[type] != 2) {
            System.out.println("castOnNpc(): this spell cannot be cast on self: " + type);
        } else if(canCastSpell(type)) {
            rs.eec[rs.djc] = 700;
            rs.eib[rs.djc] = rs.dka[idx].gmh;
            rs.eic[rs.djc] = rs.dka[idx].gmi;
            rs.dmh[rs.djc] = rs.dka[idx].gmf;
            rs.dmi[rs.djc] = type;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * cast spell on player
     * @param type spell type
     * @param idx player index
     */
    public void castOnPlayer(int type, int idx) {
        
        if(type < 0 || type >= e.alm) {
            System.out.println("castOnPlayer(): type is out of range: " + type);
        } else if(idx < 0 || idx >= rs.dic) {
            System.out.println("castOnPlayer(): index is out of range: " + idx);
        } else if(e.ake[type] != 1 || e.ake[type] != 2) {
            System.out.println("castOnPlayer(): this spell cannot be cast on self: " + type);
        } else if(canCastSpell(type)) {
            rs.eec[rs.djc] = 800;
            rs.eib[rs.djc] = rs.elf[idx].gmh;
            rs.eic[rs.djc] = rs.elf[idx].gmi;
            rs.dmh[rs.djc] = rs.elf[idx].gmf;
            rs.dmi[rs.djc] = type;
            rs.fcc(rs.djc++);
        }
    }
    
    /**
     * cast a spell on tile
     * @param type spell type
     * @param t coordinates
     */
    public void castOnTile(int type, Tile t) {
        int x = t.x - rs.dlb;
        int y = t.y - rs.dlc;
        
        if(type < 0 || type >= e.alm) {
            System.out.println("castOnSelf(): type is out of range: " + type);
        } else if(e.ake[type] != 6) {
            System.out.println("castOnSelf(): this spell cannot be cast on self: " + type);
        } else if(canCastSpell(type)) {
            rs.eec[rs.djc] = 900;
            rs.eib[rs.djc] = x;
            rs.eic[rs.djc] = y;
            rs.dmh[rs.djc] = type;
            rs.fcc(rs.djc++);
        }
    }
    
    /**************************************************************************/
    /*                         dialog methods                                 */
    /**************************************************************************/
    
    /**
     * checks if a dialog is shown
     * @return true if dialog is shown
     */
    public boolean isDialogShown() {
        return rs.eca;
    }
    
    /**
     * removes the dialog from the screen
     */
    public void hideDialog() {
        rs.eca = false;
    }
    
    /**
     * get the number of dialog items on screen
     * @return number of dialog items
     */
    public int getNumDialogItems() {
        return rs.ehh;
    }
    
    /**
     * get dialog text
     * @param idx dialog index
     * @return dialog text
     */
    public String getDialogText(int idx) {
        
        if(idx < 0 || idx >= rs.ehh) {
            System.out.println("getDialogText(): index is out of range: " + idx);
            return "";
        } else {
            return rs.egf[idx];
        }
    }
    
    /**
     * use dialog item
     * @param s dialog text
     * @return true if dialog item was chosen
     */
    public boolean chooseDialogItem(String s) {
        
        if(!rs.eca) {
            System.out.println("chooseDialogItem(): dialog not shown");
            return false;
        } else {
            
            for(int i = 0; i < rs.ehh; i++) {
                if(rs.egf[i].equalsIgnoreCase(s)) {
                    rs.aag.hda(203);
                    rs.aag.hea(i);
                    rs.aag.hdm();
                    rs.eca = false;
                    return true;
                }
            }
            
            return false;
        }
    }
    
    /**
     * use dialog item
     * @param idx dialog index
     * @return true if dialog item was chosen
     */
    public boolean chooseDialogItem(int idx) {
        
        if(!rs.eca) {
            System.out.println("chooseDialogItem(): dialog not shown");
            return false;
        } else if(idx < 0 || idx >= rs.ehh) {
            System.out.println("chooseDialogItem(): index is out of range: " + idx);
            return false;
        } else {
            rs.aag.hda(203);
            rs.aag.hea(idx);
            rs.aag.hdm();
            rs.eca = false;
            return true;
        }
    }
    public boolean sleeping() {
        return rs.ede;
    }   
    public int getFatigue() {
        return rs.eem * 100 / 750;
    }

    public void sendWord(String word) {
        rs.aag.hda(60);
        rs.aag.hdn(word);
        rs.aag.hdm();
        rs.fkl = "";
        rs.fkm = "";
        rs.ebi = "Please wait...";
    }
    public int getSleepingFatigue() { return rs.een * 100 / 750; }
    public void sleep() {
        int pos = getInvItemLoc("Sleeping bag");
        if (pos > -1)
            useInvItem(pos);
    }
    public int getInvItemLoc(String name) {
        for (int x = 0; x < getInvSize(); x++)
            if (getItemNameById(getInv(x)).equalsIgnoreCase(name))
                return x;
        return -1;
    }
    public String getItemNameById(int id) {
        return e.alb[id];
    }
    
    public int getInvSize() {
        return rs.dfk;
    }
    public int getInv(int slot) {
        return rs.dfl[slot];
    }
        public void useInvItem(int slot) {
        rs.eec[rs.djc] = 640;
        rs.dmh[rs.djc] = slot;
        rs.fcc(rs.djc++);
    }
}
