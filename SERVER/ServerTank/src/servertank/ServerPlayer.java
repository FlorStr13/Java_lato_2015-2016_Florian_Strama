package servertank;

import java.net.InetAddress;

public class ServerPlayer 
{
    int x,y;
    String login;
    String pass;
    String email;
    InetAddress ipAddress;
    int port;
    ServerPlayer(String login,String pass,InetAddress ipAddress,int port)
    {
        x=300;
        y=300;
        this.login=login;
        this.pass=pass;
        this.ipAddress=ipAddress;
        this.port=port;
    }
    ServerPlayer()
    {
        this.login="a";
        this.pass="a";
    }
    
    public ServerPlayer(String login,String pass)
    {
        this.login=login;
        this.pass=pass;
    }
    
    void setAll(String login,String pass,String email ,InetAddress ipAddress,int port)
    {
        x=300;
        y=300;
        this.login=login;
        this.pass=pass;
        this.email=email;
        this.ipAddress=ipAddress;
        this.port=port;
    }
    
    
    public String getLogin()
    {
        return this.login;
    }
    
    public String getPass()
    {
        return this.pass;
    }
    
    public String getEmail()
    {
        return email;
    }
}
