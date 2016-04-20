package tank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Player {
    String login;
    String pass;
    String email;
    Player(String login,String pass,String email)
    {
        this.login=login;
        this.pass=pass;
        this.email=email;
    }
    
    void zarejestruj() throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter writer = new PrintWriter("hasla.txt", "UTF-8");
        writer.println(login);
        writer.println(pass);
        writer.close();
    }
    
    void szyfrowanie()
    {
        for(int i=0;i<pass.length();i++)
        {
            char a=pass.charAt(i);      
        }
    
    }
    
    boolean zaloguj() throws FileNotFoundException{
        Scanner in = new Scanner(new File("hasla.txt"));
        String tmplogin,tmppass;
        tmplogin =  in.nextLine();
        tmppass =  in.nextLine();
        return (pass.equals(tmppass)) && (login.equals(tmplogin));
    }
}
