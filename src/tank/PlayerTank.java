package tank;

import java.awt.Image;
import javax.swing.ImageIcon;


public class PlayerTank {
public enum tankstate { LEFT, RIGHT , UP , DOWN };
    
    Image iconup;
    Image icondown;
    Image iconright;
    Image iconleft;
    Image icon;
    tankstate state;
    int x,y,staryX,staryY;
    
    
    public  PlayerTank(){
        x=170;
        y=450;
        staryX=x;
        staryY=y;
        state=tankstate.UP;
        iconup=new ImageIcon("grafiki\\Gracz\\tankup.png").getImage();
        icondown=new ImageIcon("grafiki\\Gracz\\tankdown.png").getImage();
        iconright=new ImageIcon("grafiki\\Gracz\\tankright.png").getImage();
        iconleft=new ImageIcon("grafiki\\Gracz\\tankleft.png").getImage();
        icon=iconup;
    }
    
    void check()
    {
        if(x>450)
        {
            x=450;
        }
        if(x<0)
        {
            x=0;
        }
        if(y>450)
        {
            y=450;
        }
        if(y<25)
        {
            y=25;
        }
    }
   
    Arena plansza=Arena.getInstance();
    void kolizja()
    {
        if(plansza.plansza[x][y]==1)
        {
            x=staryX;
            y=staryY;
        }
        if(plansza.plansza[x+50][y]==1)
        {
           x=staryX;
            y=staryY;
        }
        if(plansza.plansza[x][y+50]==1)
        {
           x=staryX;
           y=staryY;
        }
        if(plansza.plansza[x+50][y+50]==1)
        {
           x=staryX;
           y=staryY;
        }
    }
    
}
