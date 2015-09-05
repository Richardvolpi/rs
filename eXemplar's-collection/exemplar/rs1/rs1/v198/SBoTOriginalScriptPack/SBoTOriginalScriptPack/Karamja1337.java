//By MicH

public class Karamja1337 extends Script {
    public Karamja1337(mudclient mudclient) {
        super(mudclient);
    }
    public String[] getCommands()
    {
        return (new String[] {
            "k1337"
        });
    }
    public boolean inArea(int x1,int y1,int x2,int y2) {
       if(GetX() >= x1) {
          if(GetX() <= x2) {
             if(GetY() >= y1) {
                if(GetY() <= y2) {
                   return true;
                } else return false;
             } else return false;
          } else return false;
       } else return false;
    }
    public void ServerMessage(String s) {
       if(s.indexOf("attempt") > 0) {    //Start fish
          fishing = true;
       }
       if(s.indexOf("tired") > 0) {      //Must sleep
          sleep = true;
       }
       if(s.indexOf("Welcome") > 0) {    //Just logged in
          sleep = false;
       }
       if(s.indexOf("refreshed") > 0) {//Wake up
          sleep = false;
       }
       if(s.indexOf("busy") > 0) {   //NPC Busy
          busy = true;
       }
    }
    public boolean fishing;
    public boolean sleep;
    public boolean busy;
    public boolean breakWait;
    public boolean onCoords(int x,int y) {
       if(GetX() == x) {
          if(GetY() == y) {
             return true;
          } else return false;
       } else return false;
    }
    public void MoveTo(int x,int y) {
       while(!onCoords(x,y)) {
          breakWait = false;
          int Check = 750; 
          int CurrentX = GetX();
          int CurrentY = GetY();
          try {
             WalkNoWait(x,y);
             long l = System.currentTimeMillis();
         while(!onCoords(x,y) && System.currentTimeMillis() - l <= 33333 && !breakWait) {
            Wait(10);
            if(System.currentTimeMillis() - l >= Check) {
                  if(GetX() == CurrentX && CurrentY == GetY()) { //Checks if we still moving
                     breakWait = true;
                  }
                  Check += 750;
                  CurrentX = GetX();
                  CurrentY = GetY();
               }
            }
         } catch(Exception e) { }
   }
    }          
    public void start(String s, String as[]) {
       DisplayMessage("@gr2@Karamja1337 by MicH!",3);
       while(Running()) {
      while(inArea(369,379,372,691) && InvCount(372) < 25) {
             while(!sleep && InvCount(372) < 25) {
                fishing = false;
                while(!fishing && !sleep) {
                   AtObject2(368,684);
                   Wait(500);
                }
                if(fishing) {
                   WaitForServerMessage(3000);
                }                 
             }
             if(sleep) {
                Use(FindInv(1263));
                Wait(3000);
                while(Sleeping() && sleep) {
                   Wait(100);
                }
                sleep = false;
             }
          }
          MoveTo(361,702);
          MoveTo(354,702);
          MoveTo(346,709);
          MoveTo(334,713);
          while(GetY() > 700) {
             int officer = GetNearestNPC(163);
             if(officer != -1 && !QuestMenu()) {
                busy = false;
                TalkToNPC(officer);
                long l = System.currentTimeMillis();
                while(!busy && System.currentTimeMillis() - l <= 4000 && !QuestMenu()) {
               Wait(10);
            }
         }
         if(QuestMenu()) {
            Answer(0);
            long l = System.currentTimeMillis();
            while(!QuestMenu() && System.currentTimeMillis() - l <= 8000) {
               Wait(10);
            }
            Answer(1);
            long l2 = System.currentTimeMillis();
            while(!QuestMenu() && System.currentTimeMillis() - l2 <= 8000) {
               Wait(10);
            }
            Answer(0);
            long l3 = System.currentTimeMillis();
            while(GetY() > 700 && System.currentTimeMillis() - l3 <= 15000) {
               Wait(10);
            }
         }
            
      }
          MoveTo(268,643);
          MoveTo(267,634);
          while(!inArea(262,629,267,632)) {
             if(DoorAt(266,633,0) == 2) {
                OpenDoor(266,633,0);
                long l = System.currentTimeMillis();
                while(DoorAt(266,633,0) == 2 && System.currentTimeMillis() - l <= 3000) {
               Wait(10);
            }
         }
         breakWait = false;
         WalkNoWait(264,630);
         long l = System.currentTimeMillis();
         while(!inArea(262,629,267,632) && System.currentTimeMillis() - l <= 3000 && !breakWait) {
            Wait(10);
            if(DoorAt(266,633,0) == 2) {
               breakWait = true;
            }
         }
      }
      while(inArea(262,629,267,632)) {
             if(DoorAt(262,630,1) == 2) {
                OpenDoor(262,630,1);
                long l = System.currentTimeMillis();
                while(DoorAt(262,630,1) == 2 && System.currentTimeMillis() - l <= 3000) {
               Wait(10);
            }
         }
         breakWait = false;
         WalkNoWait(259,628);
         long l = System.currentTimeMillis();
         while(inArea(262,629,267,632) && System.currentTimeMillis() - l <= 3000 && !breakWait) {
            Wait(10);
            if(DoorAt(262,630,1) == 2) {
               breakWait = true;
            }
         }
      }   
          MoveTo(259,628);
          MoveTo(253,618);
          MoveTo(245,610);
          MoveTo(230,625);         
          while(InvCount(372) > 24) {
             int niles = GetNearestNPC(227);
             if(niles != -1 && !QuestMenu()) {
                busy = false;
                TalkToNPC(niles);
                long l = System.currentTimeMillis();
                while(!busy && System.currentTimeMillis() - l <= 4000 && !QuestMenu()) {
               Wait(10);
            }
         }
         if(QuestMenu()) {
            Answer(1);
            long l = System.currentTimeMillis();
            while(!QuestMenu() && System.currentTimeMillis() - l <= 8000) {
               Wait(10);
            }
            Answer(1);
            long l2 = System.currentTimeMillis();
            while(!QuestMenu() && System.currentTimeMillis() - l2 <= 8000) {
               Wait(10);
            }
            Answer(4);
            long l3 = System.currentTimeMillis();
            while(InvCount(372) > 24 && System.currentTimeMillis() - l3 <= 3000) {
               Wait(10);
            }
         }
      }
      MoveTo(234,621);
      MoveTo(245,610);
      MoveTo(253,618);
      MoveTo(259,628);
      while(!inArea(262,629,267,632)) {
             if(DoorAt(266,633,0) == 2) {
                OpenDoor(266,633,0);
                long l = System.currentTimeMillis();
                while(DoorAt(266,633,0) == 2 && System.currentTimeMillis() - l <= 3000) {
               Wait(10);
            }
         }
         breakWait = false;
         WalkNoWait(264,630);
         long l = System.currentTimeMillis();
         while(!inArea(262,629,267,632) && System.currentTimeMillis() - l <= 3000 && !breakWait) {
            Wait(10);
            if(DoorAt(266,633,0) == 2) {
               breakWait = true;
            }
         }
      }
      while(inArea(262,629,267,632)) {
             if(DoorAt(262,630,1) == 2) {
                OpenDoor(262,630,1);
                long l = System.currentTimeMillis();
                while(DoorAt(262,630,1) == 2 && System.currentTimeMillis() - l <= 3000) {
               Wait(10);
            }
         }
         breakWait = false;
         WalkNoWait(268,635);
         long l = System.currentTimeMillis();
         while(inArea(262,629,267,632) && System.currentTimeMillis() - l <= 3000 && !breakWait) {
            Wait(10);
            if(DoorAt(262,630,1) == 2) {
               breakWait = true;
            }
         }
      }
      MoveTo(268,643);
          while(GetY() < 700) {
             int captains[] = { 166,170,171 };
             int captainsId = GetNearestNPC(captains);
             if(captainsId != -1 && !QuestMenu()) {
                busy = false;
                TalkToNPC(captainsId);
                long l = System.currentTimeMillis();
                while(!busy && System.currentTimeMillis() - l <= 4000 && !QuestMenu()) {
               Wait(10);
            }
         }
         if(QuestMenu()) {
            Answer(1);
            long l3 = System.currentTimeMillis();
            while(GetY() < 700 && System.currentTimeMillis() - l3 <= 15000) {
               Wait(10);
            }
         }
            
      }
      MoveTo(341,713);
      MoveTo(348,706);
      MoveTo(354,702);
      MoveTo(361,702);
      MoveTo(369,687);                     
       }
    }
}