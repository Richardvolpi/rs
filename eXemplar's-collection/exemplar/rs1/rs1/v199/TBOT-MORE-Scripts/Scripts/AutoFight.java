import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class AutoFight extends Script 
{
        public boolean run_script = false;
 public boolean Eat = false;
 public boolean PickUp = false;
 public String StyleName;
 public int npcID, WaitTime, FightMode, PickType;
 public JFrame menuFrame;
 public JPanel menuPanel;
 public JLabel styleLabel, timeLabel, idLabel, pickLabel;
 public JTextField timeText, idText, pickText;
 public JButton Done;
 public JCheckBox eatCheck, pickCheck;
 public JComboBox styleBox; 
   public AutoFight(mudclient rs)
   {
       super(rs); 
   }
   public String[] getCommands()
   {
       return new String[]{"fight"}; 
   }
   public void start(String command, String parameter[])
   {
   javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 AddSettings();
             }
         });
         while(!run_script && running())
              wait(100);
         if(run_script)
         println("Autofighter by - Canibal");
         RunScriptor();
         println("Autofighter Successfully Stopped");
   }
   public void AddSettings(){
   menuFrame = new JFrame("Autofighter Settings");
   menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
   JPanel menuPanel = new JPanel(new GridLayout(6, 6));
   
   idLabel = new JLabel("NPC Type:", SwingConstants.LEFT);
   timeLabel = new JLabel("Macro Time:", SwingConstants.LEFT);
   styleLabel = new JLabel("Fighting Style:", SwingConstants.LEFT);
   pickLabel = new JLabel("Pick ID:", SwingConstants.LEFT);
   timeText = new JTextField("500",5);
   idText = new JTextField("1",5);
   pickText = new JTextField("1",5);
   Done = new JButton("Done");
   eatCheck = new JCheckBox("Auto Eat?");
   pickCheck = new JCheckBox("Auto Pick?");
   String StyleModes[] = {"Controlled", "Strength", "Attack", "Defence"};
   styleBox = new JComboBox(StyleModes);
   
   menuPanel.add(idLabel);
   menuPanel.add(idText);
   menuPanel.add(timeLabel);
   menuPanel.add(timeText);
   menuPanel.add(styleLabel);
   menuPanel.add(styleBox);
   menuPanel.add(eatCheck);
   menuPanel.add(pickCheck);
   menuPanel.add(pickLabel);
   menuPanel.add(pickText);
   menuPanel.add(Done);
   eatCheck.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
         Eat = true;
         }
        }
        );
   pickCheck.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
         PickUp = true;
         }
        }
        );
   Done.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
                run_script = true;
         npcID = Integer.parseInt(idText.getText());
         WaitTime = Integer.parseInt(timeText.getText());
         Object chosenStyleType = styleBox.getSelectedItem();
         StyleName = chosenStyleType.toString(); 
         PickType = Integer.parseInt(pickText.getText());
         }
        }
        );
        
   menuFrame.getContentPane().add(menuPanel, BorderLayout.CENTER);
                
   menuFrame.pack();
   menuFrame.setVisible(true);
   }
   public int GetNearestNpc(int id) {
    int npc = -1;
    int distance = 999999;
    for(int j = 0; j < npcCount(); j++)
    if (npcType(j) == id && canReachNpc(j) && !npcInCombat(j)){
    int temp = npcPathLength(j) - distance;
    if(temp < distance){
        npc = j;
        distance = temp;
       }
     }
     return npc;
    }
   public int GetNearestItem(int id) {
       int item = -1;
       int distance = 999999;
       for(int j = 0; j < itemCount(); j++)
       if (itemType(j) == id && canReach(itemX(j),itemY(j))){
       int temp = itemX(j) - distance;
       if(temp < distance){
       item = j;
       distance = temp;
       }
       } 
       return item;
       }
   public void RunScriptor(){
   menuFrame.dispose();
   if (StyleName.equalsIgnoreCase ("Controlled")) {FightMode = 0;} 
   if (StyleName.equalsIgnoreCase ("Strength")) {FightMode = 1;}
   if (StyleName.equalsIgnoreCase ("Attack")) {FightMode = 2;}
   if (StyleName.equalsIgnoreCase ("Defence")) {FightMode = 3;}
   while (running())
 {
  while (!myPlayerInCombat() && running())
  {
   if(!sleeping() && fatigue() < 90)
   {
    if (fightMode() != FightMode)
     setFightMode(FightMode);
    int ID = GetNearestNpc(npcID);     
    if (ID != -1)
    {
     if (!attackNpc(ID))
      println("There was an error attacking " + npcName(ID));
     long t = tickCount();
     while (tickCount() - t < WaitTime && !myPlayerInCombat())
      wait(1);
    } else {
                    for(int i = 0; i < itemCount(); i++)
      if(itemName(itemType(i)).equals(itemName(PickType)) && PickUp)      
      {
        int lastInvCount = invCount();
        if (!takeItem(i))
         println("There was an error picking up the " + itemName(i));
        long t = tickCount();
        while(tickCount() - t < random(2000,3000) && lastInvCount == invCount())
         wait(1);
      }
     wait(1);
    }
   } else
    if(!sleeping() && running())
    {
     wait(random(3000,4000));
     useByType(1263);
     wait(random(3000,4000));
    } else
     wait(1);
  }
  if (myPlayerHits() < 15 && Eat)
  {
   if(invByCommand("Eat") == -1)
   {
    println("No food found in Inventory - Quiting");
    disableAutoLogin();
    logout();
    endScript();
    return;
   } else {
    println("Eating at " + myPlayerHits());
    useByCommand("Eat");
    wait(random(2000,3000));
   }
  }
  while (myPlayerInCombat() && running())
  {
   if (fightMode() != FightMode)
    setFightMode(FightMode);
   wait(1);
  }
 }
 endScript();
   }
}