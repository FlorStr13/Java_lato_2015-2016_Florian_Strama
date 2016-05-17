package servertank;

import Database.Database;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Server extends Thread{
        ServerPlayer gracz = new ServerPlayer();
        ServerPlayer[] players = new ServerPlayer[10];
        int ile=0;
        private DatagramSocket socket;
        Database database= Database.getInstance();
        
        public Server() {
            try {
                this.socket = new DatagramSocket(9999); //port na ktorym nasluchujemy
            } catch (SocketException e) {
                e.printStackTrace();
            }       
        }
        
        
       public void run() {
        byte[] data = new byte[1024];
        while(true) {           
            DatagramPacket pakiet = new DatagramPacket(data, data.length);
            try {
                socket.receive(pakiet); //odbieramy data
            } catch (IOException e) {
                e.printStackTrace();
            }
            receiveData(pakiet);
            System.out.print(gracz.login + "  " +gracz.pass);
        }
    }
    
    public void receiveData(DatagramPacket pakiet)
    {
        String massage = new String(pakiet.getData()).trim();
        int p ;
        try{
            p =Character.getNumericValue(massage.charAt(0));
        }
        catch(Exception e)
        {
            return;
        }
        switch (p)
        {
            case 1:
            {
                boolean ifloged = false;
                int i=massage.indexOf(".");
                gracz.setAll(massage.substring(1, i), massage.substring(i+1),null, pakiet.getAddress(), pakiet.getPort());
                byte[] buf;
                players[ile]=gracz;
                ile++;
                for(int j=0;j<10;j++)
                {
                    if (players[j].login.equals(gracz.login) )
                    {
                        ifloged=true;
                    }
                }  
                if(database.zaloguj(gracz) || ifloged)
                {
                   buf = "1".getBytes();//zalogowany
                 
                }
                else
                {
                    buf = "0".getBytes();
                }
               
                pakiet.setData(buf);
                try {
                   socket.send(pakiet);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
            
            case 4:
            {
                int i=massage.indexOf(".");
                int j=massage.indexOf(",");
                gracz.setAll(massage.substring(1, i), massage.substring(i+1,j),massage.substring(j), pakiet.getAddress(), pakiet.getPort());
                byte[] buf;
                if(database.zarejestruj(gracz))
                {
                   buf = "1".getBytes();
                   
                }
                else
                {
                    buf = "0".getBytes();
                }
                pakiet.setData(buf);
                try {
                   socket.send(pakiet);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }
    
    
}

