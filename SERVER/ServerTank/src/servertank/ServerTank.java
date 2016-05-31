package servertank;

import Database.Database;

public class ServerTank {
    public static void main(String[] args){
       Server server= new Server();
       //server.start();
       Database data=Database.getInstance();
       System.out.print(data.stat());
    }    
}


