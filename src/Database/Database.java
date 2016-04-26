package Database;

import java.sql.*;
import javax.swing.JOptionPane;
import tank.Player;

public class Database {
 
    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }
    
    
    Connection myConn = null;
    Statement myStmt=null;
    ResultSet myRs = null;
    
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
    
    public void zarejestruj(Player player) 
    {       
        String sql= "insert into players (Login,Pass,Email) values ('"+ player.getLogin()+ "','" +player.getPass()+"','"+player.getEmail()+"')";
        try{
            myStmt.executeUpdate(sql);
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc);
        }
    }
    
    public boolean zaloguj(Player player)
    {
        try{
            myRs=myStmt.executeQuery("select * from players");
            while(myRs.next())
            {
                Player login = new Player(myRs.getString("Login"),myRs.getString("Pass"));
                if(player.getLogin()==login.getLogin() && player.getPass()==login.getPass())
                {
                    myRs.close();
                    return true;
                    
                }
            }
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc);
        }
        return false;
    }
}
