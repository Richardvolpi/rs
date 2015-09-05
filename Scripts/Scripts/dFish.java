import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class dFish extends Script implements ActionListener
{
    boolean Running = true;
    public boolean sleep = false;
    public int fishes = 0;
    public String fishtype = "bruncle";
    public long starttime,minutes;
    public String preferences[] = new String[2];
    public int slept = 0;
    public int startexp = 0;
    public int expgained = 0;
    public String FM,ctime;
    boolean run_script = false;
    public String cMode = " doing nothing";
    public int fLevels,sLevel;
    boolean run = true;
    public JFrame fishFrame, reportFrame;
    public JPanel fishPanel, reportPanel;
    public JLabel fishModeLabel, fishLabel, emptylabel1, pMode, pMins,pExp, pFished, pLevels, pSlept,empty;
    public JButton save;
    public JComboBox fishMode, fish ;
    int rawid[] = {0,0}; int burntid = 0; int cookedids[] = {0,0};
   
    public void ServerMessage(String message)
    {
      if (message.equals("@gam@You are too tired to catch this fish")||message.equals("@gre@You are too tired to gain experience, get some rest"))
         {sleep = true;
         DisplayMessage("You need to sleep..",2);}
      if (message.indexOf("@gam@You catch a ")>= 0)
          fishes++;
    }   
   
    public dFish(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"dfish"};
    }
   
    private void addWidgets() {
        fishFrame = new JFrame("Bruncle's Draynor Fisher: Preferences");
        fishFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fishFrame.setSize(new Dimension(325, 400));

        fishPanel = new JPanel(new GridLayout(4, 8));
       
        fishFrame.getRootPane().setDefaultButton(save);

        fishFrame.getContentPane().add(fishPanel, BorderLayout.CENTER);
        String fishModes[] = {"Powerfish","Fish then bank","Fish then cook","Fish then cook then eat","Fish then cook then bank"};
        String fishs[] = {"Net","Bait"};
        fishModeLabel = new JLabel("Fishing Mode?", SwingConstants.LEFT);
         
        emptylabel1 = new JLabel("");
        fishLabel = new JLabel("Use what?", SwingConstants.LEFT);
        fishMode = new JComboBox(fishModes);
        save = new JButton("Save choices");
      fish = new JComboBox(fishs);
        save.addActionListener(this);
       
        fishPanel.add(fishModeLabel);
        fishPanel.add(fishMode);
        fishPanel.add(fishLabel);
        fishPanel.add(fish);
        fishPanel.add(save);
        fishPanel.add(emptylabel1);
         
        fishModeLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        fishLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        fishPanel.setBackground(Color.black);
        fish.setBackground(Color.black);
        fishMode.setBackground(Color.black);
        fishModeLabel.setForeground(Color.white);
        fishLabel.setForeground(Color.white);
        fishMode.setForeground(Color.white);
        fish.setForeground(Color.white);
   
        fishFrame.pack();
        fishFrame.setVisible(true);
        }

       public void actionPerformed(ActionEvent event) {
           Object chosenFishMode = fishMode.getSelectedItem();
           Object chosenFishType = fish.getSelectedItem();
           FM = chosenFishMode.toString();
           fishtype = chosenFishType.toString();   
           run_script = true;
       }
       
       public void start(String command, String parameter[])
       {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                  public void run() {
                      addWidgets();
                  }
              });
              while(!run_script && Running())
                     Wait(100);
              if(run_script)
                     RunScipt();
       }
       
       private void setupReport() {
        reportFrame = new JFrame("Bruncle's Guild Fisher: Progress Report");
        reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportFrame.setSize(new Dimension(325, 400));

        reportPanel = new JPanel(new GridLayout(4, 8));

        reportFrame.getContentPane().add(reportPanel, BorderLayout.CENTER);
       
        pMode = new JLabel("You are currently"+cMode);
        pMode.setFont(new Font("Helvetica",Font.BOLD,18));
        pMins = new JLabel("You have been fishing for " + minutes+" minutes", SwingConstants.LEFT);
        pMins.setFont(new Font("Helvetica",Font.BOLD,12));
        pFished = new JLabel("You have fished " + fishes+ " "+fishtype+"s", SwingConstants.LEFT);
        pFished.setFont(new Font("Helvetica",Font.BOLD,12));
        pLevels = new JLabel("You have gained " + fLevels+ " fishing levels", SwingConstants.LEFT);
        pLevels.setFont(new Font("Helvetica",Font.BOLD,12));
        pExp= new JLabel("You have gained " + expgained+ " fishing experience", SwingConstants.LEFT);
        pExp.setFont(new Font("Helvetica",Font.BOLD,12));
        pSlept = new JLabel("You have slept " + slept+" times", SwingConstants.LEFT);
        pSlept.setFont(new Font("Helvetica",Font.BOLD,12));
        empty= new JLabel("" , SwingConstants.LEFT);
       
        reportPanel.add(pMode);
        reportPanel.add(empty);
        reportPanel.add(pMins);
        reportPanel.add(pFished);
        reportPanel.add(pLevels);
        reportPanel.add(pExp);
        reportPanel.add(pSlept);
   
   pMode.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
   pMins.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
   pFished.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
   pLevels.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        pExp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
   pSlept.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        reportFrame.pack();
        reportFrame.setVisible(true);
        }
       
        public void showReport(){
           fLevels = GetStat(10)-sLevel;
           minutes = (System.currentTimeMillis() - starttime) / 1000;
           expgained = (GetExperience(10) - startexp);
           pMode.setText("You are currently"+cMode);
           pMins.setText("You have been fishing for " + minutes+" seconds");
           pFished.setText("You have fished " + fishes+" "+fishtype+"s");
           pLevels.setText("You have gained " + fLevels+ " fishing levels");
           pExp.setText("You have gained " + expgained+ " fishing experience");
           pSlept.setText("You have slept " + slept+" times");
           SwingUtilities.updateComponentTreeUI(pMode);
           SwingUtilities.updateComponentTreeUI(pMins);
           SwingUtilities.updateComponentTreeUI(pFished);
           SwingUtilities.updateComponentTreeUI(pLevels);
           SwingUtilities.updateComponentTreeUI(pExp);
           SwingUtilities.updateComponentTreeUI(pSlept);
        }
       
        public boolean pF(){
           if (FM.equalsIgnoreCase("Powerfish"))
              return true;
           else
              return false;
        }
       
        public boolean fF(){
           if (InvCount() == 30 && !pF())
              return true;
           else
              return false;
        }
       
       public void RunScipt() {
       
          fishFrame.dispose();
          long time = System.currentTimeMillis(); starttime = time;
          sLevel=GetStat(10);
          setupReport();
          showReport();
          DisplayMessage("@red@Hello "+System.getProperty("user.name")+" I know where you live..", 3);
          Wait(1000);   
          DisplayMessage("@ran@Bruncle's draynor fisher started", 3);
          startexp = GetExperience(10);
          if (fishtype.equalsIgnoreCase ("Net")) {
                rawid[0] = 349; rawid[1] = 351;
                burntid = 353;
                cookedids[0] = 350; cookedids[1] = 352;
          }
          if (fishtype.equalsIgnoreCase ("Bait")) {
                rawid[0] = 354; rawid[1] = 362;
                burntid = 365;
                cookedids[0] = 355; cookedids[1] = 362;
          }
          DisplayMessage("You will "+FM+" "+fishtype,3);
          Wait(2000);
          DisplayMessage("@red@Script Starting in 5 seconds..",3);
          Wait(1000);
          DisplayMessage("@gre@4",2);
          Wait(1000);
          DisplayMessage("@gre@3",2);
          Wait(1000);
          DisplayMessage("@gre@2",2);
          Wait(1000);
          DisplayMessage("@gre@1",2);
          Wait(1000);
          DisplayMessage("@ran@STARTING TO FISH "+fishtype,3);
          Wait(1000);
         while (Running())
         {
            showReport();
            while (!fF() && Running())
             {
                showReport();
               if (fishtype.equalsIgnoreCase("Net"))
               {
                  AtObject(GetNearestObject(193));
                  cMode = " netting fish";
                  showReport();
                  Wait(1000);   
               }
               if (fishtype.equalsIgnoreCase("Bait"))
               {
                  AtObject2(GetNearestObject(193));
                  Wait(1000);
                  cMode = " baiting fish";
                  showReport();
               }
               if (System.currentTimeMillis() - time > (5 * 60000))
                 {
                  cMode="Saving a report..";
                  showReport();
                  time = System.currentTimeMillis();
                 }
                 if (sleep && Fatigue() >= 80 && Running())
                {
                     cMode = " sleeping";
                     showReport();
                     while (!Sleeping() && Running())
                     {
                        Use(FindInv(1263));
                        Wait(3000);
                     }
                     while (Sleeping()){Wait(5000); }
                     Wait(3000);
                     sleep = false;
                     slept++;
               }
       }
      
       if (fF() && Running())
          {
               showReport();
               if (FM.equalsIgnoreCase("Fish then bank")){
                  cMode = " banking";
                  Walk(219,633);
                  while (!CanReach(217,635)){
                     AtObject(219,633);
                     Wait(1500);
                  }
                  Walk(219,635);
                  bankRaw();
                  while (!CanReach(219,632)){
                     AtObject(219,633);
                     Wait(1500);
                  }
                  Walk(272,603);
               }
               if (FM.equalsIgnoreCase("Fish then cook then eat")){
            while(GetNearestItem(14) == null && Running()){
               if (GetNearestObject(1) != null){
                  AtObject(GetNearestObject(1));
                  Wait(1500);
               }
            }
            while (GetNearestItem(14) != null && GetNearestObject(97) == null &&Running()){
               UseOnItem(GetNearestItem(14)[0],GetNearestItem(14)[1],14,FindInv(166));
               Wait(1000);
            }
            while (GetNearestObject(97)!= null && Running() && InvCount(rawid[0]) > 0 && InvCount(rawid[1]) > 0)
                  {
                     int fire[] = GetNearestObject(97);
                     UseOnObject(GetNearestObject(97)[0],GetNearestObject(97)[1],FindInv(rawid[0]));
                     Wait(1000);
                     if (Fatigue() > 97 && Running())
                      {
                           cMode = " sleeping";
                           showReport();
                           while (!Sleeping() && Running())
                           {
                              Use(FindInv(1263));
                              Wait(3000);
                           }
                           while (Sleeping()) Wait(5000);
                           Wait(3000);
                           sleep = false;
                           slept++;
                     }
                  }
                  if (InvCount(rawid[0]) == 0 && InvCount(rawid[1]) == 0 && Running()){
                     while (InvCount(burntid) > 0 && Running()){
                        Drop(FindInv(burntid));
                        Wait(1500);
                     }
                     while (InvCount(cookedids[0]) > 0){
                        Use(FindInv(cookedids[0]));
                        Wait(1500);
                     }
                     while (InvCount(cookedids[1]) > 0){
                        Use(FindInv(cookedids[1]));
                        Wait(1500);
                     }
                  }
                  Walk(221,661);
               }
               if (FM.equalsIgnoreCase("Fish then cook then bank")){
            while(GetNearestItem(14) == null && Running()){
               if (GetNearestObject(1) != null){
                  AtObject(GetNearestObject(1));
                  Wait(1500);
               }
            }
            while (GetNearestItem(14) != null && GetNearestObject(97) == null &&Running()){
               UseOnItem(GetNearestItem(14)[0],GetNearestItem(14)[1],14,FindInv(166));
               Wait(1000);
            }
            while (GetNearestObject(97)!= null && Running() && InvCount(rawid[0]) > 0 && InvCount(rawid[1]) > 0)
                  {
                     int fire[] = GetNearestObject(97);
                     UseOnObject(GetNearestObject(97)[0],GetNearestObject(97)[1],FindInv(rawid[0]));
                     Wait(1000);
                     if (Fatigue() > 97 && Running())
                      {
                           cMode = " sleeping";
                           showReport();
                           while (!Sleeping() && Running())
                           {
                              Use(FindInv(1263));
                              Wait(3000);
                           }
                           while (Sleeping()) Wait(5000);
                           Wait(3000);
                           sleep = false;
                           slept++;
                     }
                  }
                  if (InvCount(rawid[0]) == 0 && InvCount(rawid[1]) == 0 && Running()){
                     while (InvCount(burntid) > 0 && Running()){
                        Drop(FindInv(burntid));
                        Wait(1500);
                     }
                     while (InvCount(cookedids[0]) > 0){
                        Use(FindInv(cookedids[0]));
                        Wait(1500);
                     }
                     while (InvCount(cookedids[1]) > 0){
                        Use(FindInv(cookedids[1]));
                        Wait(1500);
                     }
                  }
                  cMode = " banking";
                  Walk(219,633);
                  while (!CanReach(217,635)){
                     AtObject(219,633);
                     Wait(1500);
                  }
                  Walk(219,635);
                  bankCooked();
                  while (!CanReach(219,632)){
                     AtObject(219,633);
                     Wait(1500);
                  }
                  Walk(272,603);
                  
                     
                    }
               }
            }
            DisplayMessage("Stopped Fishing",3);
            reportFrame.dispose();
         }
         
          public void bankRaw(){
            while (InvCount(rawid[0]) > 0 && InvCount(rawid[1]) > 0 && Running()){
                     while(!QuestMenu()){
                        TalkToNPC(GetNearestNPC(95));
                        Wait(2000);
                     }
                     Answer(0);
                     while(!Bank() && Running()) Wait(1);
                     while(Bank()){
                        while(InvCount(rawid[0]) > 0 && Running()){
                           Deposit(rawid[0],1);
                           Wait(500);
                        }
                        while(InvCount(rawid[1]) > 0 && Running()){
                           Deposit(rawid[1],1);
                           Wait(500);
                        }
                        CloseBank();
                     }
          }
          }
         
          public void bankCooked(){
            while (InvCount(cookedids[0]) > 0 && InvCount(cookedids[1]) > 0 && Running()){
                     while(!QuestMenu()){
                        TalkToNPC(GetNearestNPC(95));
                        Wait(2000);
                     }
                     Answer(0);
                     while(!Bank() && Running()) Wait(1);
                     while(Bank()){
                        while(InvCount(cookedids[0]) > 0 && Running()){
                           Deposit(cookedids[0],1);
                           Wait(500);
                        }
                        while(InvCount(cookedids[1]) > 0 && Running()){
                           Deposit(cookedids[1],1);
                           Wait(500);
                        }
                        CloseBank();
                     }
          }
         }

} 