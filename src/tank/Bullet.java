package tank;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bullet {
    Image icon;
    int x,y;
    PlayerTank.tankstate state;
    
    Bullet(PlayerTank tank)
    {
        switch(tank.state)
        {
            case UP:
            {
               icon= new ImageIcon("grafiki\\Gracz\\tankup.png").getImage();
               x=tank.x+25;
               y=tank.y;
               state=PlayerTank.tankstate.UP;
            }
            break;
            case LEFT:
            {
               icon= new ImageIcon("grafiki\\Gracz\\tankup.png").getImage();
               x=tank.x-25;
               y=tank.y+25;
               state=PlayerTank.tankstate.LEFT;
            }
            break;
            case RIGHT:
            {
               icon= new ImageIcon("grafiki\\Gracz\\tankup.png").getImage();
               x=tank.x+50;
               y=tank.y+25;
               state=PlayerTank.tankstate.RIGHT;
            }
            break;
            case DOWN:
            {
               icon= new ImageIcon("grafiki\\Gracz\\tankup.png").getImage();
               x=tank.x+25;
               y=tank.y+50;
               state=PlayerTank.tankstate.DOWN;
            }
            break;
        }
    }
    
    void move()
    {
        switch(state)
        {
            case UP:
            {
               y-=2;
            }
            break;
            case LEFT:
            {
               x-=2;
            }
            break;
            case RIGHT:
            {
              x+=2;
            }
            break;
            case DOWN:
            {
              y+=2;
            }
            break;
        }
    
    }
    
    public boolean check()
    {
        if(x>475)
        {
            return true;
        }
        if(x<0)
        {
            return true;
        }
        if(y>475)
        {
            return true;
        }
        if(y<25)
        {
            return true;
        }
        return false;
    }
   
    Arena plansza=Arena.getInstance();
    boolean kolizja()
    {
        if(plansza.plansza[x][y]!=0)
        {           
           return true;
        }       
        return false;
    }
    
    int kolizja_tank()
    {
        if(plansza.plansza[x][y]!=0)
        {           
           return plansza.plansza[x][y];
        }       
        return 0;
    }
    
}
