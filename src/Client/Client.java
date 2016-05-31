package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tank.Logowanie;
import tank.Menu;
import tank.Rejestracja;

public class Client  extends Thread{ 
    
    private static Client ourInstance=new Client();
    private Logowanie.MyListener loginlistner;
    private Rejestracja.MyListener registerlistner;
    private Menu.MyListener statlistener;
    
    public static Client getInstance() {
        return ourInstance;
    }
    
    private InetAddress ipAddress;   //adres serwera z ktorym sie łączymy
    private DatagramSocket socket;
    private boolean runnable=true;
    
    
    public Client() {
        try {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName("127.0.0.1");
        } catch (SocketException e) {
            runnable=false;
            e.printStackTrace();
        } catch (java.net.UnknownHostException ex) {
            runnable=false;
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }   
        this.start();
    }
    
    public void setRegisterListener(Rejestracja.MyListener mylistener) {
        this.registerlistner = mylistener;
    }
    
    public void setLoginListener(Logowanie.MyListener mylistener) {
        this.loginlistner = mylistener;
    }
    public void setStatListener(Menu.MyListener mylistener) {
        this.statlistener=mylistener;
    }
    
    @Override
    public void run() { 
        while(runnable){ 
             byte[] data = new byte[1024];
            DatagramPacket pakiet=new DatagramPacket(data,data.length);
            try{
                socket.receive(pakiet);
            }
            catch (IOException e) {
                runnable=false;
                e.printStackTrace();
            }
            receiveData(pakiet);
        }
        
    }

    public void receiveData(DatagramPacket pakiet)
    {
        int i;
       
            String massage = new String(pakiet.getData()).trim();
            i = Character.getNumericValue(massage.charAt(0));
            switch(i)
            {
                case Event.ZALOGOWANO:
                {
                    this.loginlistner.callback(); 
                }
                break;
                case Event.BLAD_LOGOWANIA:
                {
                    JOptionPane.showMessageDialog(null, "Bledny Login lub Hasło");
                }
                break;
                case Event.ZAJENTE_LOGOWANIE:
                {
                    JOptionPane.showMessageDialog(null, "Ktoś już jest zalogowany na tym koncie");
                }
                break;
                case Event.ZAREJESTROWANO:
                {
                    this.registerlistner.callback();
                }
                break;
                case Event.BLAD_REJESTRACJI:
                {
                    JOptionPane.showMessageDialog(null, "Bład rejestracji");
                }
                break;
                case Event.HASLO_ZMIENIONE:
                {
                    JOptionPane.showMessageDialog(null, "Zmiana hasła poprawna");
                }
                break;
                case Event.ZMIANA_HASLO_NIEPOWODZENIE:
                {
                    JOptionPane.showMessageDialog(null, "Zmiana hasła niepoprawna");
                }
                break;
                case Event.WYSYL_STATYSTYK:
                {
                    statlistener.callback(massage.substring(1));
                }
                break;
                default:
                {
                    JOptionPane.showMessageDialog(null, "Błedne dane dostarczone od servera");
                }
            }
  
    }

    
    public void sendLogin(String login, String pass)
    {
        byte[] data = new byte[1024];
        
        data = (Integer.toString(Packet.LOGIN) + login + "." +pass).getBytes();
        
        DatagramPacket pakiet = new DatagramPacket(data, data.length,ipAddress,9999);
        try {
            socket.send(pakiet);
        } catch (IOException e) {
            runnable=false;
            e.printStackTrace();
        }    
    }
    
    public void sendReg(String login, String pass,String email)
    {
        byte[] data = new byte[1024];
        
        data = ( Integer.toString(Packet.REJESTRACJA) + login + "." +pass+ "," + email).getBytes();
        
        DatagramPacket pakiet = new DatagramPacket(data, data.length,ipAddress,9999);
        try {
            socket.send(pakiet);
        } catch (IOException e) {
            runnable=false;
            e.printStackTrace();
        }
    }  
    
    public void zmianaPass(String login,String pass)
    {
        byte[] data = new byte[1024];
        
        data = (Integer.toString(Packet.ZMIANA_HASLA) + login + "." +pass).getBytes();
        
        DatagramPacket pakiet = new DatagramPacket(data, data.length,ipAddress,9999);
        try {
            socket.send(pakiet);
        } catch (IOException e) {
            runnable=false;
            e.printStackTrace();
        }    
    }
    
    public void wysylanieStatystyk(String login,int punkty)
    {
        byte[] data = new byte[1024];
        
        data = (Integer.toString(Packet.DODAJ_PUNKTY) + login + "." +punkty).getBytes();
        
        DatagramPacket pakiet = new DatagramPacket(data, data.length,ipAddress,9999);
        try {
            socket.send(pakiet);
        } catch (IOException e) {
            runnable=false;
            e.printStackTrace();
        }    
    }
    
    public void statRequest()
    {
         byte[] data = new byte[1024];
        
        data = (Integer.toString(Packet.STATYSTYKI)).getBytes();
        
        DatagramPacket pakiet = new DatagramPacket(data, data.length,ipAddress,9999);
        try {
            socket.send(pakiet);
        } catch (IOException e) {
            runnable=false;
            e.printStackTrace();
        }    
    }

    
}
