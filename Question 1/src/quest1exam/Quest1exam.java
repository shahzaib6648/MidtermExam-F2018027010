/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest1exam;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Quest1exam {
  
private static ServerSocket createServer;
private static int listenOn = 8521;
  
public static void main(String args[]) throws IOException, ClassNotFoundException{
createServer = new ServerSocket(listenOn);
while(true){
Socket socket = createServer.accept();
ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
String message = (String) ois.readObject();
System.out.println("Client Sent => " + message);
ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
oos.writeObject("Message from Server => "+message);
ois.close();
oos.close();
socket.close();
if(message.equalsIgnoreCase("shutdown")) break;
}
System.out.println("SERVER TERMINATED");
createServer.close();
}
}