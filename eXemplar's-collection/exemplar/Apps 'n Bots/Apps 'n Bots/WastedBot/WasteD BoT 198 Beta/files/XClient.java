import java.io.*;
import java.net.*;

public class XClient{
InetAddress addr;
Socket socket;
public static BufferedWriter wr;
BufferedReader in;
String IP = "127.0.0.1";
String str2;
public XClient(){
    try {
        addr = InetAddress.getByName(IP);
        int port = 4002;
        socket = new Socket(addr, port);
        if(socket.isBound())
         { 
         System.out.println("[><] Java Server Connected");
         }
        } catch (UnknownHostException e) {
                                         } catch (IOException e) {
                                                                 }
   try {
        wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(System.in));
        while ((str2 = in.readLine()) != null) {
            wr.write(str2);
            wr.flush();     
                                               }
       } catch (IOException e) {
                               } 
                }
                
  public static void sendPacket(String s) {
   try {
     wr.write(s + ";");
     wr.write("");
     wr.flush();
     System.out.println("[>>] " + s + ";");   
       }
   catch (Exception e) {
    e.printStackTrace();
                       }
                                   }
                                   
  public static void sendPacketIG(String s) {
   try {
     wr.write(s + ";");
     wr.write("");
     wr.flush(); 
       }
   catch (Exception e) {
    e.printStackTrace();
                       }
                                   }
                                   
                                 
    
 }