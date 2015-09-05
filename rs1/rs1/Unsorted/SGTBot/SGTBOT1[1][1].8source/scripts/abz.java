import java.awt.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
// Our imports ^

public class abz extends JFrame {



 // Our declarations start here, all the stuff we will use
 JButton authButton = new JButton();

 JTextField jTextField1 = new JTextField();

 XYLayout xYLayout1 = new XYLayout();

 JPasswordField jPasswordField1 = new JPasswordField();

 JLabel jLabel1 = new JLabel();
   // AlexZ rules


 JLabel jLabel2 = new JLabel();

 JLabel status = new JLabel();
 // Declerations end here


 // Constructor method, try the other method
 public abz() {
   try {
     jbInit();
   // AlexZ rules

   }
   catch(Exception e) {
     e.printStackTrace();
   }
 }


 // Main method, draws the screen
 public static void main(String[] args) {
   abz abz = new abz();
   abz.setVisible(true);
   abz.setTitle("Please Authorize:");
 }

 // Right all the shit happens here
 private void jbInit() throws Exception {
   authButton.setActionCommand("authButton");
   authButton.setText("Authorize");
   authButton.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(ActionEvent e) {
       authButton_actionPerformed(e);
     }
   });
   /* Allright we just added an action listner for our 'login'
    * button. It will run method 'authButton_actionPerformed(e);' */
   // AlexZ rules


   this.getContentPane().setLayout(xYLayout1);
   // Set our layout for the screen. xYLayout1 we declared before...

   jLabel1.setText("Username:");
   jLabel2.setText("Password:");
   this.setSize(new Dimension(512, 334));
   // Set size of auth window

   status.setBackground(UIManager.getColor("Desktop.background"));
   // Make the bgcolor of label to fit existing bg
   status.setToolTipText("Status");
   status.setText("An authorization is needed before using SgtBot");
   // AlexZ rules

   // Now we add all our features, with x1,y1,x2,y2 positions
   this.getContentPane().add(jTextField1, new XYConstraints(136, 18, 144, 24));
   this.getContentPane().add(jPasswordField1,  new XYConstraints(136, 47, 146, 26));
   // AlexZ rules

   this.getContentPane().add(jLabel1,  new XYConstraints(22, 19, 109, 26));
   this.getContentPane().add(jLabel2,   new XYConstraints(21, 50, 107, 28));
   this.getContentPane().add(authButton, new XYConstraints(136, 95, 123, 30));
   this.getContentPane().add(status, new XYConstraints(28, 145, 350, 23));
 }


 // Yup this is now what our button calls when pressed... pretty cool, calls authorize();
 void authButton_actionPerformed(ActionEvent e) {

   authorize(jTextField1.getText(),jPasswordField1.getText());
   //username = jTextField1.getText();
   //password = jPasswordField1.getText();

 }


 // Here's our sexy authorize method
 public void authorize(String username,String password)
 {
   // Checks if username and password are big enough
   if(username.length() > 2 && password.length() > 2) {
   try {
   // URL of site. Change it to fit wherever yours is

   // Initiate the URL
   URL siteURL = new URL(site);



      // DataInput, to read whether login was successful or failed.
      BufferedReader in = new BufferedReader(new InputStreamReader(siteURL.openStream()));

       // OK now just readout the output from site
       String str;
       String datasent = "";
       while ((str = in.readLine()) != null) {

           datasent = datasent + str;
       }
             in.close();


       // If result isnt -1 (fail) then autorize, initiate new mudclient
       if(datasent.indexOf("success") != -1) {

       this.setVisible(false);
	   //mudclient.access = true;
       mudclient mudclient1 = new mudclient();

       mudclient1.dje = false;

       mudclient1.emh = true;

       mudclient1.fme(mudclient1.dmj, mudclient1.dmk + 11, "bot", false);
       mudclient1.flf = 10;
	   //emh = true;
	   System.out.println("AUTHORIZATION RESPONCE: Accepted");




       }



       // Else they're norty and trying to login
       else {
        status.setText("Invalid Username, Password or Bad IP"); 
		System.out.println("AUTHORIZATION RESPONCE: Declined, invalid data input"); }
   }

    // Not catch all our exceptions for connecting bah bah bah bah
    catch(Exception e) {
	System.out.println("AUTHORIZATION RESPONCE: 404, server could not respond"); }




   }




 }
   //public String username;
   //public String password;
}
