import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class GuildFisher extends Script implements ActionListener
{
    boolean Running = true;
    Thread reportThread;
    Graphics g;    
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
    JFrame fishFrame, reportFrame;
    JPanel fishPanel, reportPanel;
    JLabel fishModeLabel, fishLabel, emptylabel1, pMode, pMins,pExp, pFished, pLevels, pSlept,empty;
    JButton save;
    JComboBox fishMode, fish;
   
    public GuildFisher(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"guildfish"};
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
    // pTitle, pMode, pMins, pFished, pLevels, pSlept;
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
           expgained = (GetStatXp(10) - startexp);
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
       
       
        private void addWidgets() {
        fishFrame = new JFrame("Bruncle's Guild Fisher: Preferences");
        fishFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fishFrame.setSize(new Dimension(325, 400));

        fishPanel = new JPanel(new GridLayout(4, 8));
       
        fishFrame.getRootPane().setDefaultButton(save);

        fishFrame.getContentPane().add(fishPanel, BorderLayout.CENTER);
        String fishModes[] = {"Fish then cert","Fish then cook then cert"};
        String fishs[] = {"Lobster","Shark"};
        fishModeLabel = new JLabel("Fishing Mode?", SwingConstants.LEFT);
          
        emptylabel1 = new JLabel("");
        fishLabel = new JLabel("Fish what?", SwingConstants.LEFT);
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
       
       
       public void RunScipt() {
       fishFrame.dispose();
       long time = System.currentTimeMillis(); starttime = time;
       sLevel=GetStat(10);
       setupReport();
       showReport();
       Display("@red@Hello "+System.getProperty("user.name")+" I know where you live..", 3);
       Wait(1000);   
       Display("@ran@Bruncle's guild lob fisher started", 3);
       int rawid = 0; int burntid = 0;
       startexp = GetStatXp(10); int certs = 4;
       GetSettings();
       if (fishtype.equalsIgnoreCase ("Lobster")) { rawid = 372; burntid = 374;}
       if (fishtype.equalsIgnoreCase ("Shark")) {rawid = 545; burntid = 546;}
       Display("You will "+FM+" "+fishtype,3);
       LastTime();
       Wait(2000);
       Display("@red@Script Starting in 5 seconds..",3);
       Wait(1000);
       Display("@gre@4",2);
       Wait(1000);
       Display("@gre@3",2);
       Wait(1000);
       Display("@gre@2",2);
       Wait(1000);
       Display("@gre@1",2);
       Wait(1000);
       Display("@ran@STARTING TO FISH "+fishtype,3);
       Wait(1000);
      while (Running())
      {
         showReport();
         Wait(1000);        
      while (CountInv() < 30 && Running())
      {
         showReport();
         if (fishtype.equalsIgnoreCase("Lobster"))
         {
            int spot[] = GetNearestObject(376);
            AtObject(spot[1],spot[2]);
            cMode = " fishing lobsters";
            showReport();
            Wait(1000);   
            if(GetLastServerMessage().equalsIgnoreCase("@gam@You catch a lobster"))
            {
             fishes++;
             ResetMessages();
            } 
         }
         if (fishtype.equalsIgnoreCase("Shark"))
         {
            int spot[] = GetNearestObject(261);
            AtObject2(spot[1],spot[2]);
            Wait(1000);
            cMode = " fishing sharks";
            showReport();
            if(GetLastServerMessage().equalsIgnoreCase("@gam@You catch a shark!"))
            {
             fishes++;
             ResetMessages();
            }
         }
         
      
         if (System.currentTimeMillis() - time > (5 * 60000))
         {
            cMode="Saving a report..";
            showReport();
            time = System.currentTimeMillis();
            Report();
         }
         if (Fatigue() >= 80 && Running())
         {
            cMode = " sleeping";
            showReport();
            while (!Sleeping() && Running())
            {
               UseItem(FindSlot(1263));
               Wait(3000);
            }
            while (Sleeping()){Wait(5000); }
            Wait(3000);           
            slept++;
         }
      }   
   if (CountInv() == 30 && Running())
   {
      showReport();
      if (FM.equalsIgnoreCase("Fish then cert") && Running())
      {
         cMode = " walking to certers";
         showReport();
         if (Running()){
         Wait(3000);
         WalkTillThere(602,506);
         WalkTillThere(605,503);
         Wait(2000);}
         while (GetX() == 603 && Running())
         {
         while (GetWallObjectAt(603,506) == 2)
         {
            cMode = " opening door";
            showReport();
            AtWallObject(603,506);
            Wait(2000);
         }
         WalkTillThere(605,503);
         Wait(1000);
         }
         if (Running())
         WalkTillThere(605,503);
         while (CountInv() == 30 && Running())
         {
               showReport();
               if (rawid == 372 && Running())
               {
                  cMode = " certing lobsters";
                  showReport();
                  while (!QuestMenu() && Running())
                  {
                  int[] npc = GetNearestNpc(369);
                     TalkToNpc(npc[0]);
                     Wait(1500);
                  }
                  showReport();
                  if (Running()){
                  Wait(1000);
                  Answer(1);
                  while (!QuestMenu())Wait(500);
                  Wait(1000);
                  Answer(1);
                  while (!QuestMenu())Wait(500);
                  Wait(1000);
                  Answer(4);
                  Wait(3000);
                  WalkTillThere(603,505);}
               }
               if (rawid == 545 && Running() )
               {
                  cMode = " certing sharks";
                  showReport();
                  while (!QuestMenu() && Running())
                  {
                     int[] npc = GetNearestNpc(370);
                     TalkToNpc(npc[0]);
                     Wait(1500);
                  }
                  Wait(1000);
                  Answer(1);
                  while (!QuestMenu())Wait(500);
                  Wait(1000);
                  Answer(3);
                  while (!QuestMenu())Wait(500);
                  Wait(1000);
                  Answer(4);
                  Wait(3000);
                  WalkTillThere(603,505);
               }
            }
            while (GetWallObjectAt(603,506) == 2 && Running())
            {
               cMode = " opening doors";
               showReport();
               AtWallObject(603,506);
               Wait(2000);
               WalkTillThere(602,507);
            }
            WalkTillThere(589,502);
      }
      if (FM.equalsIgnoreCase("Fish then cook then cert"))
      {
            if (Running()){
            cMode = " walking to range";
            showReport();
            WalkTillThere(587,508);
            WalkTillThere(586,518);
            Wait(1000);}
            while (GetY() == 518 && Running())
            {
               showReport();
               while (GetWallObjectAt(586,519) == 2)
               {
                  AtWallObject(586,519);
                  Wait(2000);
               }
               WalkTillThere(586,520);
               Wait(1000);
            }
            Wait(2000);
            while (CountInv(rawid) > 0 && Running())
            {
               cMode = " cooking fish";
               showReport();
               int[] stove = GetNearestObject(11);
               UseItemWithObject(FindSlot(rawid), stove[0]);
               Wait(2500);
               if (Fatigue() >= 80 && Running())
                  {
                     while (!Sleeping() && Running())
                     {
                        UseItem(FindSlot(1263));
                        Wait(3000);
                     }
                     while (Sleeping()) Wait(10000);                    
                     slept++;
                  }
            }
            while (CountInv(burntid) > 0 && Running())
            {
               DropItem(FindSlot(burntid));
               Wait(1500);
               cMode = " dropping burnt fish";
               showReport();
            }
            if (Running()){
            WalkTillThere(586,519);
            Wait(3000);}            
            showReport();
            while (GetWallObjectAt(586,519) == 2)
               {
                  AtWallObject(586,519);
                  Wait(2000);
               }
            WalkTillThere(586,518);
            Wait(1000);          
            if (Running()){
            WalkTillThere(602,506);
            WalkTillThere(605,503);
            Wait(2000);}
            while (GetX() == 603 && Running())
            {
               cMode = " opening door at certers";
               showReport();
               while (GetWallObjectAt(603,506) == 2)
               {
                  AtWallObject(603,506);
                  Wait(2000);
               }
               WalkTillThere(605,503);
               Wait(1000);
            }
            if (Running())
            WalkTillThere(605,503);
            while (CountInv() == 30 && Running())
            {

               if (fishtype.equals("Lobster") && Running())
               {
                  cMode = " certing lobsters";
                  showReport();
                  if (CountInv(373) < 25 && CountInv(373) >= 20) certs = 3;
                  if (CountInv(373) < 20 && CountInv(373) >= 15) certs = 2;
                  
                  while (!QuestMenu() && Running())
                  {
                     int[] npc = GetNearestNpc(369);
                     TalkToNpc(npc[0]);
                     Wait(1500);
                  }
                  Wait(1000);
                  Answer(1);
                  while (!QuestMenu())Wait(500);
                  Wait(1000);
                  Answer(0);
                  while (!QuestMenu())Wait(500);
                  Wait(1000);
                  Answer(certs);
                  Wait(2000);
                  WalkTillThere(603,505);
               }
               if (fishtype.equalsIgnoreCase("Shark") && Running())
               {
                  cMode = " certing shark";
                  if (CountInv(545) < 25 && CountInv(545) >= 20) certs = 3;
                  if (CountInv(545) < 20 && CountInv(545) >= 15) certs = 2;
                  if (CountInv(545) < 15 && CountInv(545) >= 10) certs = 2;
                  while (!QuestMenu() && Running())
                  {
                     int[] npc = GetNearestNpc(370);
                     TalkToNpc(npc[0]);
                     Wait(1500);
                  }
                  Wait(1000);
                  Answer(1);
                  while (!QuestMenu())Wait(500);
                  Wait(1000);
                  Answer(2);
                  while (!QuestMenu())Wait(500);
                  Wait(1000);
                  Answer(certs);
                  Wait(3000);
                  WalkTillThere(603,505);
               }
            }
            while (GetX() != 602 && Running())
            {
               cMode = " opening door at certers";
               showReport();
               while (GetWallObjectAt(603,506) == 2)
               {
                  AtWallObject(603,506);
                  Wait(2000);
               }
               WalkTillThere(602,503);
               Wait(1000);
            }
            if (Running())
            cMode = " walking back to the pier";
            showReport();
            WalkTillThere(589,502);
            Wait(3000);
      }
    }
   }
  Display("@dre@Stopped", 3);
  run = false;
}
   
public void Report()
{
      Date date;
              date = new Date();
             ctime = date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
           minutes = (System.currentTimeMillis() - starttime) / 60000;
      FileOutputStream output;
           PrintStream P;
           System.out.println("Writing Report..");
           expgained = (GetStatXp(10) - startexp);
           try
           {
              BufferedWriter out = null;
              out = new BufferedWriter( new FileWriter("guildfisher.txt", true));
              out.write("^^PrOgReSs RePoRt @ " + ctime+"..");
              out.newLine();
              out.write("After "+minutes+" minutes:");
              out.newLine();
              out.write("You have fished "+fishes+" "+fishtype+"[s]..");
              out.newLine();
              out.write("You have gained "+expgained +" fishing experience..");
              out.newLine();
              out.write("You have slept "+slept+" times..");
              out.newLine();
              out.close();
           }
           
            catch (Exception e)
                   {
                           System.err.println ("Error writing to file");
                   }
       
}
public void GetSettings()
{
   
}
public void LastTime()
{
   Display("Last time you ran the script this was the progress report..:",3);
   int line = 0;
   try
         {
                                 FileInputStream fstream = new
               FileInputStream("guildfisher.txt");
            DataInputStream in =
                                         new DataInputStream(fstream);
                                 int b;
                                 while ((b = in.read()) != -1)
                                 {
                                    if (b == '\n')
                                    line++;
                                 }
                                 in.close();
                         }
                         catch (Exception e)
         {
            Display("This is the first time you've run the script:O",3);
            System.err.println("File input error");
         }
                                 System.out.println("There are "+line+" lines in the text file..");
                                 int cline = 0;
                                 if (line >= 1774)
                                 {
                                    FileOutputStream out;
                         PrintStream p;

                         try
                         {
                       
                                    out = new FileOutputStream("guildfisher.txt");

                       
                                  p = new PrintStream( out );
      
                                   p.println ("");

                                  p.close();
                         }
                            catch (Exception e)
                          {
                                    System.err.println ("Error writing to file");
                          }
                            }
                        try {
                                 FileInputStream fstream2 = new
               FileInputStream("guildfisher.txt");
            DataInputStream in2 =
                                         new DataInputStream(fstream2);
                                 while (cline != (line - 5))
                                 {
                                    in2.readLine();
                                    cline++;
                                 }
                                 if (cline == line - 5)
                                 {
                                         Display(in2.readLine(),3);
                                         Wait(1000);   
               Display(in2.readLine(),3);
               Wait(1000);
               Display(in2.readLine(),3);
               Wait(1000);
               Display(in2.readLine(),3);
               Wait(1000);
               Display(in2.readLine(),3);
               Wait(1000);
            }
                  in2.close();
             }
                         catch (Exception e)
         {   
            System.err.println("File input error");
         }      
                      
}
/*
Just a temp method i have added before i add it to the bot methods, 
it will walk to the position untill u are there
*/
public void WalkTillThere(int x,int y)
{
	while(GetX() != x && GetY() != y) 
	{
		Walk(x,y);
		Wait(400);
	}
}

} 