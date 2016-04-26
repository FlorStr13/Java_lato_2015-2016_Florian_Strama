package tank;
import java.util.Random;
import javax.swing.ImageIcon;

public class EnemyTank extends PlayerTank{
    
    int numer=0;
    
    public  EnemyTank(){
        x=0;
        y=0;
        staryX=x;
        staryY=y;
        height=50;
        widht=50;
        iconup=new ImageIcon("grafiki\\Gracz\\tankup.png").getImage();
        icondown=new ImageIcon("grafiki\\Gracz\\tankdown.png").getImage();
        iconright=new ImageIcon("grafiki\\Gracz\\tankright.png").getImage();
        iconleft=new ImageIcon("grafiki\\Gracz\\tankleft.png").getImage();
        icon=iconup;
    }
    
    public EnemyTank(int x, int y,int n)
    {
        numer=n;
        this.x=x;
        this.y=y;
        staryX=x;
        staryY=y;
        iconup=new ImageIcon("grafiki\\Gracz\\tankup.png").getImage();
        icondown=new ImageIcon("grafiki\\Gracz\\tankdown.png").getImage();
        iconright=new ImageIcon("grafiki\\Gracz\\tankright.png").getImage();
        iconleft=new ImageIcon("grafiki\\Gracz\\tankleft.png").getImage();
        icon=icondown;
    }
    
    int n=0;
    int b=0;
    public void move() 
    {
        staryX=x;
        staryY=y;
      
        Random generator = new Random();
        if(b!=35)
        {
            b++;
        }
        else {
        n=generator.nextInt(4);
        b=0;
        }
        switch(n)
        {
            case 0: 
            {
                y--;
                icon=iconup;
            }
            break;
            case 1: 
            {
                x++;
                icon=iconleft;
            }
            break;
            case 2: 
            {
                y++;
                icon=icondown;
            }
            break;
            case 3: 
            {
                x--;              
                icon=iconright;
            }
            break;
        }
    }
    
    @Override
    void setInArena()
    {
        for (int i = staryX; i <staryX+widht ; i++) {
                for (int j = staryY; j < staryY+height; j++) {
                    plansza.plansza[i][j]=0;
                }
            }
    
         for (int i = x; i <x+widht ; i++) {
                for (int j = y; j < y+height; j++) {
                    plansza.plansza[i][j]=100+numer;
                }
            }
    }
    
    void setOutArena()
    {
            for (int i = staryX; i <staryX+widht ; i++) {
                for (int j = staryY; j < staryY+height; j++) {
                    plansza.plansza[i][j]=0;
                }
            }
            for (int i = x; i <x+widht ; i++) {
                for (int j = y; j < y+height; j++) {
                    plansza.plansza[i][j]=0;
                }
            }
    }
}
