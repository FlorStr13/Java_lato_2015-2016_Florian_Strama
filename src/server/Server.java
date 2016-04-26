package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.swing.JOptionPane;

public class Server {
    
    public Server()
    {}
    
    ServerSocket listener;
    
    
    public void start() throws IOException {
        listener=new ServerSocket(9090);
        System.out.println( InetAddress.getLocalHost());
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                }
            catch(IOException e){ 
                JOptionPane.showMessageDialog(null, e);
            }
            }}
        catch(IOException e){ 
        JOptionPane.showMessageDialog(null, e);
        }
    }

    
}
