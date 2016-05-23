package servertank;

import Database.Database;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Server extends Thread{
        ServerPlayer gracz = new ServerPlayer();
        ServerPlayer[] players = new ServerPlayer[10];
        int ile;
        private DatagramSocket socket;
        Database database= Database.getInstance();
        
        public Server() {
            try {
                this.socket = new DatagramSocket(9999); //port na ktorym nasluchujemy
            } catch (SocketException e) {
                e.printStackTrace();
            }    
            for(int i=0;i<players.length;i++)
            {
                players[i]=new ServerPlayer();
            }
            ile=0;
        }
        
        
    public void run() {
        
        while(true) {      
            byte[] data = new byte[1024];
            DatagramPacket pakiet = new DatagramPacket(data, data.length);
            try {
                socket.receive(pakiet); //odbieramy data
            } catch (IOException e) {
                e.printStackTrace();
            }
            receiveData(pakiet);
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
            case ServerPacket.LOGIN:
            {
                
                boolean ifloged = false;
                int i=massage.indexOf(".");
                gracz.setAll(massage.substring(1, i), massage.substring(i+1),null, pakiet.getAddress(), pakiet.getPort());
                byte[] buf;
                System.out.print(gracz.login+" "+gracz.pass+"\n");
                for(int j=0;j<10;j++)
                {
                    if (players[j].login.equals(gracz.login) )
                    {
                        ifloged=true;
                    }
                }
                if(ifloged)
                {
                    buf=(Integer.toString(ServerEvent.ZAJENTE_LOGOWANIE)).getBytes();
                }
                else
                {
                    if(database.zaloguj(gracz))
                    {
                        players[ile].setAll(gracz.login, gracz.pass, null, gracz.ipAddress, gracz.port);
                        ile++;
                        buf = (Integer.toString(ServerEvent.ZALOGOWANO)).getBytes();//zalogowany 
                    }
                    else
                    {
                        buf = (Integer.toString(ServerEvent.BLAD_LOGOWANIA)).getBytes();
                    }
                } 
                pakiet.setData(buf);
                sendData(pakiet);
            }
            break;
            
            
            case ServerPacket.REJESTRACJA:
            {
                int i=massage.indexOf(".");
                int j=massage.indexOf(",");
                gracz.setAll(massage.substring(1, i), massage.substring(i+1,j),massage.substring(j+1), pakiet.getAddress(), pakiet.getPort());
                byte[] buf;
                if(database.zarejestruj(gracz))
                {
                   buf = (Integer.toString(ServerEvent.ZAREJESTROWANO)).getBytes();
                   
                }
                else
                {
                     buf = (Integer.toString(ServerEvent.BLAD_REJESTRACJI)).getBytes();
                }
                pakiet.setData(buf);
                sendData(pakiet);
            }
            break;
            
            case ServerPacket.ZMIANA_HASLA:
            {
                int i=massage.indexOf(".");
                gracz.setAll(massage.substring(1, i), massage.substring(i+1),null, pakiet.getAddress(), pakiet.getPort());
                database.zmienHasło(gracz);
            }
            break; 
        }
    }
    
    public void sendData(DatagramPacket pakiet)
    {
       try {
            socket.send(pakiet);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}

