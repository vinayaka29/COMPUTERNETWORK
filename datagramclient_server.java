//DatagramServer

import java.net.*;
import java.util.*;
public class DatagramSocketServer {
  public static void main(String[] args)throws Exception{
    Scanner in=new Scanner(System.in);
    DatagramSocket serverSocket=new DatagramSocket(9000) ;
    byte[] receiveData=new byte[1024];
    byte[] sendData=new byte[1024];
    System.out.println("****Server side****");
    DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
    serverSocket.receive(receivePacket);
    System.out.println(new String(receivePacket.getData()));
    InetAddress IPAddress=receivePacket.getAddress();
    int Port=receivePacket.getPort();
    while(true){
      System.out.println("type some message to display client end");
      String message=in.nextLine();
      sendData=message.getBytes();
      System.out.println("message sent from the serve:"+new String(sendData));
      DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,Port);
      serverSocket.send(sendPacket);
    }
  }
}



//Datagramclient

import java.net.*;
public class DatagramSocketclient {
    public static void main(String[] args)throws Exception{
        String line="Connected with client";
        DatagramSocket clientSocket=new DatagramSocket();
        InetAddress IPAddress=InetAddress.getByName("localhost");
        byte[] sendData=new byte[1024];
        byte[] recieveData=new byte[1024];
        sendData=line.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9000);
        clientSocket.send(sendPacket);
        System.out.println("****Client display terminal****");
        while(true){
            DatagramPacket receivePacket=new DatagramPacket(recieveData,recieveData.length);
            clientSocket.receive(receivePacket);
            String messageReceived=new String(receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());
            System.out.println("message typed at sever side is:"+messageReceived);
        }
    }
}
