import java.io.*; 
import java.awt.*; 
import java.util.*;
import java.awt.event.*; 
import javax.swing.*; 
import java.text.DateFormat;

public class login extends mudclient implements ActionListener { 
    JFrame options; 
    JPanel optsPanel; 
    JLabel optsModeLabel, optsLabel, emptylabel1, date; 
    JButton save, cancel, play; 
    JTextField optsMode;
    ImageIcon icon;
    JPasswordField opts;  
    JComboBox user;
    boolean run = true;
    String users[] = new String[100];
    String pass[] = new String[100];

    public login() { 
        loadnames();
        //icon = new ImageIcon(getClass().getResource("r2h.gif"));
        //setIconImage(icon.getImage());
        options = new JFrame("Simpleton Settings"); 
        options.setSize(new Dimension(300, 200)); 
options.setBackground(new Color(63, 131, 245));
        optsPanel = new JPanel(new GridLayout(4, 4)); 

        addWidgets(); 

        options.getRootPane().setDefaultButton(save); 

        options.getContentPane().add(optsPanel, BorderLayout.CENTER); 

        options.pack(); 
        options.setVisible(true); 
    } 
    public void addWidgets() {
        play = new JButton("", icon);
        optsModeLabel = new JLabel("Username:", SwingConstants.LEFT); 
        emptylabel1 = new JLabel("", SwingConstants.LEFT);
        user = new JComboBox(users);
        save = new JButton("Save"); 
        save.setBackground(new Color(78, 152, 248));
        save.setFont(new Font("Arial", 1, 11));
        save.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent actionevent)
        	{
      /*  		Object use = user.getSelectedItem();
        		String uk = use.toString();
        		for(int lb = 0; lb < users.length; lb++)
        		{
        	           		if(users[lb] == uk)
        	           		{
        	           		 	mudclient.user = uk;
        	           		 	mudclient.pass = pass[lb];
        	           		 }
        	           	}*/
        	}
        });
        cancel = new JButton("Close");
        cancel.setFont(new Font("Arial", 1, 11));
        cancel.setBackground(new Color(78, 152, 248)); 
        cancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent actionevent)
        	{
        	            options.setVisible(false);
        	}
        });
        optsPanel.add(optsModeLabel); 
        optsPanel.add(emptylabel1); 
        optsPanel.add(user); 
        optsPanel.add(save); 
        optsPanel.add(cancel);
        //optsPanel.add(play);
        optsModeLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
        optsLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
        optsPanel.setBackground(new Color(35, 91, 221)); 
        optsModeLabel.setForeground(Color.white); 
        optsLabel.setForeground(Color.white); 
    } 
    public void loadnames()
    {
    	int Lines = 0;
    	try{
    	RandomAccessFile randomaccessfile = new RandomAccessFile("settings.txt", "r");
    	for(String record = randomaccessfile.readLine(); record != null; record = randomaccessfile.readLine())
    	{
    		int l = record.indexOf(" ");
    		String u = record.substring(0,l);
    		String p = record.substring(l + 1);
    		users[Lines] = u;
    		pass[Lines] = p;
		Lines++;
    	}
      }catch(IOException e) { } 
          }
        public String date()
	{
		Date date1 = new Date();
		DateFormat dateformat = DateFormat.getDateInstance(3);
		String s = dateformat.format(date1);
		GregorianCalendar gregoriancalendar = new GregorianCalendar();
		int i = gregoriancalendar.get(10);
		int j = gregoriancalendar.get(12);
		int k = gregoriancalendar.get(13);
		int l = gregoriancalendar.get(14);
		String s1 = "" + j;
		if(j >= 0 && j <= 9)
			s1.concat("0" + j);
		String s2 = "" + k;
		if(k >= 0 && k <= 9)
			s2.concat("0" + k);
		int i1 = gregoriancalendar.get(9);
		String s3 = "" + i1;
		if(i1 == 1)
			s3 = "PM";
		else
			s3 = "AM";
		return i + ":" + s1 + ":" + s2 + " ";
	}
    public void actionPerformed(ActionEvent event) { 
        String FM = optsMode.getText();
        String FT = opts.getText(); 
        logout(); 
     JOptionPane.showMessageDialog(null,"Saved Settings: \n Username: "+FM+"\n Password: "+FT, 
    "Save Status",JOptionPane.PLAIN_MESSAGE);
        } 
        public void change()
        {
            System.out.println("Closed At: "+ date());
        	//try {
        	//	Thread.sleep(3000);
        	//}catch(Exception e) { }
        	System.exit(0);
        }
    public static void createAndShowlogin() 
    { 
       	SwingUtilities.invokeLater(new Runnable() {
	public void run()
            {
       	   JFrame.setDefaultLookAndFeelDecorated(true); 
                login prefs = new login(); 
            } 
        });
    }
    protected void exit() { 
    System.out.println("Closed At: "+ date());
    System.exit(0); 
  } 
}