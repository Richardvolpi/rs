public class GuildMine_v9 extends Script {
    public GuildMine_v9(mudclient mich) {
        super(mich);
    }
    public String[] getCommands()
    {
        return (new String[] {
            "michgm9"
        });
    }
    public void DepositEverything() {
       int i3 = 1;
       while(i3 < 1289 && Bank()) {
          if(InvCount(i3) > 0 && Bank()) {
             BreakDeposit = false;
             if(!BreakDeposit) {
                if(i3 >= 1258 && i3 <= 1263 || i3 == 156) {
                   BreakDeposit = true;
                }
             }
             if(!BreakDeposit) {
                int i4 = 0;
            int i5 = InvCount(i3);
                while(i5 >= i4 && Bank()) {
                   Deposit(i3,1);
                   i4 += 1;
                }
             }
          }
          i3 += 1;
       }
    }
    public boolean CoordsIn(int x1,int y1,int x2,int y2) {
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
    public boolean stopThis;      
    public boolean BankerBusy;
    public boolean StartedMining;
    public boolean FoundGem;
    public boolean Slip;
    public boolean NoOre;
    public boolean Scratched;
    public boolean BreakWait;
    public boolean BreakDeposit;
    public boolean Sleep;
    public void ServerMessage(String s) {
         if(s.indexOf("busy") > 0) {
            BankerBusy = true;
         }
         if(s.indexOf("swing") > 0) {
               StartedMining = true;
          }
          if(s.indexOf("slip") > 0) {
            Slip = true;
         }
         if(s.indexOf("available") > 0) {
               NoOre = true;
          }
          if(s.indexOf("found") > 0) {
               FoundGem = true;
          }
          if(s.indexOf("scratching") > 0) {
               Scratched = true;
          }
          if(s.indexOf("tired") > 0) {
               Sleep = true;
          }
    }
    public void start(String s, String as[]) {
       int startMiningXp = GetExperience(14);
       int xpGained = 0;
       int minedSoFar = 0;
       DisplayMessage("@red@GuildMine @ora@>> @whi@Started!",3);
       Sleep = false;
   while(Running()) {
                if(InvCount() > 2 && CoordsIn(280,564,286,573)) {
                    ResetLastNPCMessage();
                    while(LastNPCMessage().indexOf("Certainly") < 0) {
                       while(LastNPCMessage().indexOf("Good day") < 0 && !QuestMenu()) {
                            boolean breakWait = false;
                  ResetLastServerMessage();
                  int Id = GetNearestNPC(95);
                  TalkToNPC(Id);
                  long l = System.currentTimeMillis();
                  while(System.currentTimeMillis() - l <= 6000 && !breakWait && !QuestMenu()) {
                      Wait(5);
                      if(LastServerMessage().indexOf("busy") > 0) {
                         ResetLastServerMessage();
                      breakWait = true;
                      }
                  }
                  if(LastServerMessage().indexOf("busy") > 0) {
                      ResetLastServerMessage();
                      while(LastNPCMessage().indexOf("Good day") < 0) {
                     ResetLastNPCMessage();
                     Id = GetNearestNPC(95);
                     TalkToNPC(Id);   
                     WaitForServerMessage(200);
                      }
                      if(LastNPCMessage().indexOf("Good day") > 0) {
                     ResetLastNPCMessage();
                     long l2 = System.currentTimeMillis();
                     while(System.currentTimeMillis() - l2 <= 6000 && !QuestMenu()) {
                              Wait(5);
                     }
                      }
                       }
                   }     
                   if(QuestMenu()) {
                  Answer(0);
                  long l = System.currentTimeMillis();
                  while(!Bank() && System.currentTimeMillis() - l <= 6000) {
                      Wait(5);
                  }
                  if(Bank()) {
                 DepositEverything();
                 DisplayMessage("inBank = "+BankCount(155)+", minedSoFar = "+minedSoFar+", xpGained = "+xpGained,3);
                 CloseBank();
             }
                   }   
               }
           }
      while(!CoordsIn(272,563,277,567) && GetY() < 3000) {
         if(ObjectAt(287,571) == 64 && CoordsIn(280,564,286,573)) {
            AtObject(287,571);
            long l = System.currentTimeMillis();
            while(ObjectAt(287,571) == 64 && System.currentTimeMillis() - l <= 2400) {
               Wait(100);
            }
         }
         if(DoorAt(274,563,0) == 2 && GetX() <= 277) {
            OpenDoor(274, 563, 0);
            long l = System.currentTimeMillis();
            while(DoorAt(274,563,0) == 2 && System.currentTimeMillis() - l <= 2400) {
               Wait(100);
            }
         }
         if(GetX() > 277) {
            BreakWait = false;
            WalkNoWait(272,562);
            long l = System.currentTimeMillis();
            while(GetX() > 277 && System.currentTimeMillis() - l <= 30000 && !BreakWait) {
               Wait(100);
               if(ObjectAt(287, 571) == 64 && CoordsIn(280,564,286,573)) {
                  BreakWait = true;
               }
            }
         }
         if(GetX() <= 277) {
            BreakWait = false;
            WalkNoWait(274,565);
            long l = System.currentTimeMillis();
            while(!CoordsIn(272,563,277,567) && !BreakWait && System.currentTimeMillis() - l <= 10000) {
               Wait(100);
               if(DoorAt(274,563,0) == 2 && GetX() <= 277) {
                  BreakWait = true;
               }
            }
         }   
      }
      while(GetY() < 3000) {
                   AtObject(274,566);
                   long l = System.currentTimeMillis();
                   while(GetY() < 3000 && System.currentTimeMillis() - l <= 10000) {
                         Wait(100);
                      }
               }
               while(InvCount() < 30 && GetY() > 3000 && Running()) {
                  int RT[] = { 111,110 };
                  int RC[] = GetNearestObject(RT);
                  if(Fatigue() < 93 && ObjectAt(RC[0],RC[1]) >= 107 && !Sleep) {
                BreakWait = false;
                StartedMining = false;
                FoundGem = false;
                if(RC[1] < 3386) {
                   int Check = 1350;
                   int CurrentX = GetX();
                   int CurrentY = GetY();
                   long t = TickCount();
                   WalkNoWait(271,3396);
                   while(CurrentX == GetX() && CurrentY == GetY() && TickCount() - t <= Check) {
                       Wait(10);
                   }       
                   if(TickCount() - t <= Check) {
                       long l = System.currentTimeMillis();
                       while(!BreakWait && System.currentTimeMillis() - l <= 12000) {
                      Wait(100);
                      int RT2[] = { 111,110 };
                               int RC2[] = GetNearestObject(RT);
                               if(RC[0] != RC2[0] && RC[1] != RC2[1]) {
                                  BreakWait = true;
                               }
                               if(System.currentTimeMillis() - l >= Check) {
                                  if(GetX() == CurrentX && CurrentY == GetY()) {
                                     BreakWait = true;
                                  }
                                  Check += 700;
                                  CurrentX = GetX();
                                  CurrentY = GetY();
                               }
                                }
                            }   
                }            
                if(!StartedMining && ObjectAt(RC[0],RC[1]) != 98 && Fatigue() < 93 && !BreakWait && !FoundGem) {
                   int Check = 1350;
                   int CurrentX = GetX();
                   int CurrentY = GetY();
                   long t = TickCount();
                   AtObject(RC[0],RC[1]);
                   while(CurrentX == GetX() && CurrentY == GetY() && TickCount() - t <= Check) {
                       Wait(10);
                   }
                   if(TickCount() - t <= Check) {
                            long l = System.currentTimeMillis();
                             while(ObjectAt(RC[0],RC[1]) != 98 && System.currentTimeMillis() - l <= 20000 && !BreakWait && !StartedMining && !FoundGem) {
                               Wait(100);
                               if(System.currentTimeMillis() - l >= Check) {
                                  if(GetX() == CurrentX && CurrentY == GetY()) {
                                     BreakWait = true;
                                  }
                                  Check += 700;
                                  CurrentX = GetX();
                                  CurrentY = GetY();
                               }
                               int RT2[] = { 111,110 };
                               int RC2[] = GetNearestObject(RT);
                               if(RC[0] != RC2[0] && RC[1] != RC2[1]) {
                                  BreakWait = true;
                               }
                                  }
                            }
                      }
                      while(LastServerMessage().indexOf("swing") > 0) {
                               stopThis = false;
                               long t3 = TickCount();
                               while(TickCount() - t3 <= 10000 && !stopThis) {
                              Wait(10);
                              if(LastServerMessage().indexOf("swing") < 0) {
                                  if(ObjectAt(RC[0],RC[1]) < 100) {
                                      stopThis = true;
                                  }
                              }
                              if(LastServerMessage().indexOf("slip") > 0) {
                                  stopThis = true;
                              }
                              if(LastServerMessage().indexOf("found") > 0) {
                                  stopThis = true;
                              }
                              if(LastServerMessage().indexOf("available") > 0) {
                                  stopThis = true;
                              }
                          }
                      }                           
                  }
                  if(Fatigue() >= 80 && !Sleep) {
                     if(!Sleeping()) {
                        Sleep = false;
                        Use(FindInv(1263));
                        Wait(2000);
                     }
                     while(Sleeping()) {
                        Wait(100);
                     }
                  }
               }
               minedSoFar = minedSoFar + InvCount(155);
               xpGained = GetExperience(14) - startMiningXp;
               while(GetY() > 3000) {
                  AtObject(274,3398);
                   long l = System.currentTimeMillis();
                   while(GetY() > 3000 && System.currentTimeMillis() - l <= 15000) {
                         Wait(100);
                      }
               }
               while(!CoordsIn(280,564,286,573) && GetY() < 3000) {
         if(ObjectAt(287,571) == 64 && GetX() == 287) {
            AtObject(287,571);
            long l2 = System.currentTimeMillis();
            while(ObjectAt(287,571) == 64 && System.currentTimeMillis() - l2 <= 2400) {
               Wait(100);
            }
         }
         if(DoorAt(274,563,0) == 2 && CoordsIn(272,563,277,567)) {
            OpenDoor(274, 563, 0);
            long l2 = System.currentTimeMillis();
            while(DoorAt(274,563,0) == 2 && System.currentTimeMillis() - l2 <= 2400) {
               Wait(100);
            }
         }
         if(GetX() != 287) {
            BreakWait = false;
            WalkNoWait(287,574);
            long l = System.currentTimeMillis();
            while(GetX() != 287 && !BreakWait && System.currentTimeMillis() - l <= 30000) {
               Wait(100);
               if(DoorAt(274,563,0) == 2 && CoordsIn(272,563,277,567)) {
                  BreakWait = true;
               }
            }
         }
         if(GetX() == 287) {
            BreakWait = false;
            WalkNoWait(284,569);
            long l = System.currentTimeMillis();
            while(GetX() == 287 && !BreakWait && System.currentTimeMillis() - l <= 10000) {
               Wait(100);
               if(ObjectAt(287,571) == 64) {
                  BreakWait = true;
               }
            }
         }   
      }      
   }
    }
}