package tank;

import java.awt.Image;
import javax.swing.ImageIcon;


public class PlayerTank {
//public enum tankstate = { MOVING, DESTROING,STAING };
    
     Image iconup;
     Image icondown;
     Image iconright;
     Image iconleft;
     int x,y,staryX,staryY;
    public  PlayerTank()
    {
        x=170;
        y=475;
        staryX=x;
        staryY=y;
        iconup=new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Tank\\grafiki\\Gracz\\tankup.png").getImage();
        icondown=new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Tank\\grafiki\\Gracz\\tankdown.png").getImage();
        iconright=new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Tank\\grafiki\\Gracz\\tankright.png").getImage();
        iconleft=new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Tank\\grafiki\\Gracz\\tankleft.png").getImage();
    }
}
