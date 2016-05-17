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
    int x,y,staryX,staryY,height,widht;
    
    
    public  PlayerTank(){
        x=170;
        y=450;
        height=50;
        widht=50;
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
        if(plansza.plansza[x+widht][y]==1)
        {
           x=staryX;
           y=staryY;
        }
        if(plansza.plansza[x][y+height]==1)
        {
           x=staryX;
           y=staryY;
        }
        if(plansza.plansza[x+widht][y+height]==1)
        {
           x=staryX;
           y=staryY;
        }
    }
    
    void setInArena()
    {
        for (int i = staryX; i <staryX+widht ; i++) {
                for (int j = staryY; j < staryY+height; j++) {
                    plansza.plansza[i][j]=0;
                }
            }
    
         for (int i = x; i <x+widht ; i++) {
                for (int j = y; j < y+height; j++) {
                    plansza.plansza[i][j]=2;
                }
            }
    }
 
    
    public void setXY(int x,int y)
    {
        this.staryX=x;
        this.staryY=y;
        this.x=x;
        this.y=y;
    }
}
