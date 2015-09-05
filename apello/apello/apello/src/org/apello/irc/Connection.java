/*
 *      Connection.java
 *
 *      Handles basic connection to the server. All input/output is buffered into two differant
 *          Queue's. There are two threads, an input thread for recieving, and an output thread for
 *          sending commands back to the server. This implementation is thread safe.
 */
 
package org.apello.irc;

import org.apello.util.Queue;

import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.util.List;

public class Connection {
    public Connection(String h, int p) throws Exception{
        host = h;
        port = p;
        connect();
    }
    
    private String host;
    private int port;
    private Socket sock;
    private BufferedReader bReader;
    private InputStream inStream;
    private OutputStream outStream;
    private Queue<byte[]> toSend;
    private Queue<String> recieved;
    private boolean connected;
    private Thread incomingT;
    private Thread outgoingT;

    // Sets up the Socket and input/output queue's, and the thread for each as well.
    public void connect() throws Exception{
        if(isConnected())
            return;
        toSend = new Queue<byte[]>();
        recieved = new Queue<String>();
        sock = new Socket(host, port);
        sock.setSoTimeout(300000);
        inStream = sock.getInputStream();
        bReader = new BufferedReader(new InputStreamReader(inStream));
        outStream = sock.getOutputStream();
        connected = true;
        incomingT = new Thread(new Runnable(){
            public void run(){
                listenForIncoming();
            }
        });
        outgoingT = new Thread(new Runnable(){
            public void run(){
                sendOutgoing();
            }
        });
        outgoingT.start();
        incomingT.start();
    }

    // Do we have an open connection to a server?
    public boolean isConnected(){
        return connected && sock != null && sock.isConnected();
    }

    // Returns's the servers host name
    public String getHostName(){
        return sock.getInetAddress().getHostName();
    }

    //Returns the current contents of the incoming queue, then empty's the queue as well.
    public List<String> getIncoming(){
        return recieved.getQueue();
    }

    //sends a line to the output buffer to be sent to the server.
    public void sendLine(String n){
        toSend.add((n + "\r\n").getBytes());
    }

    //send line directly to the server, skiping the  queue
    //DOES NOT DO ANY ERROR CHECKING AT ALL
    public void sendRawLine(String n){
        synchronized(outStream){
            try{
                outStream.write(n.getBytes());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    //closes connection to the server
    public void close(){
        if(!connected)
            return;
        else
            connected = false;
        System.out.println("Connection.close()");
            
        //synchronized(inStream){
        //    synchronized(outStream){
        //        synchronized(sock){
                    try{
                        inStream.close();
                    }catch(Exception e){}
                    
                    try{
                        outStream.close();
                    }catch(Exception e){}
                    
                    try{
                        sock.close();    
                    }catch(Exception e){}
                    
                    sock = null;
        //        }
        //    }
        //}
    }
    
    // The thread which listens for server responses
    public void listenForIncoming(){
        while(isConnected()){
            try{
                String n = bReader.readLine();
                if(n == null){
                    close();//the server disconnected us    
                    System.out.println("N WAS NULL");
                    continue;
                }
                recieved.add(n);
                try{
                    Thread.sleep(10);
                }catch(Exception e){}
            }catch(Exception e){
                e.printStackTrace();
                close();//stream error
                //break;
            }
        }
    }
    
    // The thread which sends data to the server
    public void sendOutgoing(){
        List<byte[]> m = null;
        while(isConnected()){
            try{ 
                try{
                    Thread.sleep(100);
                }catch(Exception e){}
                if(toSend.size() == 0)
                    continue;
                m = toSend.getQueue();
                for(int i = 0; i < m.size(); i++)
                    outStream.write(m.get(i));
            }catch(Exception e){
                e.printStackTrace();
                close();//stream error
                //break;
            }
        }
    }
}
