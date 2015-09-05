// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;

// public class GUI extends JPanel implements ActionListener {

//     protected JTextArea textArea;
//         private JPanel mainPane;
//     private JButton pause, unpause;

//     public GUI() {
//         super(new GridBagLayout());

//         textArea = new JTextArea(30, 30);
//         textArea.setEditable(false);
//         JScrollPane scrollPane = new JScrollPane(textArea,
//                                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//                                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//         
//         for(int i = mc.line.length - 1; i > 0; i--)
//         if(mc.line[i] != null)
//         textArea.insert(mc.line[i] + "\n",0);
//         textArea.insert("Current script:\n-------------------------------\n",0);
//         GridBagConstraints c = new GridBagConstraints();
//         c.gridwidth = GridBagConstraints.REMAINDER;

//         c.fill = GridBagConstraints.HORIZONTAL;

//         c.fill = GridBagConstraints.BOTH;
//         
//         pause = new JButton("click to pause");
//         pause.addActionListener(this);
//         pause.setActionCommand("pause");
//         
//         unpause = new JButton("click to unpause");
//         unpause.addActionListener(this);
//         unpause.setActionCommand("unpause");
//         
//         c.weightx = 1.0;
//         c.weighty = 1.0;
//         add(scrollPane, c);
//     }

//     public void actionPerformed(ActionEvent evt) {
//     }

//     /**
//      * Create the GUI and show it.  For thread safety,
//      * this method should be invoked from the
//      * event-dispatching thread.
//      */
//     private static void createAndShowGUI() {
//         //Make sure we have nice window decorations.
//         JFrame.setDefaultLookAndFeelDecorated(true);

//         //Create and set up the window.
//         JFrame frame = new JFrame("NoNameBot text script viewer");
//         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//         //Create and set up the content pane.
//         JComponent newContentPane = new GUI();
//         newContentPane.setOpaque(true); //content panes must be opaque
//         frame.setContentPane(newContentPane);

//         //Display the window.
//         frame.pack();
//         frame.setVisible(true);
//     }

//     public static void main(String[] args) {
//         //Schedule a job for the event-dispatching thread:
//         //creating and showing this application's GUI.
//         javax.swing.SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 createAndShowGUI();
//             }
//         });
//     }
// }





















import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JPanel implements ActionListener {

    protected JTextArea textArea, textArea2;
    private JPanel mainPane, debugPane;
    private JButton pause, unpause, stop;
    public JFrame menuFrame;
    	public GUI(mc gui)
	{
		this.gui = gui;
	}	
	public mc gui;	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
            new Runnable() {
                public void run() {
                    GUI building = new GUI();
                    building.buildGui();
                }
            }
        );
    }
    
    public void add()
    {
	    textArea2.insert("kpls!\n",0);
    }
    
    public JComponent addTabbedPane() 
    {
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        
        mainPane = new JPanel(new GridBagLayout());
        
        textArea = new JTextArea();
        textArea.setEditable(false);
      
        JScrollPane scrollPane = new JScrollPane(textArea,
                                       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);                                   

        //Add Components to this panel.
        textArea.setFont(new Font("Courier New",0,12));
        if(mc.running)
        {
	        for(int i = mc.line.length - 1; i >= 0; i--)
	        if(mc.line[i] != null)
	        textArea.insert(mc.line[i] + "\n",0);
	        textArea.insert("Current script:\n-------------------------------\n",0);
        }
        else
        textArea.insert("There is no script running!",0);
     	
        stop = new JButton("End script");
        stop.addActionListener(this);
        stop.setActionCommand("end");   
        
        pause = new JButton("Pause script");
        pause.addActionListener(this);
        pause.setActionCommand("pause");
        
        unpause = new JButton("UnPause");
        unpause.addActionListener(this);
        unpause.setActionCommand("unpause");
        
        debugPane = new JPanel(new GridBagLayout());
        
        textArea2 = new JTextArea();
        textArea2.setEditable(false);  
        textArea2.insert("kpls!\n",0);
        
        JScrollPane scrollPane2 = new JScrollPane(textArea2,
                                       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);   
        
       	
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        
        mainPane.add(scrollPane,c);
        mainPane.add(pause);
        mainPane.add(unpause);
        mainPane.add(stop);
        debugPane.add(scrollPane2,c);        
        
        tabbedPane.addTab("Script", null, mainPane);
// 		tabbedPane.addTab("Debug Window", null, debugPane);
		
        return tabbedPane;
    }

    public void actionPerformed(ActionEvent evt) 
    {
         if(evt.getActionCommand().equals("pause"))
         {
              mc.paused = true;
              System.out.println("Script paused");
          }
         if(evt.getActionCommand().equals("unpause"))
         {
              mc.paused = false;
              System.out.println("Script unpaused");
          }
         if(evt.getActionCommand().equals("end"))
         {
              mc.running = false;
              System.out.println("Script ended");
          }          
    }
    public void buildGui() 
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        menuFrame = new JFrame("NoNameBot text script viewer");
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.getContentPane().add(addTabbedPane(), BorderLayout.CENTER);
        
        menuFrame.pack();
        menuFrame.setSize(400, 500);
        menuFrame.setVisible(true);
        menuFrame.setResizable(true);
    }
    public GUI() 
    {
        super(new BorderLayout(1, 1));
    } 
}