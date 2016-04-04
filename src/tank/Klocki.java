package tank;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Klocki {
    public int x,y,w,h;
    Image icon;
    
    Klocki(int x,int y, int h, int w)
    {
        this.x=x;
        this.y=y;
        this.h=h;
        this.w=w;
        icon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Tank\\grafiki\\Gracz\\tankup.png").getImage();
    }
    
    Klocki()
    {
    }
}
