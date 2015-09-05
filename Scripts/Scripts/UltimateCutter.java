public class UltimateCutter extends Script {
    private int treeid;
    private int logsid;
    private int startx;
    private int starty;
    private int sleepingbag = 1263;
    private int tinderbox = 166;
    private int fireid = 97;
    private int mapw = 32;
    private int maph = 32;
    private long start_time = 0;
    private long start_woodcutxp ;
    private long start_firemakexp;
    private int start_woodcutlvl;
    private int start_firemakelvl;
    private int logs_light = 0;
    public UltimateCutter(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"cutter"};
    }
    public void start(String command, String params[]) {
        Msg("Ultimate Cutter @red@- @ran@eXemplar");
        if (params != null) {
            if(params.length >= 2) {
                treeid = Integer.parseInt(params[0]);
                logsid = Integer.parseInt(params[1]);
                if (params.length == 4) {
                    mapw = Integer.parseInt(params[2]);
                    maph = Integer.parseInt(params[3]);
                    if(mapw < 1) {
                        mapw = 32;
                        Msg("Invalid map_width specified, using default " + mapw);
                    }
                    if(maph < 1) {
                        mapw = 32;
                        Msg("Invalid map_height specified, using default " + mapw);
                    }
                }
                Msg("Using map bounds " + mapw + "," + maph);
            } else {
                ShowUsage();
                return;
            }
            if (FindInv(sleepingbag) < 0) {
                Msg("You must have a sleeping bag in your inv!");
                return;
            }
            if (FindInv(tinderbox) < 0) {
                Msg("You must have a tinderbox in your inv!");
                return;
            }
            startx = GetX();
            starty = GetY();
            start_time = TickCount();
            while(Running() == true) {
                CutTrees();
                LightLogs();
                // PrintStats();
            }
        } else {
            ShowUsage();
            return;
        }
    }
    private void ShowUsage() {
        Msg("Usage: /run cutter tree_id@logs_id");
        Msg("Or: /run cutter tree_id@logs_id@map_width@map_height");
    }
    private void Msg(String msg) {
        if (Running()) {
            DisplayMessage("@gre@SBoT: @whi@" + msg,3);
            Println("SBoT: " + msg.replaceAll("@...@",""));
        }
    }
    private void CheckLocation() {
        if(Running() && (GetX() > startx + mapw / 2 || GetX() < startx - mapw / 2 || GetY() > starty + maph / 2 || GetY() < starty - maph / 2)) {
            Msg("Outside map bounds, moving back...");
            ForceWalk(startx,starty);
        }
    }
    private void CutTrees() {
        Msg("Cutting trees...");
        while(InvCount() < 30 && Running()) {
            CheckLocation();
            CheckSleep();
            int next_tree[] = GetNearestObject(treeid);
            if (next_tree != null && next_tree.length > 0) {
                AtObject(next_tree[0],next_tree[1]);
                WaitFor2ServerMessages(10,"You slip","You get");
            } else {
                Msg("Waiting for trees respawn...");
                while(GetNearestObject(treeid)[0] < 0 && Running())
                    Wait(100);
            }
        }
        if(InvCount() == 30)
            Msg("Inventory full");
    }
    private void CheckSleep() {
        if(Fatigue() >= 95 && Running()) {
            Msg("Sleeping...");
            while(!Sleeping() && Running()) {
                Use(FindInv(sleepingbag));
                long Time = TickCount();
                while(!Sleeping() && TickCount() - Time < 3000 && Running())
                    Wait(1);
            }
            Msg("Waiting for sleep word...");
            while(Sleeping() && Running()) {
                Beep();
                Wait(1000);
            }
            Msg("Finished sleeping");
        }
    }
    private void LightLogs() {
        Msg("Lighting logs...");
        if (InvCount(logsid) < 0) {
            Msg("No logs with id " + logsid + " in inv,");
            return;
        }
        while(InvCount(logsid) > 0 && Running()) {
            int dist = 1;
            while(ObjectAt(GetX(),GetY()) == fireid && Running()) {
                ForceWalk(Rand(GetX() - dist, GetX() + dist), Rand(GetY() - dist, GetY() + dist));
                CheckLocation();
                dist++;
            }
            while(!ItemAt(GetX(),GetY(),logsid) && Running()) {
                Drop(FindInv(logsid));
                long T = TickCount();
                while(TickCount() - T <= 3000 && !ItemAt(GetX(),GetY(),logsid) && Running())
                    Wait(100);
            }
            while(ObjectAt(GetX(),GetY()) != fireid && Running()) {
                UseOnItem(GetX(),GetY(),logsid,FindInv(tinderbox));
                long T = TickCount();
                while(TickCount() - T <= 3000 && ObjectAt(GetX(),GetY()) != fireid && Running())
                    Wait(100);
            }
        }
        if (InvCount(logsid) <= 0)
            Msg("No more logs in inv");
    }
    private void WaitFor2ServerMessages(int time, String msg1, String msg2) {
        if(Running()) {
            ResetLastServerMessage();
            // while (LastServerMessage().indexOf(msg1) < 0 && LastServerMessage().indexOf(msg2) < 0 && Running()) {
            long T = TickCount();
            T = TickCount();
            while ((LastServerMessage().indexOf(msg1) < 0 || LastServerMessage().indexOf(msg2) < 0) && TickCount() - T < (time * 1000) && Running())
                Wait(100);
            // }
        }
    }
}