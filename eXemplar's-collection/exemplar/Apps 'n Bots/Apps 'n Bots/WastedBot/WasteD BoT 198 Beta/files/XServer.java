import java.io.*;
import java.net.*;

public class XServer{
ServerSocket srv;
Socket socket;
BufferedReader rd;
String strRead = null;
        
public XServer(){
	try {
        int port = 4001;
        srv = new ServerSocket(port);
        socket = srv.accept();
        if(socket.isBound()) 
        System.out.println("[><] Java Server Connected"); 
    } catch (IOException e) {
    }
	try {
        rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true)
        {
           strRead = rd.readLine();
           System.out.println("[<<] " + strRead);
           mudclient.parseData(strRead);
        }
    } catch (IOException e) {
    }
	}
}