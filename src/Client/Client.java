package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client  extends Thread{ 
    
    private static Client ourInstance=new Client();

    public static Client getInstance() {
        return ourInstance;
    }
    
    private InetAddress ipAddress;   //adres serwera z ktorym sie łączymy
    private DatagramSocket socket;
 
    public Client() {
        try {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName("127.0.0.1");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (java.net.UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Override
    public void run() { //nasluchiwanie
       
    }
    
    public void sendData(byte[] data) { //wysylanie danych
        DatagramPacket pakiet = new DatagramPacket(data, data.length, ipAddress, 9999);
        try {
            socket.send(pakiet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean sendLogin(String login, String pass)
    {
        byte[] data = new byte[1024];
        
        data = ( "1" + login + "." +pass).getBytes();
        
        DatagramPacket pakiet = new DatagramPacket(data, data.length,ipAddress,9999);
        try {
            socket.send(pakiet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            socket.receive(pakiet);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        int i;
        try{
            String massage = new String(pakiet.getData()).trim();
            i = Character.getNumericValue(massage.charAt(0));
            if(i==1)
            {
                return true;
            }
            else 
            {
                return false;
            }
            }
        catch(Exception e)
        {
            return false;
        }       
    }
    
    public boolean sendReg(String login, String pass,String email)
    {
        byte[] data = new byte[1024];
        
        data = ( "4" + login + "." +pass+ "," + email).getBytes();
        
        DatagramPacket pakiet = new DatagramPacket(data, data.length,ipAddress,9999);
        try {
            socket.send(pakiet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            socket.receive(pakiet);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        int i;
        try{
            String massage = new String(pakiet.getData()).trim();
            i =Character.getNumericValue(massage.charAt(0));
            if(i==1)
            {
                return true;
            }
            else 
            {
                return false;
            }
            }
        catch(Exception e)
        {
            return false;
        }       
    }
    
   
}
