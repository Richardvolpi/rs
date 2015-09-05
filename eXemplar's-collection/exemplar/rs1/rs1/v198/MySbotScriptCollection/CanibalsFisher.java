import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class CanibalsFisher extends Script implements ActionListener {
    JFrame reportFrame;
    JPanel reportPanel;
    JLabel fishModeLabel, fishLabel, emptylabel1, R_option, R_minutes, R_xp, R_lvl, R_fished, R_slept, R_empty;
    Graphics g;
    JFrame fishFrame;
    JPanel fishPanel;
    JButton save;
    JComboBox fishMode, fish ;
    Thread reportThread;
    
    String Fish = "null";
    String option = "null";
    public boolean sleep = false;
    public int startxp = 0;
    public int startlvl = 0;
    public int slept = 0;
    public int fishes = 0;
    public long starttime,minutes;
    public int xp,lvl;
    boolean run_script = false;
    
    public CanibalsFisher(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"fish"};
    }
    public void ServerMessage(String message) {
        if (message.equals("@gam@You are too tired to catch this fish"))
            sleep = true;
        if (message.equals("@gam@You wake up - feeling refreshed"))
        {slept++;
         DisplayReport();}
        if (message.indexOf("@gam@You catch a ")>= 0)
        {fishes++;
         DisplayReport();}
    }
    public void KeyPressed(int id) {
        if (id == 1010) {
            AddSettings();
        }
    }
    
    
    public void start(String command, String parameter[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AddSettings();
            }
        });
        while(!run_script && Running())
            Wait(100);
        if(run_script)
            RunScriptor();
    }
    public void RunScriptor() {
        fishFrame.dispose();
        DisplayMessage("@gre@Kamaraja fisher by @red@Canibal", 3);
        Wait(700);
        DisplayMessage("This system is DOS operated so all the info will be shown there",3);
        Wait(700);
        DisplayMessage("You can now press F11 to go into graphics off mode",3);
        long time = System.currentTimeMillis(); starttime = time;
        startlvl=GetStat(10);
        startxp = GetExperience(10);
        SetupReport();
        DisplayReport();
        Println("--------------------------------------------");
        Println("Kamaraja Fisher started!");
        Println("--------------------------------------------");
        while (Running()) {
            while (Running() == true && InvCount() < 30) {
                if (Fish.equalsIgnoreCase("Lobster")) {
                    FishLobster();
                    DisplayReport();
                }
                
                if (Fish.equalsIgnoreCase("Swordfish")) {
                    FishSwordfish();
                    DisplayReport();
                }
                if (Fish.equalsIgnoreCase("Tuna")) {
                    FishTuna();
                    DisplayReport();
                }
            }
            if (InvCount() == 30 && Running()) {
                while (Fish.equalsIgnoreCase("Tuna") && InvCount(369) > 0) {
                    DropAll(369);
                    FishTuna();
                }
                while (Fish.equalsIgnoreCase("Swordfish") && InvCount(366) > 0) {
                    DropAll(366);
                    FishSwordfish();
                }
                WalkToCustoms();
                Wait(100);
                DisplayReport();
                TalkToCustoms();
                Wait(100);
                DisplayReport();
                if (option.equalsIgnoreCase("Fish and Cert") && Running() == true) {
                    if (Fish.equalsIgnoreCase("Lobster"))
                    {CertLobster();
                     DisplayReport();}
                    if (Fish.equalsIgnoreCase("Swordfish"))
                    {CertSwordfish();
                     DisplayReport();}
                    WalkToCaptain();
                    Wait(100);
                    TalkToCaptain();
                    Wait(100);
                    WalkToDock();
                    Wait(100);
                }
                if (option.equalsIgnoreCase("Fish and Bank") && Running() == true) {
                    Banking();
                    DisplayReport();
                    WalkToCaptain();
                    Wait(100);
                    DisplayReport();
                    TalkToCaptain();
                    Wait(100);
                    DisplayReport();
                    WalkToDock();
                    Wait(100);
                    DisplayReport();
                }
            }
        }
        DisplayMessage("@red@Kamaraja Fisher STOPPED",3);
    }
    public void actionPerformed(ActionEvent event) {
        Object chosenFishMode = fishMode.getSelectedItem();
        Object chosenFishType = fish.getSelectedItem();
        option = chosenFishMode.toString();
        Fish = chosenFishType.toString();
        run_script = true;
    }
    
    private void AddSettings() {
        fishFrame = new JFrame("Canibal's Option chooser");
        fishFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fishFrame.setSize(new Dimension(325, 400));
        
        fishPanel = new JPanel(new GridLayout(2, 2));
        
        fishFrame.getRootPane().setDefaultButton(save);
        
        fishFrame.getContentPane().add(fishPanel, BorderLayout.CENTER);
        
        String fishModes[] = {"Fish and Cert","Fish and Bank"};
        String fishes[] = {"Lobster","Tuna","Swordfish"};
        fishModeLabel = new JLabel("Fishing Mode --->", SwingConstants.LEFT);
        fishLabel = new JLabel("Fish Type --->", SwingConstants.LEFT);
        fishMode = new JComboBox(fishModes);
        emptylabel1 = new JLabel("");
        save = new JButton("Save choices");
        fish = new JComboBox(fishes);
        save.addActionListener(this);
        
        fishPanel.add(fishModeLabel);
        fishPanel.add(fishMode);
        fishPanel.add(emptylabel1);
        fishPanel.add(fishLabel);
        fishPanel.add(fish);
        fishPanel.add(save);
        
        
        fishModeLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        fishLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        fishPanel.setBackground(Color.black);
        fish.setBackground(Color.black);
        fishMode.setBackground(Color.black);
        fishModeLabel.setForeground(Color.blue);
        fishLabel.setForeground(Color.blue);
        fishMode.setForeground(Color.white);
        fish.setForeground(Color.white);
        
        fishFrame.pack();
        fishFrame.setVisible(true);
        
    }
    public void SetupReport() {
        lvl = GetStat(10)-startlvl;
        minutes = (System.currentTimeMillis() - starttime) / 60000;
        xp = (GetExperience(10) - startxp);
        reportFrame = new JFrame("Canibals Kamaraja fisher Progress report");
        reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportFrame.setSize(new Dimension(325, 400));
        
        reportPanel = new JPanel(new GridLayout(4, 7));
        
        reportFrame.getContentPane().add(reportPanel, BorderLayout.CENTER);
        
        R_option = new JLabel("Option: " + option);
        R_option.setFont(new Font("Times New Roman",Font.BOLD,15));
        R_minutes = new JLabel("You have been fishing for " + minutes + " minutes", SwingConstants.LEFT);
        R_minutes.setFont(new Font("Times New Roman",Font.BOLD,12));
        R_xp = new JLabel("You have gained " + xp + " xp", SwingConstants.LEFT);
        R_xp.setFont(new Font("Times New Roman",Font.BOLD,12));
        R_lvl = new JLabel("You have advanced " + lvl + " levels", SwingConstants.LEFT);
        R_lvl.setFont(new Font("Times New Roman",Font.BOLD,12));
        R_fished = new JLabel("You have fished " + fishes + " " + Fish + "s", SwingConstants.LEFT);
        R_fished.setFont(new Font("Times New Roman",Font.BOLD,12));
        R_slept = new JLabel("You have slept a total of " + slept + " times", SwingConstants.LEFT);
        R_slept.setFont(new Font("Times New Roman",Font.BOLD,12));
        R_empty= new JLabel("" , SwingConstants.LEFT);
        
        reportPanel.add(R_option);
        reportPanel.add(R_empty);
        reportPanel.add(R_minutes);
        reportPanel.add(R_xp);
        reportPanel.add(R_lvl);
        reportPanel.add(R_fished);
        reportPanel.add(R_slept);
        
        R_option.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        R_minutes.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        R_xp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        R_lvl.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        R_fished.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        R_slept.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        reportFrame.pack();
        reportFrame.setVisible(true);
    }
    public void DisplayReport() {
        lvl = GetStat(10)-startlvl;
        minutes = (System.currentTimeMillis() - starttime) / 60000;
        xp = (GetExperience(10) - startxp);
        R_option.setText("Option:  " + option);
        R_minutes.setText("You have been fishing for " + minutes + " minutes");
        R_xp.setText("You have gained " + xp + " xp");
        R_lvl.setText("You have advanced " + lvl + " levels");
        R_fished.setText("You have fished " + fishes + " " + Fish + "s");
        R_slept.setText("You have slept a total of " + slept + " times");
        SwingUtilities.updateComponentTreeUI(R_option);
        SwingUtilities.updateComponentTreeUI(R_minutes);
        SwingUtilities.updateComponentTreeUI(R_xp);
        SwingUtilities.updateComponentTreeUI(R_lvl);
        SwingUtilities.updateComponentTreeUI(R_fished);
        SwingUtilities.updateComponentTreeUI(R_slept);
    }
    
    
    public void Report() {
        int fishingxp = GetExperience(10) - startxp;
        int fishinglvl = GetStat(10) - startlvl;
        minutes = (System.currentTimeMillis() - starttime) / 60000;
        Println("Progres Report");
        Println("You are currently " + option +"ing " + Fish + "s");
        Println("You have been running for " + minutes + " minutes");
        Println("You have fished " + fishes + "" + Fish + "s");
        Println("You have slept " + slept + " times");
        Println("You have gained " + fishingxp + "xp and " + fishinglvl + " levels");
    }
    
    public void WalkToCustoms() {
        Walk(370,690);
        Wait(100);
        Walk(369,696);
        Wait(100);
        Walk(368,700);
        Wait(100);
        Walk(367,707);
        Wait(100);
        Walk(357,710);
        Wait(100);
        Walk(348,710);
        Wait(100);
        Walk(339,712);
        Wait(100);
        Walk(333,713);
        Wait(100);
    }
    public void TalkToCustoms() {
        while(QuestMenu() == false) {
            int CustomsID = GetNearestNPC(163);
            long CurrentTime = System.currentTimeMillis();
            TalkToNPC(CustomsID);
            while(System.currentTimeMillis() - CurrentTime <= 2000 && QuestMenu() == false) {
                Wait(100);
            }
            Wait(1000);
        }
        for(; !QuestMenu(); Wait(100));
        Answer(0);
        for(; !QuestMenu(); Wait(100));
        Answer(1);
        for(; !QuestMenu(); Wait(100));
        Answer(0);
        
        Wait(3000);
        Walk(269,642);
        Wait(100);
        Walk(261,641);
        Wait(100);
        Walk(260,633);
        Wait(100);
        Walk(260,627);
        Wait(100);
        Walk(255,620);
        Wait(100);
        Walk(248,613);
        Wait(100);
        Walk(240,616);
        Wait(100);
        Walk(234,622);
        Wait(100);
        Walk(229,630);
        Wait(100);
    }
    public void WalkToCaptain() {
        Walk(233,626);
        Wait(100);
        Walk(238,621);
        Wait(100);
        Walk(243,615);
        Wait(100);
        Walk(248,615);
        Wait(100);
        Walk(256,620);
        Wait(100);
        Walk(259,631);
        Wait(100);
        Walk(260,640);
        Wait(100);
        Walk(267,641);
        Wait(100);
        Walk(269,648);
        Wait(100);
    }
    public void TalkToCaptain() {
        while (QuestMenu() == false) {
            int SeamanID = GetNearestNPC(166);
            long CurrentTime = System.currentTimeMillis();
            TalkToNPC(SeamanID);
            while(System.currentTimeMillis() - CurrentTime <= 2000 && QuestMenu() == false) {
                Wait(1);
            }
            Wait(100);
        }
        Wait(2000);
        Answer(0);
        Wait(3000);
    }
    
    
    public void WalkToDock() {
        Walk(334,713);
        Wait(100);
        Walk(344,710);
        Wait(100);
        Walk(350,710);
        Wait(100);
        Walk(358,710);
        Wait(100);
        Walk(363,710);
        Wait(100);
        Walk(367,704);
        Wait(100);
        Walk(371,694);
        Wait(100);
        Walk(370,685);
        Wait(100);
    }
    public void FishLobster() {
        while (InvCount() < 30) {
            AtObject2(368,684);
            Wait(1000);
            if (Fatigue() > 84) {
                while (Sleeping() == false) {
                    Use(FindInv(1263));
                    Wait(2500);
                }
                while (Sleeping() == true && Running() == true) {
                    Wait(100);
                }
                
            }
            
        }
    }
    public void FishSwordfish() {
        while (InvCount() < 30) {
            AtObject(368,684);
            Wait(1000);
            if (Fatigue() > 84) {
                while (Sleeping() == false) {
                    Use(FindInv(1263));
                    Wait(2500);
                }
                while (Sleeping() == true && Running() == true) {
                    Wait(100);
                }
                
            }
            
        }
        
    }
    public void FishTuna() {
        while (InvCount() < 30) {
            AtObject(368,684);
            Wait(1000);
            if (Fatigue() > 84) {
                while (Sleeping() == false) {
                    Use(FindInv(1263));
                    Wait(2500);
                }
                while (Sleeping() == true && Running() == true) {
                    Wait(100);
                }
                
            }
            
        }
        
    }
    public void CertLobster() {
        while (QuestMenu() == false) {
            int certer = GetNearestNPC(227);
            TalkToNPC(certer);
            Wait(1000);
        }
        for(; !QuestMenu(); Wait(100));
        Answer(1);
        for(; !QuestMenu(); Wait(100));
        Answer(1);
        for(; !QuestMenu(); Wait(100));
        Answer(4);
        Wait(1000);
        if (InvCount() == 30)
        {CertLobster();}
    }
    public void CertSwordfish() {
        while (QuestMenu() == false) {
            int certer = GetNearestNPC(227);
            TalkToNPC(certer);
            Wait(1000);
        }
        for(; !QuestMenu(); Wait(100));
        Answer(1);
        for(; !QuestMenu(); Wait(100));
        Answer(3);
        for(; !QuestMenu(); Wait(100));
        Answer(4);
        Wait(1000);
        if (InvCount() == 30)
        {CertSwordfish();}
    }
    public void Banking() {
        while (QuestMenu() == false) {
            int BankerID = GetNearestNPC(95);
            TalkToNPC(BankerID);
            Wait(1010);
        }
        Answer(0);
        while (Bank() == false)
        {Wait(1000);}
        while (InvCount(366) > 0) {
            Deposit(366,1);
            Wait(200);
        }
        while (InvCount(372) > 0) {
            Deposit(372,1);
            Wait(200);
        }
        while (InvCount(369) > 0) {
            Deposit(369,1);
            Wait(200);
        }
        CloseBank();
    }
    private void DropAll(int id) {
        int finv = InvCount();
        while(InvCount(id) > 0 && Running()) {
            int pinv = InvCount();
            while(pinv == InvCount() && Running()) {
                Drop(FindInv(id));
                long Time = TickCount();
                while (pinv == InvCount() && TickCount() - Time <= 3000 && Running())
                    Wait(100);
                Wait(100);
            }
            Wait(100);
        }
    }
    
}