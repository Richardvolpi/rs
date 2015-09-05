import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AnywhereMiner extends Script implements ActionListener {
    
    JFrame fmeSettings;
    JPanel pnlSettings;
    JLabel lblMine;
    JLabel lblRock;
    JLabel lblOre;
    JLabel lblFatigue;
    JLabel lblPickOres;
    JLabel lblPickGems;
    JLabel lblAutologin;
    JLabel lblModProtection;
    JLabel lblMineAction;
    JComboBox cmbMineType;
    JComboBox cmbMineAction;
    JTextField txtRockId;
    JTextField txtOreId;
    JTextField txtFatigue;
    JCheckBox chkPickOres;
    JCheckBox chkPickGems;
    JCheckBox chkAutologin;
    JCheckBox chkModProtection;
    JButton cmdStart;
    JButton cmdCancel;
    
    int banker_id = 95;
    int fat_level = 95;
    int sleepingbag_id = 1263;
    
    int copper_ore = 150;
    int iron_ore = 151;
    int tin_ore = 202;
    int gold = 152;
    int silver = 383;
    int mithril_ore = 153;
    int coal = 155;
    int adamantite_ore = 154;
    
    int uncut_diamond = 157;
    int uncut_ruby = 158;
    int uncut_emerald = 159;
    int uncut_sapphire = 160;
    
    int ores[] = new int[]{copper_ore,iron_ore,tin_ore,gold,silver,mithril_ore,coal,adamantite_ore};
    int gems[] = new int[]{uncut_diamond,uncut_ruby,uncut_emerald,uncut_sapphire};
    
    boolean bank_ore = false;
    boolean run_script = false;
    boolean mod_protection = false;
    
    boolean finished_mining = false;
    String[] messages;
    
    public AnywhereMiner(mudclient ps) {
        super(ps);
    }
    
    public String[] getCommands() {
        return new String[]{"anywhereminer"};
    }
    
    public void start(String cmd, String params[]) {
        Msg("@red@Anywhere @whi@Miner + Banker - by @ran@e@ran@X@ran@e@ran@m@ran@p@ran@l@ran@a@ran@r");
        LoadDialog();
        run_script = false;
        while(!run_script && Running())
            Wait(100);
        if(run_script) {
            Msg("Running mining script..");
            RunScipt();
            Msg("Mining script stopped.");
        }
        Msg("@red@Anywhere @whi@Miner + Banker - by @ran@e@ran@X@ran@e@ran@m@ran@p@ran@l@ran@a@ran@r @whi@- @red@Stopped.");
    }

    public void Msg(String msg) {
        DisplayMessage("@gre@SBoT: @whi@" + msg,3);
        Println("SBoT: " + msg.replaceAll("@...@",""));
    }
    
    public void LoadDialog() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }
        fmeSettings = new JFrame("Mine & Bank, Anywhere!");
        pnlSettings =  new JPanel(new GridLayout(10,2));
        lblMine =new JLabel("Mine type:");
        lblRock = new JLabel("Rock ID:");
        lblOre = new JLabel("Ore ID:");
        lblFatigue = new JLabel("Fatigue level:");
        lblPickOres = new JLabel("Pick ores?");
        lblPickGems = new JLabel("Pick Gems?");
        lblAutologin = new JLabel("Autologin?");
        lblModProtection = new JLabel("Mod Protection?");
        lblMineAction = new JLabel("Mine Action:");
        chkModProtection = new JCheckBox();
        chkModProtection.setSelected(true);
        chkPickGems = new JCheckBox();
        chkPickOres = new JCheckBox();
        chkAutologin = new JCheckBox();
        chkAutologin.setSelected(true);
        cmbMineType = new JComboBox(new String[]{"PowerMine","Mine+Bank"});
        cmbMineAction = new JComboBox(new String[]{"AtObject","AtObject2"});
        txtRockId = new JTextField("0");
        txtOreId = new JTextField("0");
        txtFatigue = new JTextField("95");
        cmdCancel = new JButton("Cancel");
        cmdStart = new JButton("Start!");
        fmeSettings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fmeSettings.setResizable(true);
        cmdCancel.addActionListener(this);
        cmdStart.addActionListener(this);
        pnlSettings.add(lblMine);
        pnlSettings.add(cmbMineType);
        pnlSettings.add(lblMineAction);
        pnlSettings.add(cmbMineAction);
        pnlSettings.add(lblRock);
        pnlSettings.add(txtRockId);
        pnlSettings.add(lblPickOres);
        pnlSettings.add(chkPickOres);
        pnlSettings.add(lblOre);
        pnlSettings.add(txtOreId);
        pnlSettings.add(lblPickGems);
        pnlSettings.add(chkPickGems);
        pnlSettings.add(lblFatigue);
        pnlSettings.add(txtFatigue);
        pnlSettings.add(lblAutologin);
        pnlSettings.add(chkAutologin);
        pnlSettings.add(lblModProtection);
        pnlSettings.add(chkModProtection);
        pnlSettings.add(cmdCancel);
        pnlSettings.add(cmdStart);
        fmeSettings.getRootPane().setDefaultButton(cmdStart);
        fmeSettings.getContentPane().add(pnlSettings, BorderLayout.CENTER);
        fmeSettings.pack();
        fmeSettings.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Start!")
            run_script = true;
        else {
            EndScript();
            fmeSettings.dispose();
        }
    }
    
    public String getStr(int[] a) {
        if(a == null)
            return "[]";
        if(a.length < 1)
            return "[]";
        String s = "[";
        for(int i = 0; i < a.length; i++) {
            s += a[i];
            if(i < a.length - 1)
                s += ",";
        }
        s += "]";
        return s;
    }
    
    public void RunScipt() {
        String[] tmp = txtRockId.getText().split(",");
        int rock_ids[] = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            rock_ids[i] = Integer.parseInt(tmp[i]);
        tmp = txtOreId.getText().split(",");
        int ore_ids[] = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            ore_ids[i] = Integer.parseInt(tmp[i]);
        boolean pick_ores = chkPickOres.isSelected();
        boolean pick_gems = chkPickGems.isSelected();
        boolean atobject = (cmbMineAction.getSelectedIndex() == 0);
        bank_ore = (cmbMineType.getSelectedIndex() == 1);
        fat_level = Integer.parseInt(txtFatigue.getText());
        if (fat_level > 95 || fat_level < 5)
            fat_level = 95;
        Msg("Mining rocks " + getStr(rock_ids) + ", ore " + getStr(ore_ids) + ", in " + cmbMineType.getSelectedItem() + " mode. " + (pick_ores ? "Picking ores." : "Not picking ores.") + " Fatigue level " + fat_level);
        Msg("AutoLogin: " + (chkAutologin.isSelected() ? "enabled." : "disabled."));
        mod_protection = chkModProtection.isSelected();
        Msg("Mod Protection: " + (mod_protection ? "enabled." : "disabled."));
        Msg("Mining action: " + cmbMineAction.getSelectedItem().toString());
        if(chkAutologin.isSelected())
            EnableAutoLogin();
        else
            DisableAutoLogin();
        String msgs = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("messages.txt")));
            while (in.ready() && Running())
                msgs += in.readLine() + "\n";
            in.close();
        } catch (Exception e) {
            msgs = "@gam@There is currently no ore available in this rock\n@gam@You manage to obtain some\n@gam@You only succeed in scratching the rock\n@gam@A few lumps of uninteresting rock break off\n@gam@You fail to make any real impact on the rock\n@gam@You slip and fail to hit the rock";
        }
        messages = msgs.split("\n");
        fmeSettings.dispose();
        
        while(Running()) {
            if (bank_ore && InvCount() == 30 && Running()) {
                if(Running())
                    Msg("Inventory full,");
                WalkToBank(1);
                if(!bank_ore)
                    break;
                DoBanking(ore_ids);
                WalkToBank(0);
                if(Running())
                    Msg("Mining...");
            }
            CheckSleep();
            for(int i = 0; i < rock_ids.length; i++) {
                int[] theRock = GetNearestObject(rock_ids[i]);
                if (theRock[0] > 0 && Running() && !IsWalking() && CanReachAround(theRock[0],theRock[1])) {
                    finished_mining = false;
                    if(atobject)
                        AtObject(theRock);
                    else
                        AtObject2(theRock);
                    long t = TickCount();
                    while(Running() && TickCount() - t < Rand(2000,2500) && !finished_mining)
                        Wait(100);
                }
            }
            if(pick_ores) {
                for(int i = 0; i < ore_ids.length; i++) {
                    while(GetNearestItem(ore_ids[i])[0] > 0 && Running() && InvCount() < 30) {
                        int[] theItem = GetNearestItem(ore_ids[i]);
                        if(CanReach(theItem[0],theItem[1])) {
                            TakeItem(theItem[0], theItem[1], theItem[2]);
                            Wait(Rand(1000,2000));
                        }
                    }
                }
            }
            if (pick_gems) {
                for(int i = 0;i < gems.length;i++) {
                    while(GetNearestItem(gems[i])[0] > 0 && Running() && InvCount() < 30) {
                        int[] theGem = GetNearestItem(gems[i]);
                        if(CanReach(theGem[0],theGem[1])) {
                            TakeItem(theGem[0], theGem[1], theGem[2]);
                            Wait(Rand(1000,2000));
                        }
                    }
                }
            }
            Wait(100);
        }
    }
    
    public boolean CanReachAround(int x, int y) {
        for(int i = -1; i < 2; i++)
            for(int j = -1; j < 2; j++)
                if(CanReach(x - i, y - j))
                    return true;
        return false;
    }
    
    public void DoBanking(int in_ores[]) {
        if(Running())
            Msg("Depositing ores & gems...");
        while (!Bank() && Running()) {
            if(GetNearestNPC(banker_id) < 0) {
                Msg("Cannot find banker! PANIC MAENZ!!!");
                EndScript();
                DisableAutoLogin();
                Logout();
                return;
            }
            ResetLastNPCMessage();
            while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                TalkToNPC(GetNearestNPC(banker_id));
                Wait(1);
                long Time = TickCount();
                while (TickCount() - Time <= Rand(500,1000) && (!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running() && LastNPCMessage().indexOf("busy") < 0)
                    Wait(1);
            }
            long tt = TickCount();
            while(!QuestMenu() && TickCount() - tt < 5000 && Running())
                Wait(1);
            Answer(0);
            long Time = TickCount();
            while (TickCount() - Time <= Rand(6000,8000) && !Bank() && Running())
                Wait(1);
        }
        if (Bank() && Running()) {
            for (int i = 0;i < ores.length;i++) {
                while(InvCount(ores[i]) > 0 && Running() && Bank()) {
                    Deposit(ores[i],1);
                    Wait(Rand(100,200));
                }
            }
            for (int i = 0;i < gems.length;i++) {
                while(InvCount(gems[i]) > 0 && Running() && Bank()) {
                    Deposit(gems[i],1);
                    Wait(Rand(100,200));
                }
            }
            for(int i = 0; i < in_ores.length; i++)
                while(InvCount(in_ores[i]) > 0 && Running() && Bank()) {
                    Deposit(in_ores[i],1);
                    Wait(Rand(100,200));
                }
        }
        Wait(Rand(300,500));
        CloseBank();
    }
    
    public void WalkToBank(int way) {
        if(!Running())
            return;
        String fName = "";
        if (way == 1) {
            Msg("Walking to bank...");
            fName = "walktobank.txt";
        } else {
            Msg("Walking from bank to ores...");
            fName = "walkfrombank.txt";
        }
        try {
            File sFile = new File(fName);
            if (!sFile.exists()) {
                Msg("Error: Cannot find " + fName + ", not banking ore.");
                bank_ore = false;
                return;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fName)));
            String cmd;
            while (in.ready() && Running()) {
                cmd = in.readLine();
                ParseCommand(cmd);
            }
            in.close();
        }
        catch (Exception e) {
            Msg("Error reading " + fName + ": " + e.toString());
        }
    }
    
    public void ParseCommand(String cmd) {
        if (cmd.indexOf("(") < 0 && cmd.indexOf(")") < 0) {
            Msg("Invalid command: " + cmd);
            return;
        }
        String dothing = cmd.substring(0,cmd.indexOf("("));
        String params[] = cmd.substring(cmd.indexOf("(") + 1,cmd.indexOf(")")).split(",");
        try {
            if (dothing.equalsIgnoreCase("Walk")) {
                Println("Walking to " + params[0] + "," + params[1]);
                ForceWalk(Integer.parseInt(params[0]),Integer.parseInt(params[1]));
                Wait(Rand(200,700));
                return;
            }
            if (dothing.equalsIgnoreCase("OpenBankDoor")) {
                Println("Opening bank door at " + params[0] + "," + params[1]);
                while (ObjectAt(Integer.parseInt(params[0]),Integer.parseInt(params[1])) == 64 && Running()) {
                    AtObject(Integer.parseInt(params[0]),Integer.parseInt(params[1]));
                    Wait(Rand(500,1500));
                }
                return;
            }
            if (dothing.equalsIgnoreCase("OpenDoor")) {
                Println("Opening door at " + params[0] + "," + params[1] + "," +params[2]);
                while (DoorAt(Integer.parseInt(params[0]),Integer.parseInt(params[1]),Integer.parseInt(params[2])) == 2 && Running()) {
                    OpenDoor(Integer.parseInt(params[0]),Integer.parseInt(params[1]),Integer.parseInt(params[2]));
                    Wait(Rand(500,1500));
                }
                return;
            }
            if (dothing.equalsIgnoreCase("ClimbLadder")) {
                Println("Climbing ladder at " + params[0] + "," + params[1]);
                int sx = GetX();
                int sy = GetY();
                while(GetDistance(sx,sy,GetX(),GetY()) < 32 && Running()) {
                    AtObject(Integer.parseInt(params[0]),Integer.parseInt(params[1]));
                    Wait(Rand(500,1500));
                }
                return;
            }
            if (dothing.equalsIgnoreCase("TalkNPC")) {
                Println("Talking to npc " + params[0]);
                if(GetNearestNPC(Integer.parseInt(params[0])) < 0) {
                    Println("Cannot find npc " + params[0]);
                    EndScript();
                    Quit();
                    return;
                }
                ResetLastNPCMessage();
                while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                    TalkToNPC(GetNearestNPC(Integer.parseInt(params[0])));
                    Wait(1);
                    long Time = TickCount();
                    while (TickCount() - Time <= Rand(500,1000) && (!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running() && LastServerMessage().indexOf("busy") < 0)
                        Wait(1);
                }
                return;
            }
            if (dothing.equalsIgnoreCase("TalkNPCWait")) {
                Println("Talking to npc " + params[0]);
                if(GetNearestNPC(Integer.parseInt(params[0])) < 0) {
                    Println("Cannot find npc " + params[0]);
                    EndScript();
                    Quit();
                    return;
                }
                ResetLastNPCMessage();
                while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                    TalkToNPC(GetNearestNPC(Integer.parseInt(params[0])));
                    Wait(1);
                    long Time = TickCount();
                    while (TickCount() - Time <= Rand(500,1000) && (!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running() && LastServerMessage().indexOf("busy") < 0)
                        Wait(1);
                }
                Println("Waiting for npc message: " + params[1]);
                while(LastNPCMessage().indexOf(params[1]) < 0 && Running())
                    Wait(1);
                return;
            }
            if (dothing.equalsIgnoreCase("WaitQuestMenu")) {
                Println("Waiting for quest menu");
                while(Running() && !QuestMenu())
                    Wait(1);
                return;
            }
            if (dothing.equalsIgnoreCase("WaitNPCMessage")) {
                Println("Waiting for npc message " + params[0]);
                while(Running() && LastNPCMessage().indexOf(params[0]) < 0)
                    Wait(1);
                return;
            }
            if (dothing.equalsIgnoreCase("WaitServerMessage")) {
                Println("Waiting for server message " + params[0]);
                while(Running() && LastServerMessage().indexOf(params[0]) < 0)
                    Wait(1);
                return;
            }
            if (dothing.equalsIgnoreCase("Answer")) {
                Println("Answering " + params[0]);
                if(QuestMenu())
                    Answer(Integer.parseInt(params[0]));
                else {
                    Println("No quest menu to answer " + params[0]);
                    EndScript();
                    Quit();
                }
                return;
            }
            if (dothing.equalsIgnoreCase("AnswerStr")) {
                boolean answered = false;
                Println("Answering string " + params[0]);
                if(QuestMenu()) {
                    for(int i = 0; i < GetAnswerCount(); i++)
                        if(GetAnswer(i).toLowerCase().indexOf(params[0]) >= 0) {
                            Answer(Integer.parseInt(params[0]));
                            answered = true;
                        }
                }
                else {
                    Println("No quest menu to answer string " + params[0]);
                    EndScript();
                    Quit();
                }
                if(!answered) {
                    Println("Can't find answer string " + params[0]);
                    EndScript();
                    Quit();
                }
                return;
            }
            Msg("Invalid command: " + cmd);
        } catch (Exception e) {
            Println("Error executing command " + cmd);
            Println(e.toString());
            EndScript();
            Quit();
        }
    }
    
    private void CheckSleep() {
        if(Fatigue() >= fat_level && Running()) {
            Msg("Sleeping...");
            Wait(Rand(1000,2000));
            while(!Sleeping() && Running()) {
                Use(FindInv(sleepingbag_id));
                long Time = TickCount();
                while(!Sleeping() && TickCount() - Time < 3000 && Running())
                    Wait(1);
            }
            Msg("Waiting for sleep word...");
            while(Sleeping() && Running()) {
                long T = TickCount();
                while(Sleeping() && Running() && TickCount() - T < (Rand(3,4) * 60000))
                    Wait(1000);
                if(Sleeping() && Running())
                    SleepWord();
            }
            Wait(Rand(1000,2000));
            Msg("Finished sleeping");
        }
    }
    
    public void ServerMessage(String message) {
        if(messages == null || !Running())
            return;
        if(messages.length <= 0)
            return;
        for(int i = 0; i < messages.length; i++)
            if(message.indexOf(messages[i]) >= 0) {
                finished_mining = true;
                return;
            }
    }
    
    public void ChatMessage(String message) {
        if (Running() && mod_protection) {
            Msg("Anti-Mod protection activated,");
            Msg("Chat recieved: " + message);
            Wait(Rand(4000,5000));
            EndScript();
            DisableAutoLogin();
            Logout();
        }
    }
    
    public void TradeRequest(int PlayerID) {
        if (Running() && mod_protection) {
            Msg("Anti-Mod protection activated,");
            Msg("Trade recieved from: " + PlayerID);
            Wait(Rand(4000,5000));
            EndScript();
            DisableAutoLogin();
            Logout();
        }
    }
}