package tank;
import java.util.Random;
import javax.swing.ImageIcon;

public class EnemyTank extends PlayerTank{
    
    public  EnemyTank(){
        x=0;
        y=0;
        staryX=x;
        staryY=y;
        iconup=new ImageIcon("grafiki\\Gracz\\tankup.png").getImage();
        icondown=new ImageIcon("grafiki\\Gracz\\tankdown.png").getImage();
        iconright=new ImageIcon("grafiki\\Gracz\\tankright.png").getImage();
        iconleft=new ImageIcon("grafiki\\Gracz\\tankleft.png").getImage();
        icon=iconup;
    }
    
    public EnemyTank(int x, int y)
    {
        this.x=x;
        this.y=y;
        staryX=x;
        staryY=y;
        iconup=new ImageIcon("grafiki\\Gracz\\tankup.png").getImage();
        icondown=new ImageIcon("grafiki\\Gracz\\tankdown.png").getImage();
        iconright=new ImageIcon("grafiki\\Gracz\\tankright.png").getImage();
        iconleft=new ImageIcon("grafiki\\Gracz\\tankleft.png").getImage();
        icon=iconup;
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
            }
            break;
            case 1: 
            {
                x++;
            }
            break;
            case 2: 
            {
                y++;
            }
            break;
            case 3: 
            {
                x--;
            }
            break;
        }
    }
}
