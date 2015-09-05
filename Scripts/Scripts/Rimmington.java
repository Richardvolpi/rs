import java.awt.*; 
import java.net.*; 
import java.io.*; 
import java.util.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.applet.*; 

public class Rimmington extends Script implements ActionListener 
{ 
   Thread reportThread; 
   Graphics g; 
   public long time = System.currentTimeMillis(), starttime, secs; 
   public boolean run_script = false, Running = true;  
   public int ore = 0, level = 0,exp = 0, sleep = 0; 
   public String preferences[] = new String[2], minemode = "dunno"; 
   public String Action = "Starting"; 
  
   JFrame TheFrame, reportFrame; 
   JPanel ThePanel, reportPanel; 
   JLabel MineWhat, emptylabel1,Rdoin, Rsecs, Rores, Rlevl, Rexps, Rslep ,empty; 
   JButton save; 
   JComboBox MineMode; 
    
   public Rimmington(mudclient rs) 
   { 
       super(rs); 
   } 
   public String[] getCommands() 
   { 
       return new String[]{"rimmington"}; 
   }  
   public void ServerMessage(String message) 
   { 
      if (message.equals("@gam@You manage to obtain some copper ore")) 
      {    
          Action = "Mining Copper"; 
         ore++; 
         exp+=17.5; 
      } 
      if (message.equals("@gam@You manage to obtain some tin")) 
      {    
         Action = "Mining Tin"; 
         ore++; 
         exp+=17.5; 
      } 
      if (message.equals("@gam@You manage to obtain some iron ore")) 
      {    
         Action = "Mining Iron"; 
         ore++; 
         exp+=35; 
      } 
      if (message.equals("@gam@You manage to obtain some clay")) 
      {    
         Action = "Mining Clay"; 
         ore++; 
         exp+=5; 
      } 
      if (message.equals("@gam@You manage to obtain some gold")) 
      {    
         Action = "Mining Gold"; 
         ore++; 
         exp+=65; 
      } else        
      if (message.equals("@gre@You just advanced 1 mining level!")) 
      { 
        System.out.println('\u0007' + "Mining LEVEL! New Mining Level: " + GetCurrentStat(14)); 
        System.out.println('\u0007' + "Mining levels gained: " + level); 
        DisplayMessage("@gre@SBoT: @ran@<->@gre@ nice!! a miners level :D @ran@<->" , 3 ); 
        level++; 
      } 
   } 
   public void start(String command, String parameter[]) 
      { 
         javax.swing.SwingUtilities.invokeLater(new Runnable() 
         { 
            public void run() 
            { 
               addWidgets(); 
            } 
         }); 
         while(!run_script && Running()) 
         Wait(100); 
         if(run_script) 
         RunScipt(); 
      } 
      private void setupReport() 
      { 
         reportFrame = new JFrame("Ownage Rimmington: Progress Report"); 
         reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
         reportFrame.setSize(new Dimension(500, 400)); 
         reportPanel = new JPanel(new GridLayout(4, 8));  
         reportFrame.getContentPane().add(reportPanel, BorderLayout.CENTER);        
         Rdoin = new JLabel("You are currently " + Action); 
         Rsecs = new JLabel(" --> running for : " + secs + " <-- Seconds", SwingConstants.LEFT); 
       Rores = new JLabel("Total ore obtained:  " + ore, SwingConstants.LEFT); 
        Rlevl = new JLabel("Mining levels gained: " + level + " ( " + GetCurrentStat(14) + ")", SwingConstants.LEFT);    
      Rexps = new JLabel("You have gained " + exp + " mining experience", SwingConstants.LEFT); 
      Rslep = new JLabel("You have slept " + sleep +" times", SwingConstants.LEFT); 
      Rdoin.setFont(new Font("Helvetica",Font.BOLD,18)); 
      Rsecs.setFont(new Font("Helvetica",Font.BOLD,12)); 
     Rores.setFont(new Font("Helvetica",Font.BOLD,12)); 
      Rlevl.setFont(new Font("Helvetica",Font.BOLD,12)); 
      Rexps.setFont(new Font("Helvetica",Font.BOLD,12)); 
      Rslep.setFont(new Font("Helvetica",Font.BOLD,12)); 
    empty= new JLabel("" , SwingConstants.LEFT); 
    reportPanel.add(Rdoin); 
    reportPanel.add(empty);     
         reportPanel.add(Rsecs); 
         reportPanel.add(Rores); 
         reportPanel.add(Rlevl); 
         reportPanel.add(Rexps); 
         reportPanel.add(Rslep); 
         Rdoin.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));    
       Rsecs.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
       Rores.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
       Rlevl.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
       Rexps.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
       Rslep.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
         reportFrame.pack(); 
         reportFrame.setVisible(true); 
      }        
      public void showReport() 
      { 
         secs = (System.currentTimeMillis() - starttime) / 1000; 
         Rdoin.setText("You are currently "+ Action); 
         Rsecs.setText(" --> running for : " + secs + " <-- Seconds"); 
       Rores.setText("Total ore obtained:  " + ore); 
       Rlevl.setText("Mining levels gained: " + level + " ( " + GetCurrentStat(14) + " )");    
     Rexps.setText("You have gained " + exp + " mining experience"); 
      Rslep.setText("You have slept " + sleep +" times"); 
      SwingUtilities.updateComponentTreeUI(Rdoin);            
         SwingUtilities.updateComponentTreeUI(Rsecs); 
         SwingUtilities.updateComponentTreeUI(Rores); 
         SwingUtilities.updateComponentTreeUI(Rlevl); 
         SwingUtilities.updateComponentTreeUI(Rexps); 
         SwingUtilities.updateComponentTreeUI(Rslep); 
      }  
      private void addWidgets() 
      { 
         TheFrame = new JFrame("Ownage Rimmington: Preferences"); 
         TheFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
         TheFrame.setSize(new Dimension(500, 400)); 
        
         ThePanel = new JPanel(new GridLayout(4, 8)); 
        
         TheFrame.getRootPane().setDefaultButton(save); 

         TheFrame.getContentPane().add(ThePanel, BorderLayout.CENTER); 
         String MineModes[] = {"Clay","Copper","Tin","Iron","Gold"}; 
         MineWhat = new JLabel("Mine What?", SwingConstants.LEFT); 
            
         emptylabel1 = new JLabel(""); 
         MineMode = new JComboBox(MineModes); 
         save = new JButton("START!"); 
         save.addActionListener(this); 
          
         ThePanel.add(MineWhat); 
         ThePanel.add(MineMode); 
         ThePanel.add(save); 
         ThePanel.add(emptylabel1); 
              
         MineWhat.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));  

         ThePanel.setBackground(Color.black); 
         MineMode.setBackground(Color.black); 
         MineWhat.setForeground(Color.white); 
         MineMode.setForeground(Color.white); 
    
         TheFrame.pack(); 
         TheFrame.setVisible(true); 
      } 
      public void actionPerformed(ActionEvent event) 
      { 
         Object chosenfishMode = MineMode.getSelectedItem(); 
         minemode = chosenfishMode.toString();    
         run_script = true; 
      }  
      public void RunScipt() 
      { 
         TheFrame.dispose(); 
         setupReport(); 
         showReport(); 
         Wait(1000);    
         System.out.println("\nLIEK SysTem BeLL PL0se!!?"); 
         System.out.println('\u0007'); 
         DisplayMessage("@gre@SBoT:@whi@ Ownage Rimmington miner -> Fally Banker -@gre@ STARTED - @blu@YomamA",3); 
         System.out.println("\nYour mining level is... " + GetCurrentStat(14) + " lets get that a little higher :P" ); 
         long time = System.currentTimeMillis(); starttime = time;      
         while (Running() == true) 
         { 
            showReport(); 
            Wait(100); 
            if (System.currentTimeMillis() - time > (5 * 60000)) 
               { 
                  Action = "Saving a report.."; 
                  showReport(); 
                  time = System.currentTimeMillis(); 
               } 
            while (Running()  == true && InvCount() < 30) 
            { 
            showReport(); 
               if (Fatigue() >= 95 && Running() == true) 
               { 
                  while (Sleeping() == false) 
                  { 
                     Use(FindInv(1263)); 
                     Action = "Sleeping";      
                     Wait(2500); 
                sleep++; 
                  } 
                  while (Sleeping() == true) 
                  { 
                     Beep(); 
                     Wait(100); 
                  } 
               } 
               if (minemode.equalsIgnoreCase("Copper")) 
               { 
              int RockCoords[] = GetNearestObject(100); 
              AtObject(RockCoords[0],RockCoords[1]); 
                  Wait(1000); 
               } 
               if (minemode.equalsIgnoreCase("Tin")) 
               { 
                  int RockCoords[] = GetNearestObject(104); 
                  AtObject(RockCoords[0],RockCoords[1]); 
                  Wait(2250); 
               } 
               if (minemode.equalsIgnoreCase("Iron")) 
               {      
                  int RockCoords[] = GetNearestObject(102); 
                  if (RockCoords[0] > 317 && Running() == true) 
                  AtObject(RockCoords[0],RockCoords[1]); 
                  Wait(2000); 
               } 
               if (minemode.equalsIgnoreCase("Gold")) 
               {      
                  int RockCoords[] = GetNearestObject(114); 
                  AtObject(RockCoords[0],RockCoords[1]); 
                  Wait(2000); 
               } 
               if (minemode.equalsIgnoreCase("Clay")) 
               {      
                  int RockCoords[] = GetNearestObject(112); 
                  AtObject(RockCoords[0],RockCoords[1]); 
                  Wait(2000); 
               } 
            } 
            Action = "Walking to the bank";    
            ForceWalk(304,616); 
            ForceWalk(298,600); 
            ForceWalk(291,581); 
            ForceWalk(287,572);          
            Wait(100); 
            Action = "Talking to Banker"; 
            while (QuestMenu() == false) 
            { 
               int BankerID = GetNearestNPC(95); 
               TalkToNPC(BankerID); 
               Wait(1000); 
            } 
            Answer(0); 
            while (Bank() == false) 
               Wait(1); 
            while (InvCount(202) > 0) 
            { 
               Action = "Banking Ores"; 
               Deposit(202,1); 
               Wait(100); 
            } 
            while (InvCount(151) > 0) 
            { 
               Action = "Banking Ores"; 
               Deposit(151,1); 
               Wait(100); 
            } 
            while (InvCount(150) > 0) 
            {    
               Action = "Banking Ores"; 
               Deposit(150,1); 
               Wait(100); 
            } 
            while (InvCount(149) > 0) 
            { 
               Action = "Banking Ores"; 
               Deposit(149,1); 
               Wait(100); 
            } 
            while (InvCount(152) > 0) 
            { 
               Action = "Banking Ores"; 
               Deposit(152,1); 
               Wait(100); 
            } 
            while (InvCount(157) > 0) 
            { 
               Action = "Banking Ores"; 
               Deposit(157,1); 
               Wait(100); 
            } 
            while (InvCount(158) > 0) 
            { 
               Action = "Banking Ores"; 
               Deposit(158,1); 
               Wait(100); 
            } 
            while (InvCount(159) > 0) 
            { 
               Action = "Banking Ores"; 
               Deposit(159,1); 
               Wait(100); 
            } 
            while (InvCount(160) > 0) 
            { 
               Action = "Banking Ores"; 
               Deposit(160,1); 
               Wait(100); 
            } 
            CloseBank(); 
            Action = "Walking back"; 
            ForceWalk(287,572);          
            ForceWalk(291,581); 
            ForceWalk(298,600); 
            ForceWalk(304,616); 
            ForceWalk(309,631); 
            ForceWalk(313,636);          
       Wait(100);    
         } 
      DisplayMessage("@red@STOPPED", 3); 
   } 
} 
