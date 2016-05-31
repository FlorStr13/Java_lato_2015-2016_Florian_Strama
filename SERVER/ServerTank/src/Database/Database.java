package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import servertank.ServerPlayer;

public class Database {
 
    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }
    
    
    Connection myConn = null;
    Statement myStmt=null;
    ResultSet myRs = null;
    PreparedStatement stmt = null;
    
    String user = "root";
    String pass = "strama13";
    
    public Database()
    {
    
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tanks", user, pass);       
            myStmt=myConn.createStatement();
        }
        catch(SQLException exc)
        {
            JOptionPane.showMessageDialog(null, exc);
            System.exit(1);
        }
    }
    
    public boolean zarejestruj(ServerPlayer player) 
    {       
        String sq1= "insert into players (Login,Pass,Email) values (?,?,?)";
        String sql2="INSERT INTO stat (ID,punkty) values (?,0)";
        
        try{
            this.stmt=myConn.prepareStatement(sq1);
            this.stmt.setString(1, player.getLogin());
            this.stmt.setString(2, player.getPass());
            this.stmt.setString(3, player.getEmail());
            stmt.executeUpdate();
            
            String stm ="SELECT * FROM Players Where Login = ?";
            this.stmt=myConn.prepareStatement(stm);
            this.stmt.setString(1, player.getLogin());
            myRs = stmt.executeQuery();
            int i=0;
            while(myRs.next())
            {
                i=myRs.getInt("ID");
            }
            
            this.stmt=myConn.prepareStatement(sql2);
            this.stmt.setInt(1, i);
            stmt.executeUpdate();
            return true;
        }
        catch(SQLException exc)
        {
             return false;
        }
    }
    
    public boolean zaloguj(ServerPlayer player)
    {
        try{
            String stm ="SELECT * FROM Players Where Login = ?;";
            this.stmt=myConn.prepareStatement(stm);
            this.stmt.setString(1, player.getLogin());
            myRs = stmt.executeQuery();           
            while(myRs.next())
            {
                ServerPlayer login = new ServerPlayer(myRs.getString("Login"),myRs.getString("Pass"));
                if(player.getLogin().equals(login.getLogin()) && player.getPass().equals(login.getPass()))
                {
                    stmt.close();
                    myRs.close();
                    return true;               
                }
                else
                {
                    stmt.close();
                    myRs.close();
                    return false;
                }
            }
        }
        catch(SQLException exc)
        {
            return false;
        }
        return false;
    }
    
    
    public boolean zmienHasło(ServerPlayer player)
    {
                     
        try{
            String stm ="UPDATE players SET pass = ? \n"+" WHERE Login = ?;";
            this.stmt=myConn.prepareStatement(stm);
            stmt.setString(1, player.getPass());
            stmt.setString(2, player.getLogin());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }
        catch(SQLException exc)
        {
            JOptionPane.showMessageDialog(null, exc);
            return false;
        }   
    }    
    
     public void Delete(ServerPlayer player)
    {
        try{
            String stm ="DELETE FROM Players WHERE Login='?';";
            this.stmt=myConn.prepareStatement(stm);
            stmt.setString(1, player.getLogin());
            myRs = stmt.executeQuery();  
            stmt.close();
            myRs.close();
        }
        catch(SQLException exc)
        {
            JOptionPane.showMessageDialog(null, exc);
        }   
    }     
     
    public boolean dodajStat(ServerPlayer player,int punkt)
    {
        try {
            String stm ="SELECT * FROM Players Where Login = ?;";
            this.stmt=myConn.prepareStatement(stm);
            this.stmt.setString(1, player.getLogin());
            myRs = stmt.executeQuery();
            int i=0;
            int tmp=0;
            myRs.next();
            
            i=myRs.getInt("ID");
           
            stm ="SELECT * FROM Stat Where ID = ?;";
            this.stmt=myConn.prepareStatement(stm);
            this.stmt.setInt(1, i);
            myRs = stmt.executeQuery();
            myRs.next();
            
            tmp=myRs.getInt("Punkty");
            punkt+=tmp;
            String sql2="UPDATE stat SET Punkty = ?  WHERE ID = ?;";
            this.stmt=myConn.prepareStatement(sql2);
            this.stmt.setInt(1, punkt);
            this.stmt.setInt(2, i);
            stmt.executeUpdate();
            stmt.close();
            myRs.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
     
    public String stat()
    {
        String staty="<html>";
        try { 
            String sql="SELECT players.ID, players.Login, stat.Punkty FROM players INNER JOIN stat ON players.ID=stat.ID ORDER BY stat.Punkty DESC LIMIT 5;";
            this.stmt=myConn.prepareStatement(sql);
            myRs = stmt.executeQuery();
            
            Statystyki [] stat = new Statystyki[10];
            for(int i=0;i<10;i++)
            {
                stat[i]=new Statystyki();
            }
            int j=0;
            while(myRs.next() && j<10)
            {
                stat[j].setStatystyki(myRs.getString("Login"), myRs.getInt("Punkty"));
                j++;
            }
            
            for(int i=0;i<10;i++)
            {
                staty+=stat[i].nick+"\t"+stat[i].punkty+"<br>";
            }
            staty+="</html>";
            
            return staty;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staty;
    }
    
  /*SELECT players.ID, players.Login, stat.Punkty
    FROM players
    INNER JOIN stat
    ON players.ID=stat.ID
    ORDER BY stat.Punkty DESC
    LIMIT 5;*/
    
    class Statystyki
    {
        String nick;
        int punkty;
        
        void setStatystyki(String nick,int punkty)
        {
           this.nick=nick;
           this.punkty=punkty;
        }
       
        Statystyki()
        {
            this.nick="Brak";
            this.punkty=0;
        }
    }
}
