import java.io.*;
import java.util.*;
import java.util.Properties.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.*;

public class allinone extends Methods
{
    public allinone (mudclient mc){super(mc);}
    
    private int[] ParseString(String[] penis) {
        int[] cock = new int[penis.length];
        for(int k = 0; k < penis.length; k++)
            cock[k] = StrToInt(penis[k]);
        return cock;
    }   
    private boolean banking = false;
    private boolean banking1 = false;
    private boolean banking2 = false;
    private boolean banking3 = false;
    private boolean stopping;
    private boolean chesting;
    private boolean chest2;
    private boolean chest1;
    private boolean fighting;
    private boolean fishstyle1;
    private boolean fishstyle2;
    private boolean fighting1;
    private boolean thieving;
    private boolean mine1;
    private boolean guild;
    private boolean mine;
    private boolean run = false;
    private boolean fishing;
    private boolean coordget = false;
    private boolean GotCoords = false;
    private int[] door;
    private int[] downladder = {223,6};
    private int[] walkX = new int[1000];
    private int[] walkY = new int[1000];
    private int[] gems = {157,158,159,160};
    private int[] Npcid;
    private int[] RockId;
    private int fishId;
    private int fishId1; 
    private int chestId;
    private long StartTime;
    private long longtime;
    private long l;   
    private long XpAgain;
    private long average;
    private long XpNow;
    private int h;
    private int stop;
    private int fishpause;
    private int minepause;
    private int fightpause;
    private int chestpause;
    private int StartX;
    private int StartY;
    private int stop1;
    private int thing1;
    private int thing2;
    private int thing3;
    private int FoodId = 0;
    private int fishspot = 0;
    private int fmode;
    private int oremined = 0;
    private int fishfished = 0;
    private int NpcKilled = 0;
    private int mod;
    private int ore;
    private int s = 0;
    private int WaitTime = 500;
    private int WaitTime2 = 800;
    private int EatAt;
    private String[] Npcs;
    private String which;
    private String what;
    private String who;
    
