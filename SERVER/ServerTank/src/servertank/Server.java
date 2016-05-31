package servertank;

import Database.Database;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;



public class Server extends Thread{
        ServerPlayer gracz = new ServerPlayer();
        ServerPlayer[] players = new ServerPlayer[10];
        int ile;
        private DatagramSocket socket;
        Database database= Database.getInstance();
        private boolean runnable=true;
        
        Logi logi = new Logi();
        
        public Server() {
            try {
                this.socket = new DatagramSocket(9999); //port na ktorym nasluchujemy
            } catch (SocketException e) {
                runnable=false;
                logi.write(e.toString());
            }    
            for(int i=0;i<players.length;i++)
            {
                players[i]=new ServerPlayer();
            }
            ile=0;
        }
        
        
    public void run() {
        
        while(runnable) {      
            byte[] data = new byte[1024];
            DatagramPacket pakiet = new DatagramPacket(data, data.length);
            try {
                socket.receive(pakiet); //odbieramy data
            } catch (IOException e) {
                logi.write(e.toString());
                runnable=false;   
            }
            receiveData(pakiet);
        }
    }
    
    public void receiveData(DatagramPacket pakiet)
    {
        String massage = new String(pakiet.getData()).trim();
        System.out.print(massage+"\n");
        int p;
        p = Character.getNumericValue(massage.charAt(0));
        
        switch (p)
        {
            case ServerPacket.LOGIN:
            {
                logi.write(LogiTxt.LOGIN+massage);
                boolean ifloged = false;
                int i=massage.indexOf(".");
                gracz.setAll(massage.substring(1, i), massage.substring(i+1),null, pakiet.getAddress(), pakiet.getPort());
                byte[] buf;
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
                    logi.write(LogiTxt.ZAJENTE_LOGOWANIE);
                }
                else
                {
                    if(database.zaloguj(gracz))
                    {
                        players[ile].setAll(gracz.login, gracz.pass, null, gracz.ipAddress, gracz.port);
                        ile++;
                        buf = (Integer.toString(ServerEvent.ZALOGOWANO)).getBytes();//zalogowany 
                        logi.write(LogiTxt.ZALOGOWANO);
                    }
                    else
                    {
                        buf = (Integer.toString(ServerEvent.BLAD_LOGOWANIA)).getBytes();
                        logi.write(LogiTxt.BLAD_LOGOWANIA);
                    }
                } 
                pakiet.setData(buf);
                sendData(pakiet);
            }
            break;
            
            
            case ServerPacket.REJESTRACJA:
            {
                logi.write(LogiTxt.REJESTRACJA+massage);
                int i=massage.indexOf(".");
                int j=massage.indexOf(",");
                gracz.setAll(massage.substring(1, i), massage.substring(i+1,j),massage.substring(j+1), pakiet.getAddress(), pakiet.getPort());
                byte[] buf;
                if(database.zarejestruj(gracz))
                {
                   buf = (Integer.toString(ServerEvent.ZAREJESTROWANO)).getBytes();
                   logi.write(LogiTxt.ZAREJESTROWANO);
                   
                }
                else
                {
                     buf = (Integer.toString(ServerEvent.BLAD_REJESTRACJI)).getBytes();
                     logi.write(LogiTxt.BLAD_REJESTRACJI);
                }
                pakiet.setData(buf);
                sendData(pakiet);
            }
            break;
            
            case ServerPacket.ZMIANA_HASLA:
            {
                logi.write(LogiTxt.ZMIANA_HASLA+massage);
                int i=massage.indexOf(".");
                gracz.setAll(massage.substring(1, i), massage.substring(i+1),null, pakiet.getAddress(), pakiet.getPort());
                byte[] buf;
                if(database.zmienHasło(gracz))
                {
                     buf = (Integer.toString(ServerEvent.HASLO_ZMIENIONE)).getBytes();
                     logi.write(LogiTxt.HASLO_ZMIENIONE);
                }
                else
                {
                     buf = (Integer.toString(ServerEvent.ZMIANA_HASLO_NIEPOWODZENIE)).getBytes();
                     logi.write(LogiTxt.ZMIANA_HASLO_NIEPOWODZENIE);
                }
                pakiet.setData(buf);
                sendData(pakiet);
            }
            break; 
            
            case ServerPacket.DODAJ_PUNKTY:
            {
                logi.write(LogiTxt.DODAJ_PUNKTY+massage);
                int i=massage.indexOf(".");
                gracz.setAll(massage.substring(1, i), null,null, pakiet.getAddress(), pakiet.getPort());
                int punkt=Integer.parseInt(massage.substring(i+1));
                byte[] buf;
                database.dodajStat(gracz, punkt);
            }
            break;
            
            case ServerPacket.STATYSTYKI:
            {
                byte[] buf;
                String stat=(Integer.toString(ServerEvent.WYSYL_STATYSTYK))+database.stat();
                buf=stat.getBytes();
                pakiet.setData(buf);
                sendData(pakiet);
            }
            break;
        }
    }
    
    public void sendData(DatagramPacket pakiet)
    {
       try {
            socket.send(pakiet);
        } catch (IOException ex) {
            runnable=false;
            logi.write(ex.toString());
        }
    
    }
    
    
    
}

