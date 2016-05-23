package Database;

import java.sql.*;
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
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc);
        }
    }
    
    public boolean zarejestruj(ServerPlayer player) 
    {       
        String sql= "insert into players (Login,Pass,Email) values ('"+ player.getLogin()+ "','" +player.getPass()+"','"+player.getEmail()+"')";
       
        try{
            myStmt.executeUpdate(sql);
            return true;
        }
        catch(Exception exc)
        {
             return false;
        }
    }
    
    public boolean zaloguj(ServerPlayer player)
    {
        try{
            String stm ="SELECT * FROM Players Where Login = ?;";
            this.stmt=myConn.prepareStatement(stm);
            stmt.setString(1, player.getLogin());
            myRs = stmt.executeQuery();           
            while(myRs.next())
            {
                ServerPlayer login = new ServerPlayer(myRs.getString("Login"),myRs.getString("Pass"));
                if(player.getLogin().equals(login.getLogin()) && player.getPass().equals(login.getPass()))
                {
                    myRs.close();
                    return true;               
                }
                else
                {
                    myRs.close();
                    return false;
                }
            }
        }
        catch(Exception exc)
        {
            return false;
        }
        return false;
    }
    
    
    public void zmienHasło(ServerPlayer player)
    {
                     
        try{
            String stm ="UPDATE players SET pass='?' WHERE Login=?;";
            this.stmt=myConn.prepareStatement(stm);
            stmt.setString(1, player.getPass());
            stmt.setString(2, player.getLogin());
            myRs = stmt.executeQuery();  
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc);
        }   
    }    
    
     public void Delete(ServerPlayer player)
    {
        try{
            String stm ="DELETE FROM Players WHERE Login='?';";
            this.stmt=myConn.prepareStatement(stm);
            stmt.setString(1, player.getLogin());
            myRs = stmt.executeQuery();  
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc);
        }   
    }     
}