    public JFrame menuFrame;    
    public JPanel fightPanel, minePanel,thievePanel, fishPanel, statusPanel, HowToPanel, StatsPanel;
    public JLabel fightModeLabel,things,chest11, NpcsLabel,type, idk, hpLabel, foodLabel, HowManyLabel, oreLabel,au2Label, rockLabel,guildLabel, autoLabel, FishIDLabel, fishLabel, fish1Label, styleLabel, stylefishLabel, StartLabel, PauseLabel,howto,howto1,howto2,howto3,howto4,howto5,howto6,Str,Def,Att,Wood,Fish,Hp,Mine,thief;
    public JComboBox fightModeComboBox,type1, styleComboBox, stylefishComboBox;
    public JTextField NpcsText, hpText,chest111, foodText,thing11, thing21, thing31, oreText, fishText,au2Text,FOODSText, OREText, FISHText, fish1Text, FishIDText,autoText, rockText, Str1, Def1, Att1, Wood1, thief1, Mine1, Fish1, Hp1;
    public JCheckBox bankCheck, bank1Check, bank2Check, bank;
    public JButton StartFightButton,StartThieveButton,helpButton, StartFishButton, StartMineButton, PauseButton, UnpauseButton, GuildMineButton,GetStatsButton;
    public void LoadSettings()
    {
        menuFrame = new JFrame("Anything Anywhere Fighter, Fisher, Miner");
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        /*------------------------mining panel------------------------------*/
        
        minePanel = new JPanel(new GridLayout(12, 12));
        
        rockLabel = new JLabel("Rock ID:");
        rockLabel.setBounds(8, 8, 100, 21);
        rockText = new JTextField("0",4);
        rockText.setBounds(116, 8, 100, 21);
        
        oreLabel = new JLabel("ID of ore:");
        oreLabel.setBounds(8, 32, 100, 21);
        oreText = new JTextField("0",4);
        oreText.setBounds(116, 32, 100, 21);
        
        bank1Check =  new JCheckBox("bank when full?");
        
        StartMineButton = new JButton("Start Mining?");
        
        guildLabel = new JLabel("I put in a default mine at guild... use it?");
        GuildMineButton = new JButton("Start Mining at the Guild??");
        
        minePanel.add(rockLabel);
        minePanel.add(rockText);
        minePanel.add(oreLabel);
        minePanel.add(oreText);
        minePanel.add(bank1Check);
        minePanel.add(StartMineButton);
        minePanel.add(guildLabel);
        minePanel.add(GuildMineButton);
        
        bank1Check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                banking1 = true;
                }
        }
        );
        
        StartMineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                autoText.setText("Auto Mining");  
                ore = Integer.parseInt(oreText.getText());
                String[] rocks = rockText.getText().split(":");                    
                RockId = new int[rocks.length];
                for(int x = 0;x < RockId.length; x++){
                    RockId[x] = StrToInt(rocks[x]);
                    }
                fighting = false;
                fishing = false;
                mine = true;
                mine1 = true;
                guild = false;
                run = true;}
        }
        );
        
        GuildMineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                autoText.setText("Auto Mining at the Guild");  
                ore = Integer.parseInt(oreText.getText());
                String[] rocks = rockText.getText().split(":");                    
                RockId = new int[rocks.length];
                for(int x = 0;x < RockId.length; x++){
                    RockId[x] = StrToInt(rocks[x]);
                    }
                fighting = false;
                fishing = false;
                mine1 = false;
                guild = true;
                mine = true;
                run = true;}
        }
        );
        /*------------------------HERES UR GAY THEVING PANNEL!!!!------------------------------*/
        thievePanel = new JPanel(new GridLayout(12, 12));
        
        chest11 = new JLabel("ID Of the Chest you will be theiving");
        chest111 = new JTextField("0", 4);
        
        things = new JLabel("Id's of what you want to bank here");
        thing11 = new JTextField("0", 4);
        thing21 = new JTextField("0", 4);
        thing31 = new JTextField("0", 4);
        
        type = new JLabel("What type of chest is it?");
        String types[] = {"Regular","Other"};
        type1 = new JComboBox(types);
        
        bank = new JCheckBox("Bank you shit? doesnt work for some doors or ladders");
        
        idk = new JLabel("i dont know what else to add to this part... plz suggest things");
        
        StartThieveButton = new JButton("Start Auto Chest whatever?"); 
        
        thievePanel.add(chest11);
        thievePanel.add(chest111);
        thievePanel.add(type);
        thievePanel.add(type1);
        thievePanel.add(things);
        thievePanel.add(thing11);
        thievePanel.add(thing21);
        thievePanel.add(thing31);
        thievePanel.add(bank);
        thievePanel.add(StartThieveButton);
        thievePanel.add(idk);
        
        bank.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                  banking3 = true;  
                  }
        }
        );
        StartThieveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                chestId = Integer.parseInt(chest111.getText());
                thing1 = Integer.parseInt(thing11.getText());
                thing2 = Integer.parseInt(thing21.getText());
                thing3 = Integer.parseInt(thing31.getText());
                autoText.setText("Thieving chests or whatever");
                mine = false;
                fishing = false;
                fighting = false;
                stopping = false;
                chesting = true;
                Object chestmod = type1.getSelectedItem();  
                String chest = chestmod.toString();
                if(chest.equalsIgnoreCase("Regular")){
                    chest2 = true;
                    chest1 = false;
                }
                else if(chest.equalsIgnoreCase("Other")){
                    chest2 = false;
                    chest1 = true;
                }
                
             }
        }
        );
                
        
        /*------------------------fighting panel------------------------------*/
        
        fightPanel = new JPanel(new GridLayout(12, 12));
        
        fightModeLabel = new JLabel("Fight mode:");
        fightModeLabel.setBounds(8, 8, 100, 21);
        String Styles[] = {"Controlled", "Strength", "Attack", "Defence"};
        fightModeComboBox = new JComboBox(Styles);
        fightModeComboBox.setBounds(116, 8, 100, 21);
        
        styleLabel = new JLabel("Style of fighting:");
        String what[] = {"Fighting", "Thieving"};
        styleComboBox = new JComboBox(what);
        
        foodLabel = new JLabel("Food ID:");
        foodText = new JTextField("0",4);   
             
        hpLabel = new JLabel("Hp Down To Eat:");
        hpText = new JTextField("0",4);    
          
        NpcsLabel = new JLabel("Npc's here:");
        NpcsText = new JTextField("0",4);
        
        bankCheck =  new JCheckBox("Bank For Food?");
        
        StartFightButton = new JButton("Start AutoFighting?");
        
        fightPanel.add(fightModeLabel);
        fightPanel.add(fightModeComboBox);
        fightPanel.add(styleLabel);
        fightPanel.add(styleComboBox);
        fightPanel.add(NpcsLabel);
        fightPanel.add(NpcsText);
        fightPanel.add(hpLabel);
        fightPanel.add(hpText);
        fightPanel.add(foodLabel);
        fightPanel.add(foodText);
        fightPanel.add(bankCheck);
        fightPanel.add(StartFightButton);
        
        bankCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                  banking = true;  
                  }
        }
        );
        
        StartFightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                
                String[] npcs = NpcsText.getText().split(":");
                Npcid = new int[npcs.length];
                for(int x = 0;x < Npcid.length; x++){
                    Npcid[x] = StrToInt(npcs[x]);
                    }
                autoText.setText("Auto Fighting");
                Object fightMode = fightModeComboBox.getSelectedItem();  
                String Style = fightMode.toString();
                if(Style.equalsIgnoreCase("Controlled")) { 
                    fmode = 0; 
                }
        	else if(Style.equalsIgnoreCase("Strength")) { 
        	    fmode = 1; 
        	}
        	else if(Style.equalsIgnoreCase("Attack")) { 
        	    fmode = 2; 
        	}
        	else if(Style.equalsIgnoreCase("Defence")) { 
        	    fmode = 3; 
        	}	                            
                FoodId = Integer.parseInt(foodText.getText());
                EatAt = Integer.parseInt(hpText.getText());
                mine = false;
                fishing = false;
                fighting = true;
                stopping = false;
                Object stylemode = styleComboBox.getSelectedItem();
                String method = stylemode.toString();
                if(method.equalsIgnoreCase("Fighting")) { 
                      fighting1 = true; 
                    thieving = false;
                }
        	else if(method.equalsIgnoreCase("Thieving")) { 
        	      thieving = true;
        	    fighting1 = false;
        	}
                run = true;
            }
        }
        );
       
        /*------------------------fishing panel------------------------------*/
        
        fishPanel = new JPanel(new GridLayout(12, 12));

        stylefishLabel = new JLabel("Style of Fishing: like right click and left click:");
        String fishin[] = {"Primary", "Secondary"};
        stylefishComboBox = new JComboBox(fishin);
        
        FishIDLabel = new JLabel("ID of your fish spot:");
        FishIDLabel.setBounds(8, 8, 100 , 21);
        FishIDText = new JTextField("0",4);
        FishIDText.setBounds(116, 8, 100, 21);
        
        fishLabel = new JLabel("ID of fish:");
        fishLabel.setBounds(8, 32, 100, 21);
        fishText = new JTextField("0",4);
        fishText.setBounds(116, 32, 100, 21);

        fish1Label = new JLabel("second Fish ID?");
        fish1Label.setBounds(8, 56, 100, 21);
        fish1Text = new JTextField("0",4);
        fish1Text.setBounds(116, 56, 100, 21);
            
        bank2Check = new JCheckBox("Bank When full?");
        
        StartFishButton = new JButton("Start Fishing?");
        
        fishPanel.add(FishIDLabel);
        fishPanel.add(FishIDText);
        fishPanel.add(fishLabel);
        fishPanel.add(fishText);
        fishPanel.add(fish1Label);
        fishPanel.add(fish1Text);
        fishPanel.add(bank2Check);
        fishPanel.add(stylefishLabel);
        fishPanel.add(stylefishComboBox);
        fishPanel.add(StartFishButton);
        
        
        bank2Check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                   banking2 = true;
                   }
        }        
        );
        
        StartFishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {  
                fishspot = Integer.parseInt(FishIDText.getText());
                fishId = Integer.parseInt(fishText.getText());
                fishId1 = Integer.parseInt(fish1Text.getText());   
                autoText.setText("Auto Fishing");
                mine = false;
                fighting = false;
                fishing = true;
                Object stylefish = stylefishComboBox.getSelectedItem();
                String fishmethod = stylefish.toString();
                if(fishmethod.equalsIgnoreCase("Primary")) { 
                      fishstyle1 = true; 
                    fishstyle2 = false;
                }
        	else if(fishmethod.equalsIgnoreCase("Secondary")) { 
        	      fishstyle2 = true;
        	    fishstyle1 = false;
        	}
                run = true;
                }
        }        
        );
        /*------------------------status panel--------------------------------*/
        
        statusPanel = new JPanel(new GridLayout(12, 12));
        
        autoLabel = new JLabel("You are currently Running:");
        autoLabel.setBounds(8, 8, 100, 21);
        autoText = new JTextField("Nothing",4);
        autoText.setBounds(116, 8, 100, 21);

        PauseLabel = new JLabel("Would you like to pause the script?");
        PauseLabel.setBounds(8, 32, 100, 21);
        PauseButton = new JButton("Pause Script!");
        PauseButton.setBounds(116, 32, 100, 21);
        
        
        StartLabel = new JLabel("Would you like to Unpause the script?");
        StartLabel.setBounds(8, 56, 100, 21);
        UnpauseButton = new JButton("Unpause Script!");
        UnpauseButton.setBounds(116, 56, 100, 21);
        
        au2Label = new JLabel("You are currently:");
        au2Label.setBounds(8, 80, 100, 21);
        au2Text = new JTextField("dont know yet",4);
        au2Text.setBounds(116, 80, 100, 21);
        
        HowManyLabel = new JLabel("you currently have:");
        HowManyLabel.setBounds(8,104, 100, 21);
        
        FOODSText = new JTextField("Dont know not fighting",4);
        FOODSText.setBounds(116, 104, 100, 21);
        FISHText = new JTextField("Dont know not fishing", 4);
        FISHText.setBounds(116, 128, 100, 21);
        OREText = new JTextField("Dont know not mining", 4);
        OREText.setBounds(116, 152, 100, 21);
        
        statusPanel.add(autoLabel);
        statusPanel.add(autoText);
        statusPanel.add(PauseLabel);
        statusPanel.add(PauseButton);
        statusPanel.add(StartLabel);
        statusPanel.add(UnpauseButton);
        statusPanel.add(au2Label);
        statusPanel.add(au2Text);
        statusPanel.add(HowManyLabel);
        statusPanel.add(FOODSText);
        statusPanel.add(FISHText);
        statusPanel.add(OREText);
             
        PauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
               autoText.setText("Paused"); 
                if(fighting == true){
                      fighting = false;
                    fightpause++;
                }
                else if(mine == true){
                      mine = false;
                    minepause++;
                }
                else if(fishing == true){
                      fishing = false;
                    fishpause++;
                }
                else if(chesting == true){
                      chesting = false;
                    chestpause++;
                }
            }
        }
        );
        UnpauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                if(fishpause > 0){
                    autoText.setText("Auto Fishing");
                      fishing = true;
                    fishpause = 0;
                }
                else if(minepause > 0){
                    autoText.setText("Auto Mining"); 
                      mine = true;
                    minepause = 0;
                }
                else if(fightpause > 0){
                    autoText.setText("Auto Fighting");                
                      fighting = true;
                    fightpause = 0;
                }
                else if(chestpause > 0){
                    autoText.setText("Auto Chest thieving or whatever");
                      chesting = true;
                    chestpause = 0;
                }            
            }
        }
        );
        /*------------------------Stats Panel--------------------------------*/ 
        StatsPanel = new JPanel(new GridLayout(12, 12));
        
        Str = new JLabel("Strength:");
        Str.setBounds(8, 8, 100, 21);
        Str1 = new JTextField("0",4);
        Str1.setBounds(116, 8, 100, 21); 
       
        Att = new JLabel("Attack:");
        Att.setBounds(8, 32, 100, 21);        
        Att1 = new JTextField("0",4);
        Att1.setBounds(116, 32, 100, 21);
        
        Def = new JLabel("Defense:");
        Def.setBounds(8, 56, 100, 21);
        Def1 = new JTextField("0",4);
        Def1.setBounds(116, 56, 100, 21);        
        
        Hp = new JLabel("HP:");
        Hp.setBounds(8, 80, 100, 21);
        Hp1 = new JTextField("0",4); 
        Hp1.setBounds(116, 80, 100, 21);
         
        Wood = new JLabel("Wood Cutting:");
        Wood.setBounds(8, 104, 100, 21);
        Wood1 = new JTextField("0",4);
        Wood1.setBounds(116, 104, 100, 21); 
        
        Fish = new JLabel("Fishing:");
        Fish.setBounds(8, 128, 100, 21);
        Fish1 = new JTextField("0",4);
        Fish1.setBounds(116, 128, 100, 21);
        
        Mine = new JLabel("Mining:");
        Mine.setBounds(8, 152, 100, 21);
        Mine1 = new JTextField("0",4);
        Mine1.setBounds(116, 152, 100, 21);
        
        thief = new JLabel("Thieving:");
        thief.setBounds(8, 176, 100, 21); 
        thief1 = new JTextField("0",4);  
        thief1.setBounds(116, 176, 100, 21);
        
        GetStatsButton = new JButton("Get All Your Current stats!!");
        
        StatsPanel.add(Att);
        StatsPanel.add(Att1); 
        StatsPanel.add(Def);
        StatsPanel.add(Def1);
        StatsPanel.add(Str);
        StatsPanel.add(Str1);
        StatsPanel.add(Hp);
        StatsPanel.add(Hp1);  
        StatsPanel.add(Wood);
        StatsPanel.add(Wood1);
        StatsPanel.add(Fish);
        StatsPanel.add(Fish1);
        StatsPanel.add(Mine);
        StatsPanel.add(Mine1);
        StatsPanel.add(thief);
        StatsPanel.add(thief1);
        StatsPanel.add(GetStatsButton);
                       
        GetStatsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                  int attack = GetMaxLvl(0);
                     Att1.setText(""+attack+"");
                  int defense = GetMaxLvl(1);
                     Def1.setText(""+defense+"");
                  int strength = GetMaxLvl(2);
                     Str1.setText(""+strength+"");
                  int hp = GetMaxLvl(3);
                     Hp1.setText(""+hp+"");
                  int woodcut = GetMaxLvl(8);
                     Wood1.setText(""+woodcut+"");
                  int fishin = GetMaxLvl(10);
                     Fish1.setText(""+fishin+""); 
                  int minin = GetMaxLvl(14);
                     Mine1.setText(""+minin+"");
                  int thievin = GetMaxLvl(17);
                     thief1.setText(""+thievin+"");
            }
        }
        );     
                                                                         
        /*------------------------HowTo panel--------------------------------*/
        HowToPanel = new JPanel(new GridLayout(12, 12));
        
        howto = new JLabel("Welcome to x goat meat x's anything anywhere script!!!");
        howto1 = new JLabel("This Script Will Enable you to auto mine, auto fight,");
        howto2 = new JLabel("auto fish, auto woodcut, or auto pick and bank flax");
        howto6 = new JLabel("anywhere and bank anywhere!!!");
        howto3 = new JLabel("If you need any help on this script please refer to my");
        howto4 = new JLabel("topic about this script... Any and all questions will b");
        howto5 = new JLabel("answered.. find it at reinet.co.uk!!! happy autoing!!!!");
        helpButton = new JButton("click here for my topic");
        
        
        HowToPanel.add(howto);
        HowToPanel.add(howto1);
        HowToPanel.add(howto2);
        HowToPanel.add(howto6);
        HowToPanel.add(howto3);    
        HowToPanel.add(howto4);
        HowToPanel.add(howto5);
        HowToPanel.add(helpButton); 
        
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {  
            
               BrowserControl.displayURL("http://reinet.co.uk/viewtopic.php?id=54085");
               }
         }
         );
        
         tabbedPane.addTab("Fishing", fishPanel);   
         tabbedPane.addTab("Fighting", fightPanel);
         tabbedPane.addTab("Chest Thieve", thievePanel);  
         tabbedPane.addTab("Mining", minePanel);
         tabbedPane.addTab("Status", statusPanel);
         tabbedPane.addTab("Stats", StatsPanel);
         tabbedPane.addTab("hi2u", HowToPanel); 
        menuFrame.add(tabbedPane, BorderLayout.CENTER);
        menuFrame.pack();
        menuFrame.setSize(350, 350);
        menuFrame.setVisible(true);
        menuFrame.setResizable(false);    
    }       
    public void MainBody(String[] Args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 LoadSettings();
             }
         });
        AutoLogin(true);
        int pie = -1;
        if(fighting = true){
            pie = 3;
            }
        else if(mine = true){
            pie = 14;
            }
        else if(fishing = true){
            pie = 10;
            }
        if(banking == false){
            StartX = GetX();
            StartY = GetY();
            }
        if(banking1 == false){
            StartX = GetX();
            StartY = GetY();
            }
        XpNow = GetExp(pie);         
        XpAgain = GetExp(pie);
        StartTime = GetMillis();
        longtime = GetMillis();           
        StartScanForMods();
	while(Running())
	{ 
              while(coordget == true){
              au2Text.setText("Getting Coords......."); 
                   walkX[s]= GetX();
                     walkY[s]= GetY();
                       Display("Coord taken at (" + walkX[s] + "," + walkY[s] + ").");
                     Wait(Rand(4000,6000));
                   s++;
               }
            while(run == true){
            //------------chestin thieving?------\\
               while(chesting == true){
               if(chest2 == true){
                  int[] chast = GetObjectById(chestId);
                  if(chast[0] != -1 && GetFatigue() < 95 && Running()) {
                         AtObject(chast[1],chast[2]);
	              Chill(Rand(WaitTime,WaitTime2));
                  }
               }
               if(chest1 == true){
                  int[] chast1 = GetObjectById(chestId);
                  if(chast1[0] != -1 && GetFatigue() < 95 && Running()) {
                         AtObject2(chast1[1],chast1[2]);
	              Chill(Rand(WaitTime,WaitTime2));
                  }
               }
               if(InCombat()){
                     WalkTo(GetX(), GetY());
                   Wait(500);
               }
    	           SleepIfAt(95);
    	           while(Sleeping()){
    		       Chill(1000);
    		       } 
                       if(banking3 == true && CountInv() == 30){ 
                         Display("BANKING!!!");
			   au2Text.setText("Banking Your Shit?");                  
                           for(h = s-1; h > 0;h--){
                               if(!IsReachable(walkX[h], walkY[h]))
	                            check();
	                       else if(GetX() != walkX[h] || GetY() != walkY[h])
	                            WalkToWait(walkX[h],walkY[h]);  
                                    Wait(4000);   
                           } 
                           long l = GetMillis();
                           while(!QuestMenu() && GetMillis() - l < 20000){
                                int[] Npc1 = GetNpcById(BANKERS);
                                if(Npc1[0] != -1)
                                  TalkToNpc(Npc1[0]);
                                  Wait(1600);
                           }
                               Wait(2000);
                               Answer(0);
                               l = GetMillis();
                     
                          while(!QuestMenu() && GetMillis() - l < 10000)
                              Wait(10);
                              Answer(0);
                     
                          while(InBank() && CountInv(thing1) > 0 || CountInv(thing2) > 0 || CountInv(thing3) > 0 || CountInv(1263) < 1){
                              while(CountInv(thing1) > 0 && InBank()){
                                   int howmuch = CountInv(thing1);
                                  Deposit(thing1,howmuch);
                                 Wait(200);
                              }
                              while(CountInv(thing2) > 0 && InBank()){
                                    int howmuch2 = CountInv(thing2);
                                   Deposit(thing2,howmuch2);
                                 Wait(200);
                              }  
                              while(CountInv(thing3) > 0 && InBank()){
                                    int howmuch3 = CountInv(thing3);
                                   Deposit(thing3,howmuch3);
                                 Wait(200);
                              }                       
                              CloseBank();
                           }
                           for(h = 0; h < s; h++){
                                if(!IsReachable(walkX[h], walkY[h]))
                                    check();
                                else if(GetX() != walkX[h] || GetY() != walkY[h])
                                    WalkToWait(walkX[h],walkY[h]);
                                    Wait(4000); 
                           }
                        } 
                  }     
            //------------fighting-----------\\
               while(fighting == true){
                  if(fighting1 == true){
                   if(fighting1 == true && Loading()){
                      au2Text.setText("Lagging ahhhh!!!!");
                   }
                   else if(fighting == true && !Loading()){
                      au2Text.setText("Fighting Npc's........");
                   } 
	          if(CountInv(FoodId) >= 0){
	              int howmany2 = CountInv(FoodId);
	                FOODSText.setText(""+howmany2+" Food Left!!");
	          }
                   if(GetExp(3) != XpAgain){
		       NpcKilled++;
		       XpAgain = GetExp(3);
		       }
	           
    	           SleepIfAt(95);
    	           while(Sleeping()){
    		       Chill(1000);
    		       }
    	       
	           if(GetMode() != fmode)
	           SetMode(fmode);	
	              
	           int[] Npc = GetNpcById(Npcid);
	           if(Npc[0] != -1 && !InCombat()){
	                 KillThatShit(Npc[0]);
	               Chill(Rand(WaitTime,WaitTime2));
	               }

                   if(!InCombat() & Running() & Npc[0] == -1 & (GetX() != StartX || GetY() != StartY)){
        	         WalkTo(StartX,StartY);
        	       Chill(500);
                   }
                   if(stopping == true){
                      if(fmode == 1){
                         stop1 = 2;
                         }
                         else if(fmode == 2){
                             stop1 = 0;
                             }
                             else if(fmode == 3){
                                 stop1 = 1;
                                 }
                                 if(GetCurLvl(stop1) == stop){
                                   Wait(10000);
                                   Die();
                              }
                   }        
	           if(GetMaxLvl(3) - GetCurLvl(3) > EatAt){
	               if(FoodId == 330){
	                   Munch(GetItemPos(335));
	                     Chill(Rand(500,1000));
	                       Munch(GetItemPos(333));
	                       Chill(Rand(500,1000));
	                     Munch(GetItemPos(330));
	                   Chill(Rand(500,1000));
	               }
	               else{
	                    Munch(GetItemPos(FoodId));
	                  Chill(Rand(500,1000));
	               }	          
	           }
	           }
	           //thieving right here\\
	           if(thieving == true){
                     if(thieving == true && Loading()){
                      au2Text.setText("Lagging ahhhh!!!!");
                    }
                    else if(thieving == true && !Loading()){
                      au2Text.setText("Thieving Npc's........");
                    }  
    	               SleepIfAt(95);
    	                while(Sleeping()){
    		            Chill(1000);
    		          }
    	       
	                  if(GetMode() != fmode)
	                     SetMode(fmode);	
	              
	           int[] Npc = GetNpcById(Npcid);
	           if(Npc[0] != -1 && !InCombat()){
	                 ThieveNpc(Npc[0]);
	               Chill(Rand(WaitTime,WaitTime2));
	               }
                   if(InCombat() && GetX() != StartX || GetY() != StartY){
        	         WalkTo(StartX,StartY);
        	       Chill(500);
                   }
                   if(!InCombat() & Running() & Npc[0] == -1 & (GetX() != StartX || GetY() != StartY)){
        	         WalkTo(StartX,StartY);
        	       Chill(500);
                   }
                            
	           if(GetMaxLvl(3) - GetCurLvl(3) > EatAt){
	               if(FoodId == 330){
	                   Munch(GetItemPos(335));
	                     Chill(Rand(500,1000));
	                       Munch(GetItemPos(333));
	                       Chill(Rand(500,1000));
	                     Munch(GetItemPos(330));
	                   Chill(Rand(500,1000));
	               }
	               else{
	                    Munch(GetItemPos(FoodId));
	                  Chill(Rand(500,1000));
	               }	          
	           }
	           }
                   boolean locked = IsReachable(StartX, StartY);
                   if(locked == false){
	               int[] door = GetWallObjectById(2);
	               AtWallObject(door[1],door[2]);
	               Wait(1000);
	           }
                       if(banking == true && CountInv(FoodId) < 1){ 
                         Display("BANKING!!!");
			   au2Text.setText("Banking for Food.....");                  
                           for(h = s-1; h > 0;h--){
                               if(!IsReachable(walkX[h], walkY[h]))
	                            check();
	                       else if(GetX() != walkX[h] || GetY() != walkY[h])
	                            WalkToWait(walkX[h],walkY[h]);  
                                    Wait(4000);   
                           } 
                           long l = GetMillis();
                           while(!QuestMenu() && GetMillis() - l < 20000){
                                int[] Npc1 = GetNpcById(BANKERS);
                                if(Npc1[0] != -1)
                                  TalkToNpc(Npc1[0]);
                                  Wait(1600);
                           }
                               Wait(2000);
                               Answer(0);
                               l = GetMillis();
                     
                          while(!QuestMenu() && GetMillis() - l < 10000)
                              Wait(10);
                              Answer(0);
                     
                          while(InBank() && CountInv(FoodId) < 1 || CountInv(1263) < 1){
                              if(CountInv(1263) < 1){
                                  Withdraw(1263,1);
                                  Wait(300);
                              }
                              while(CountInv() < 30 && Running()){
                                   Withdraw(FoodId,1);
                                   Wait(300);       
                              }                            
                              CloseBank();
                           }
                           for(h = 0; h < s; h++){
                                if(!IsReachable(walkX[h], walkY[h]))
                                    check();
                                else if(GetX() != walkX[h] || GetY() != walkY[h])
                                    WalkToWait(walkX[h],walkY[h]);
                                    Wait(4000); 
                           }
                        }                   
	         putfightIni();               
                }
                //--------mining-------\\
                while(mine == true){
                   if(mine == true && Loading()){
                      au2Text.setText("Lagging ahhhh!!!!");
                   }
                   else if(mine == true && !Loading()){
                      au2Text.setText("Mining........");
                   } 
                  if(GetExp(14) != XpAgain){
		       oremined++;
		       XpAgain = GetExp(14);
	          }
	          if(CountInv(ore) >= 0){
	              int howmany = CountInv(ore);
	                OREText.setText(""+howmany+" ores!!");
	          }
                  int[] rocks = GetObjectById(RockId);
                  if(rocks[0] != -1 && GetFatigue() < 95 && Running()) {
                      AtObject(rocks[1], rocks[2]);
	              Chill(Rand(WaitTime,WaitTime2));
                  }
    	          SleepIfAt(80);
    	           while(Sleeping()){
    		       Chill(1000);
    	           }
                   if(!InCombat() & Running() & rocks[0] == -1 & (GetX() != StartX || GetY() != StartY)){
        	       WalkTo(StartX,StartY);
        	       Chill(500);
                   }
                       if(banking1 && CountInv() == 30){ 
                         Display("BANKING!!!");
                          au2Text.setText("Banking Ores.....");
                          if(mine1 == true);{
                           for(h = s-1; h > 0;h--){
                               if(!IsReachable(walkX[h], walkY[h]))
	                            check();
	                       else if(GetX() != walkX[h] || GetY() != walkY[h])
	                            WalkToWait(walkX[h],walkY[h]);  
                                    Wait(4000);   
                           }
                           }
                           if(guild == true){
                           int[] guildladder = GetObjectById(5);
                           while(!IsReachable(274, 564)){
                               AtObject(guildladder[1], guildladder[2]);
                               Wait(500);
                           }
                           WalkToWait(275,564);
                           WalkToWait(281,562);
                           WalkToWait(287,567);
                           WalkToWait(285,571);
                           }
                           long l = GetMillis();
                           while(!QuestMenu() && GetMillis() - l < 20000){
                                int[] Npc1 = GetNpcById(BANKERS);
                                if(Npc1[0] != -1)
                                  TalkToNpc(Npc1[0]);
                                  Wait(1600);
                           }
                               Wait(2000);
                               Answer(0);
                               l = GetMillis();
                     
                          while(!QuestMenu() && GetMillis() - l < 10000)
                              Wait(10);
                              Answer(0);
                     
                          while(InBank() && CountInv(ore) > 0 || CountInv(1263) < 1){
                              if(CountInv(1263) < 1){
                                     Withdraw(1263,1);
                                  Wait(300);
                              }
                              while(CountInv(ore) > 0 && Running()){
                                   int rocks1 = CountInv(ore);
                                      Deposit(ore,rocks1);
                                   Wait(300);       
                              }
            		      for(int i = 0;i < gems.length;i++) {
                	      while(CountInv(gems[i]) > 0 && Running() && InBank()) {
                    		Deposit(gems[i],1);
                    		Wait(Rand(100,200));                		
                	      }
                            
                              CloseBank();
                           }
                           if(guild == true){
                           WalkToWait(285,571);
                           WalkToWait(287,567);
                           WalkToWait(281,562);
                           WalkToWait(275,564);
                           int[] guildladder1 = GetObjectById(223);
                           while(!IsReachable(274,3396)){
                               AtObject(guildladder1[1], guildladder1[2]);
                               Wait(500);
                           }                           
                           }
                           if(mine1 == true){
                           for(h = 0; h < s; h++){
                                if(!IsReachable(walkX[h], walkY[h]))
                                    check();
                                else if(GetX() != walkX[h] || GetY() != walkY[h])
                                    WalkToWait(walkX[h],walkY[h]);
                                    Wait(4000); 
                           }
                           }
                           
                        } 
                     }
                 putmineIni();  
                 }
                 //---------fishing-------\\\\
                 while(fishing == true){
                   if(fishing == true && Loading()){
                      au2Text.setText("Lagging ahhhh!!!!");
                   }
                   else if(fishing == true && !Loading()){
                      au2Text.setText("Fishing........");
                   } 
	          if(CountInv(fishId) >= 0){
	              int howmany1 = CountInv(fishId);
	                FISHText.setText(""+howmany1+" fish!!");
	          }               
                  if(GetExp(10) != XpAgain){
		       fishfished++;
		       XpAgain = GetExp(10);
	          }
	          if(fishstyle1 == true){
	          
                  int[] pool = GetObjectById(fishspot);
                  if(pool[0] != -1 && GetFatigue() < 95 && Running()) {
                         AtObject(pool[1],pool[2]);
	              Chill(Rand(WaitTime,WaitTime2));
                  }
                  }
                  else if(fishstyle2 == true){
                  int[] pool1 = GetObjectById(fishspot);
                  if(pool1[0] != -1 && GetFatigue() < 95 && Running()) {
                         AtObject2(pool1[1],pool1[2]);
	              Chill(Rand(WaitTime,WaitTime2));
                  }
                  }
    	          SleepIfAt(95);
    	           while(Sleeping()){
    		       Chill(1000);
    	           }
                       if(banking2 == true && CountInv() == 30){ 
                         Display("Banking!!!!");
		           au2Text.setText("Banking Fish....");   
                           for(h = s-1; h > 0;h--){
                               if(!IsReachable(walkX[h], walkY[h]))
	                            check();
	                       else if(GetX() != walkX[h] || GetY() != walkY[h])
	                            WalkToWait(walkX[h],walkY[h]);  
                                    Wait(4000);   
                           } 
                           long l = GetMillis();
                           while(!QuestMenu() && GetMillis() - l < 20000){
                               int[] Npc1 = GetNpcById(BANKERS);
                               if(Npc1[0] != -1)
                                  TalkToNpc(Npc1[0]);
                                  Wait(1600);
                                }
                               Wait(2000);
                               Answer(0);
                               l = GetMillis();
                          while(!QuestMenu() && GetMillis() - l < 10000)
                               Wait(10);
                               Answer(0);
                              while(CountInv(fishId) > 0 && InBank()){
                                   int howmuch = CountInv(fishId);
                                  Deposit(fishId,howmuch);
                                 Wait(200);
                              }
                              while(CountInv(fishId1) > 0 && InBank()){
                                    int howmuch1 = CountInv(fishId1);
                                   Deposit(fishId1,howmuch1);
                                 Wait(200);
                              }
                              CloseBank();
                           for(h = 0; h < s; h++){
                                if(!IsReachable(walkX[h], walkY[h]))
                                    check();
                                else if(GetX() != walkX[h] || GetY() != walkY[h])
                                       WalkToWait(walkX[h],walkY[h]);
                                    Wait(4000); 
                           }
                       }
                 putfishIni();  
                 } 
          }                
      }
    }
    public void OnChatMessage(String sender, String message){
        if(mod < 1 && (sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul") || sender.equalsIgnoreCase("king2133"))){
           mod++;
 	   String[] rply1 = {"hey bro","hola","yo"};
	   String[] rply2 = {"hows it goin?","hows life treatin ya?"};      
           String Excuse = rply1[Rand(0, rply1.length - 1)];
           String Excuse2 = rply2[Rand(0, rply2.length - 1)];
           Wait(Rand(4000,6000));
           Speak(Excuse);
           Wait(Rand(4000,6000));
           Speak(Excuse2);
        }else
        if(mod > 1){
           String[] rply1 = {"lol im good, but yea, i have to go","yea im fine... thx for caring but man training is soo boring, ima go eat"};
           String[] rply2 = {"Cya","Bye","peace"};
           String Excuse = rply1[Rand(0, rply1.length - 1)];
           String Excuse2 = rply2[Rand(0, rply2.length - 1)];
           Wait(Rand(4000,6000));
           Speak(Excuse);
           Wait(Rand(5000,8000));
           Speak(Excuse2);
           Wait(Rand(5000,8000));
           LogOut();
           Die();
        }
    }
    
    public void OnPrivateMessage(String sender, String message){
        if(mod < 1 && (sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul") || sender.equalsIgnoreCase("king2133"))){
           mod++;
 	   String[] rply1 = {"hey bro","hola","yo"};
	   String[] rply2 = {"hows it goin?","hows life treatin ya?"};  
           String Excuse = rply1[Rand(0, rply1.length - 1)];
           String Excuse2 = rply2[Rand(0, rply2.length - 1)];
           AddToFriends(sender);
           Chill(Rand(4000,6000));
           SendPM(sender, Excuse);
           Chill(Rand(5000,8000));
           SendPM(sender, Excuse2);
        }else
        if(mod > 0){
           String[] rply1 = {"lol im good, but yea, i have to go","yea im fine... thx for caring but man training is soo boring, ima go eat"};
           String[] rply2 = {"Cya","Bye","peace"};
           String Excuse = rply1[Rand(0, rply1.length - 1)];
           String Excuse2 = rply2[Rand(0, rply2.length - 1)];
           Chill(Rand(4000,6000));
           SendPM(sender, Excuse);
           Wait(Rand(5000,8000));
           SendPM(sender, Excuse2);
           Chill(Rand(5000,8000));
           LogOut();
           Die();
        }
    }
    public void OnServerMessage(String message)
    {
        
    }
    private String GetArg(String s, int pos)///// thanks to reines for this
    {
        if(pos == 1)
        {
            String temp = s.substring(s.indexOf("(") + 1);
            return temp.substring(0, temp.indexOf(temp.indexOf(",") > -1 ? "," : ")"));
        }
        else if(pos == 2)
        {
            String temp = s.substring(s.indexOf(",") + 1);
            return temp.substring(0, temp.indexOf(temp.indexOf(",") > -1 ? "," : ")"));
        }
        else if(pos >= 3)
        {
            String temp = s.substring(s.indexOf(",") + 1);
            for(int a = 2; a < pos; a++)
                temp = temp.substring(temp.indexOf(",") + 1);
            return temp.substring(0,temp.indexOf(temp.indexOf(",") > -1 ? "," : ")"));
        }
        return null;
    }
    public void OnInput(String input){
    
        if(input.startsWith("stoplevel(") && IsInStr(input,")")){
             stop = Integer.parseInt(GetArg(input,1));
             stopping = true;
        }   
        else if(input.equalsIgnoreCase("Strength")){
            fmode = 1;
        }
        else if(input.equalsIgnoreCase("Defense")){
            fmode = 3;
        }
        else if(input.equalsIgnoreCase("Attack")){
            fmode = 4;
        }
        else if(input.equalsIgnoreCase("Pause")){
            run = false;
        }
        else if(input.equalsIgnoreCase("run")){
            run = true;
        }
        else if(input.equalsIgnoreCase("getCoords")){
            Display("Manualy walk from your bank, to your npc training area and then type \"/endGet\"");
            Display("Coord Getter @gre@STARTED!!"); 
            coordget = true;
            run = false;
            if(mine == true){
                mine = false;
                minepause++;
            }
            else if(fishing == true){
                fishing = false;
                fishpause++;
            }
            else if(fighting == true){
                fighting = false;
                fightpause++;
            }
            else if(chesting == true){
                chesting = false;
                chestpause++;
            }
        } 
        else if(input.equalsIgnoreCase("endGet") && Running()){
            Display("Coord Getter @red@STOPPED!!");
            coordget = false;
            StartX = GetX();
            StartY = GetY();
            run = true;
            if(minepause > 0){
                mine = true;
                minepause = 0;
            }
            else if(fightpause > 0){
                fighting = true;
                fightpause = 0;
            }
            else if(fishpause > 0){
                fishing = true;
                fishpause = 0;
            }
            else if(chestpause > 0){
                chesting = true;
                chestpause = 0;
            }            
        }    
    }    
    public void KillThatShit(int Npc){
        AttackNpc(Npc);
    }
    public void Munch(int Id){
       UseItem(Id);}
    public void Chill(int time){
       Wait(time);
    }
    public void putfishIni(){  
       if(fishing == true){    
       long Xp = GetExp(10) - XpNow;
       long manyminutes = (GetMillis() - longtime) / 60000;
       if(manyminutes > 0){
       average = (Xp / manyminutes) * 60;
       }
       if((GetMillis() - StartTime) > 60000){
         try {
                Properties props = new Properties(); 
  	        OutputStream propOut = new FileOutputStream(new File("FishStatus.txt"));
                props.setProperty("XpGained","" +Xp);
                props.setProperty("FishFished","" +fishfished);
                props.setProperty("MinutesAutoing","" +manyminutes);
                props.setProperty("AverageXpPerHour","" +average);
                props.store(propOut, "Your Autoing Status");	    
	     }catch (Exception e) {
             System.out.println(e);
             }
             StartTime = GetMillis();
        } 
        }	  	 	 
    } 
    public void putfightIni(){     
       if(fighting == true){  
       long Xp = (GetExp(3) - XpNow) * 3;
       int FoodLeft = CountInv(330);
       long manyminutes = (GetMillis() - longtime) / 60000;
       if(manyminutes > 0){
           average = (Xp / manyminutes) * 60;
       }
       if((GetMillis() - StartTime) > 60000){
         try {
                Properties props = new Properties(); 
  	        OutputStream propOut = new FileOutputStream(new File("FightStatus.txt"));
                props.setProperty("XpGained","" +Xp);
                props.setProperty("FoodLeft","" +FoodLeft);
                props.setProperty("Npc'sKilled","" +NpcKilled);
                props.setProperty("MinutesAutoing","" +manyminutes);
                props.setProperty("AverageXpPerHour","" +average);
                props.store(propOut, "Your Autoing Status");	    
	     }catch (Exception e) {
             System.out.println(e);
             }
             StartTime = GetMillis();
        } 
        }	  	 	 
    }  
    public void putmineIni()
    {       
       if(mine == true){
       long Xp = GetExp(14) - XpNow;
       long manyminutes = (GetMillis() - longtime) / 60000;
       if(manyminutes > 0){
           average = (Xp / manyminutes) * 60;
       }
       if((GetMillis() - StartTime) > 60000){
         try {
                Properties props = new Properties(); 
  	        OutputStream propOut = new FileOutputStream(new File("MineStatus.txt"));
                props.setProperty("XpGained","" +Xp);
                props.setProperty("OresMined","" +oremined);
                props.setProperty("MinutesAutoing","" +manyminutes);
                props.setProperty("AverageXpPerHour","" +average);
                props.store(propOut, "Your Autoing Status");	    
	     }catch (Exception e) {
             System.out.println(e);
             }
             StartTime = GetMillis();
        }
        } 	  	 	 
    }
    public void KeyPressed(int Key){       
        int Delay = WaitTime;
        int Delay2 = WaitTime2;
        if(Key == 1000){
            WaitTime = Delay + 100;
            WaitTime2 = Delay2 + 100;
            Display("Your delay is now random between " +WaitTime+ " and " +WaitTime2+ " ");
        }
        if(Key == 1001){
            WaitTime = Delay - 100;
            WaitTime2 = Delay2 - 100;
            Display("Your delay is now random between " +WaitTime+ " and " +WaitTime2+ " ");
        }
    }

    public String explode(int[] anus, String splitter){
        String s = "";
        for(int x = 0;x < anus.length;x++)
            s = s + IntToStr(anus[x]) + splitter;
        return s.substring(0,s.length() - splitter.length());
    }
    public void checkdoors(){
       boolean blah = IsReachable(walkX[h], walkY[h]);
       if(blah == false){
          int[] DOORS = GetWallObjectById(2);
          if(DistanceTo(DOORS[1], DOORS[2]) > 3 && !IsReachable(DOORS[1],DOORS[2]))
             checkbankdoors();
          else
          AtWallObject(DOORS[1],DOORS[2]);
             Wait(1000);
       }
    }
    public void checkbankdoors(){
       boolean blah = IsReachable(walkX[h], walkY[h]);
       if(blah == false){
          int[] DOORS1 = GetObjectById(64);
          if(DistanceTo(DOORS1[1], DOORS1[2]) > 3 && !IsReachable(DOORS1[1],DOORS1[2]))
             checkgates();
          else
          AtObject(DOORS1[1],DOORS1[2]);
             Wait(1000);
       }
    }
    public void checkgates(){
       boolean blah = IsReachable(walkX[h], walkY[h]);
       if(blah == false){
          int[] gate = GetObjectById(57);
          if(DistanceTo(gate[1], gate[2]) > 3 && !IsReachable(gate[1],gate[2]))
             checkupladder();
          else
          AtObject(gate[1],gate[2]);
             Wait(1000);
       }
    }
    public void checkupladder(){
        boolean blah = IsReachable(walkX[h], walkY[h]);
        if(blah == false){
           int[] ladders = GetObjectById(5);
           if(DistanceTo(ladders[1], ladders[2]) > 3 && !IsReachable(ladders[1], ladders[2]))
              checkdownladder();
           else
           AtObject(ladders[1], ladders[2]);
              Wait(4000);    
        }
       
    }
    public void checkdownladder(){
        boolean blah = IsReachable(walkX[h], walkY[h]);
        if(blah == false){
           int[] ladders1 = GetObjectById(downladder);
           if(DistanceTo(ladders1[1], ladders1[2]) > 3 && !IsReachable(ladders1[1], ladders1[2]))
              checkdoors();
           else
           AtObject(ladders1[1], ladders1[2]);
              Wait(4000);   
        }
    } 
    public void check(){
	checkdoors();
    }               
}
            	
            		