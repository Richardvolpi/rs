import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TehCerter extends Script implements ActionListener {
   
    JFrame fmeSettings;
    JPanel pnlSettings;
    JLabel lblCertUncert,lblCertType,lblCertItem;
    JComboBox cmbCertUncert,cmbCertType,cmbCertItem;
    JButton cmdStart,cmdCancel;
   
    int item_to_withdraw = 0;
    int item_to_deposit = 0;
    int cert_mode = 0;
    int npc_id = 0;
   
    int certer_id = 0;
    int Answer1 = 0;
    int Answer2 = 0;
   
    int certers_ids[] = new int[]{225,226,227}; // ores,bars,fish
    int fish_cert_ids[] = new int[]{533,534,535,536};
    int bars_cert_ids[] = new int[]{528,529,530,532,531};
    int ores_cert_ids[] = new int[]{517,518,519,521,520};
    int fish_ids[] = new int[]{373,372,370,339};
    int bars_ids[] = new int[]{170,171,173,152,383};
    int ores_ids[] = new int[]{151,155,153,172,384};
    int banker_id = 95;
   
    boolean run_script = false;
   
    public TehCerter(mudclient ps) {
        super(ps);
    }
   
    public String[] getCommands() {
        return new String[]{"tehcerter"};
    }
   
    public void start(String cmd, String params[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoadDialog();
            }
        });
       
        while(Running()) {
            if(run_script) {
                fmeSettings.dispose();
                RunScript();
            }
        }
        run_script = false;
        Msg("Teh Certer Stopped.");
    }
   
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Start!") {
            run_script = true;
        } else {
            if (e.getActionCommand().equalsIgnoreCase("comboBoxChanged")) {
                cmbCertItem.removeAllItems();
                switch(cmbCertType.getSelectedIndex()) {
                    case 0:
                        cmbCertItem.addItem(makeObj("Iron"));
                        cmbCertItem.addItem(makeObj("Coal"));
                        cmbCertItem.addItem(makeObj("Mithril"));
                        cmbCertItem.addItem(makeObj("Gold"));
                        cmbCertItem.addItem(makeObj("Silver"));
                        break;
                    case 1:
                        cmbCertItem.addItem(makeObj("Iron"));
                        cmbCertItem.addItem(makeObj("Steel"));
                        cmbCertItem.addItem(makeObj("Mithril"));
                        cmbCertItem.addItem(makeObj("Gold"));
                        cmbCertItem.addItem(makeObj("Silver"));
                        break;
                    case 2:
                        cmbCertItem.addItem(makeObj("Lobster"));
                        cmbCertItem.addItem(makeObj("Raw Lobster"));
                        cmbCertItem.addItem(makeObj("Swordfish"));
                        cmbCertItem.addItem(makeObj("Raw Swordfish"));
                        break;
                    default:
                        cmbCertType.setSelectedIndex(0);
                        cmbCertItem.addItem(makeObj("Iron"));
                        cmbCertItem.addItem(makeObj("Coal"));
                        cmbCertItem.addItem(makeObj("Mithril"));
                        cmbCertItem.addItem(makeObj("Gold"));
                        cmbCertItem.addItem(makeObj("Silver"));
                        break;
                }
                SwingUtilities.updateComponentTreeUI(fmeSettings);
            }
            if (e.getActionCommand() == "Cancel") {
                run_script = false;
                fmeSettings.dispose();
            }
        }
    }
   
    private void LoadDialog() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        fmeSettings = new JFrame("Teh_Certer v1");
        pnlSettings =  new JPanel(new GridLayout(4,2));
        lblCertUncert = new JLabel("Action:");
        lblCertType = new JLabel("(Un)Cert type:");
        lblCertItem = new JLabel("(Un)Cert Item:");
        cmbCertUncert = new JComboBox(new String[]{"UnCert","Cert"});
        cmbCertType = new JComboBox(new String[]{"Ores","Bars","Fish"});
        cmbCertItem = new JComboBox(new String[]{"Iron","Coal","Mithril","Gold","Silver"});
        cmdCancel = new JButton("Cancel");
        cmdStart = new JButton("Start!");
        fmeSettings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fmeSettings.setResizable(false);
        cmbCertUncert.setEditable(false);
        cmbCertItem.setEditable(false);
        cmbCertType.setEditable(false);
        cmbCertType.addActionListener(this);
        cmdCancel.addActionListener(this);
        cmdStart.addActionListener(this);
        pnlSettings.add(lblCertUncert);
        pnlSettings.add(cmbCertUncert);
        pnlSettings.add(lblCertType);
        pnlSettings.add(cmbCertType);
        pnlSettings.add(lblCertItem);
        pnlSettings.add(cmbCertItem);
        pnlSettings.add(cmdCancel);
        pnlSettings.add(cmdStart);
        fmeSettings.getRootPane().setDefaultButton(cmdStart);
        fmeSettings.getContentPane().add(pnlSettings, BorderLayout.CENTER);
        fmeSettings.pack();
        fmeSettings.setVisible(true);
    }
   
    private void RunScript() {
        run_script = false;
        Answer1 = cmbCertUncert.getSelectedIndex();
        cert_mode = Answer1;
        npc_id = certers_ids[cmbCertType.getSelectedIndex()];
        Answer2 = cmbCertItem.getSelectedIndex();
        switch (cmbCertType.getSelectedIndex()) {
            case 0:
                if(cert_mode == 1) {
                    item_to_withdraw = ores_ids[Answer2];
                    item_to_deposit = ores_cert_ids[Answer2];
                } else {
                    item_to_withdraw = ores_cert_ids[Answer2];
                    item_to_deposit = ores_ids[Answer2];
                }
                break;
            case 1:
                if(cert_mode == 1) {
                    item_to_withdraw = bars_ids[Answer2];
                    item_to_deposit = bars_cert_ids[Answer2];
                } else {
                    item_to_withdraw = bars_cert_ids[Answer2];
                    item_to_deposit = bars_ids[Answer2];
                }
                break;
            case 2:
                if(cert_mode == 1) {
                    item_to_withdraw = fish_ids[Answer2];
                    item_to_deposit = fish_cert_ids[Answer2];
                } else {
                    item_to_withdraw = fish_cert_ids[Answer2];
                    item_to_deposit = fish_ids[Answer2];
                }
                break;
        }
        Msg("Method: " + cmbCertUncert.getSelectedItem() + ", item - " + cmbCertType.getSelectedItem() + ", " + cmbCertItem.getSelectedItem() + ":" + item_to_withdraw + ":" + item_to_deposit + ", answers - " + Answer1 + ":" + Answer2);
        while(Running()) {
            Msg("Banking...");
            DoBanking();
            while(ObjectAt(219,633) == 64 && Running()) {
                Msg("Opening bank door...");
                AtObject2(219,633);
                Wait(500);
            }
            if(Running())
                WalkEmpty(228,628,230,630);
            Msg("(Un)-Certing...");
            while(((cert_mode == 0 && InvCount() < 25) || (cert_mode == 1  && InvCount() > 1)) && Running()) {
                int pinv = InvCount();
                WaitForNPCMessage(npc_id,10,"Welcome to");
                WaitForQuestMenu();
                Answer(Answer1);
                WaitForQuestMenu();
                if (npc_id == 227 && cert_mode == 0) { // Uncerting fish = backwards
                    if (Answer2 >= 3)
                        Answer(Answer2 - 2);
                    else
                        Answer(Answer2 + 2);
                } else
                    Answer(Answer2);
                WaitForQuestMenu();
                if(cert_mode == 1) {
                    if (InvCount() >= 25)
                        Answer(4);
                    else if (InvCount() >= 20)
                        Answer(3);
                    else if (InvCount() >= 15)
                        Answer(2);
                    else if (InvCount() >= 10)
                        Answer(1);
                    else if (InvCount() >= 5)
                        Answer(0);
                    else break;
                } else {
                    Answer(4);
                }
                WaitFor2ServerMessages(10,"You exchange","You don't");
                while(pinv == InvCount() && Running())
                    Wait(100);
                Wait(1000);
            }
            while(ObjectAt(219,633) == 64 && Running()) {
                Msg("Opening bank door...");
                AtObject2(219,633);
                Wait(500);
            }
            if(Running())
                WalkEmpty(216,634,223,637);
        }
    }
   
    private void DoBanking() {
        if (GetNearestNPC(banker_id) < 0)  {
            Msg("Cannot find banker!");
            return;
        }
        WaitForNPCMessage(banker_id,10,"Good day,");
        WaitForQuestMenu();
        Answer(0);
        while (!Bank() && Running())
            Wait(100);
        if (Bank() && Running()) {
            while(InvCount(item_to_deposit) > 0 && Running()) {
                Deposit(item_to_deposit,1);
                Wait(Rand(100,200));
            }
            while(InvCount(item_to_withdraw) < 30 && Running()) {
                Withdraw(item_to_withdraw,1);
                Wait(Rand(100,200));
            }
        }
        Wait(100);
        CloseBank();
    }
   
    private void WaitForQuestMenu() {
        while (!QuestMenu() && Running())
            Wait(100);
    }
   
    private void WaitForNPCMessage(int type, int time, String message) {
        if(Running()) {
            ResetLastNPCMessage();
            while (LastNPCMessage().indexOf(message) < 0 && Running()) {
                ResetLastServerMessage();
                ResetLastNPCMessage();
                int id = GetNearestNPC(type);
                long T = TickCount();
                TalkToNPC(id);
                while (TickCount() - T < 3000 && LastServerMessage().indexOf("busy") < 0 && LastNPCMessage() == "" && Running())
                    Wait(100);
                if (LastServerMessage().indexOf("busy") < 0) {
                    T = TickCount();
                    if (LastNPCMessage() != null)
                        while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000) && Running())
                            Wait(100);
                }
                Wait(1000);
            }
        }
    }
   
    private void WaitFor2ServerMessages(int time, String msg1, String msg2) {
        if(Running()) {
            ResetLastServerMessage();
            // while (LastServerMessage().indexOf(msg1) < 0 && LastServerMessage().indexOf(msg2) < 0 && Running()) {
            long T = TickCount();
            T = TickCount();
            while (LastServerMessage().indexOf(msg1) < 0 && LastServerMessage().indexOf(msg2) < 0 && TickCount() - T < (time * 1000) && Running())
                Wait(100);
            // }
        }
    }
   
    private void Msg(String msg) {
        if (Running()) {
            DisplayMessage("@gre@SBoT: @whi@" + msg,3);
            Println("SBoT: " + msg.replaceAll("@...@",""));
        }
    }
   
    private Object makeObj(final String item)  {
        return new Object() { public String toString() { return item; } };
    }
}