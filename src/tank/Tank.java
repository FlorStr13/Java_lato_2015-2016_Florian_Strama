package tank;

import Client.Client;
import Database.Database;
import java.io.IOException;
import server.Server;





public class Tank 
{
    public static void main(String[] args) throws IOException   {  
        Logowanie.start();
       // Server server= new Server();server.start();
               
        //Client client = new Client(); client.start();     
        Database database=new Database();
    }    
}
