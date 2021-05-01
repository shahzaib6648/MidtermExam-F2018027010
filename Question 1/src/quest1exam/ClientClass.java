/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest1exam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class ClientClass {

public static void main(String[] args) throws IOException, InterruptedException,UnknownHostException, ClassNotFoundException {
InetAddress host = InetAddress.getLocalHost();
Socket socket = null;
ObjectOutputStream oos = null;
ObjectInputStream ois = null;
for(int i=0; i<5;i++){
socket = new Socket(host.getHostName(), 8521);
oos = new ObjectOutputStream(socket.getOutputStream());
System.out.println(" == Server Connecting Now ==");
if(i==10)oos.writeObject("shutdown");
else oos.writeObject(""+i);
ois = new ObjectInputStream(socket.getInputStream());
String message = (String) ois.readObject();
System.out.println("Server Sent Back =>  " + message);
System.out.println(" === Closing Server Now ===");
ois.close();
oos.close();
Thread.sleep(100);
}
}
}
