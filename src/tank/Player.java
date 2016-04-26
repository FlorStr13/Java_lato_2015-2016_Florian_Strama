package tank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Player {
    public String login;
    String pass;
    String email;
   
    public Player(String login,String pass,String email)
    {
        this.login=login;
        this.pass=pass;
        this.email=email;
    }
    
    public Player(String login,String pass)
    {
        this.login=login;
        this.pass=pass;
    }
    
    public String getLogin()
    {
        return login;
    }
    
    public String getPass()
    {
        return pass;
    }
    
    public String getEmail()
    {
        return email;
    }
     
}
