package tank;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game extends javax.swing.JFrame implements KeyListener{

    public Game() {
        plansza.wpisz(klocki);
        initComponents();
        addKeyListener(this); 
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void start() {       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold> 
        java.awt.EventQueue.invokeLater(() -> {
            new Game().setVisible(true);
        });
        
    }
    
   
    
    PlayerTank tank=new PlayerTank();
    Rectangle re = new Rectangle(tank.x-1,tank.y-1,52,52);
    int x1=100;int y1=100;
    Image icon=tank.iconup;
    
    TabKlockow klocki=new TabKlockow();
    Arena plansza=new Arena();
 
    
    @Override
    public void paint (Graphics g) {        
        Graphics2D g2 = (Graphics2D) g;   
        kolizja();
        re.x=tank.x-1;
        re.y=tank.y-1;
        g2.setColor(Color.WHITE);
        g2.fill(re);
        g2.draw(re); 
        g2.drawImage(icon, tank.x, tank.y, 50, 50, null);
        for (Klocki klocki1 : klocki.klocki) {
            g2.drawImage(klocki1.icon, klocki1.x, klocki1.y, klocki1.w, klocki1.h, null);       
        }
        
    }
   
    
    public void check()
    {
        if(tank.x>500)
        {
            tank.x=500;
        }
        if(tank.x<0)
        {
            tank.x=0;
        }
        if(tank.y>475)
        {
            tank.y=475;
        }
        if(tank.y<25)
        {
            tank.y=25;
        }
    }
    
    void kolizja()
    {
        if(plansza.plansza[tank.x][tank.y]==1)
        {
            tank.x=tank.staryX;
            tank.y=tank.staryY;
        }
        if(plansza.plansza[tank.x+50][tank.y]==1)
        {
           tank.x=tank.staryX;
           tank.y=tank.staryY;
        }
        if(plansza.plansza[tank.x][tank.y+50]==1)
        {
           tank.x=tank.staryX;
           tank.y=tank.staryY;
        }
        if(plansza.plansza[tank.x+50][tank.y+50]==1)
        {
           tank.x=tank.staryX;
           tank.y=tank.staryY;
        }
        
    }
     
     
    @Override
    public void keyTyped(KeyEvent e) {
        
    if (e.getKeyCode() == KeyEvent.VK_W) {
           tank.staryY=tank.y;
           tank.staryX=tank.x;
           tank.y--; 
           icon=tank.iconup;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_A )
    {
        tank.staryX=tank.x;
        tank.staryY=tank.y;
        tank.x--;
        icon=tank.iconright;
    }
     if (e.getKeyCode() == KeyEvent.VK_D) {
        tank.staryY=tank.y;
           tank.staryX=tank.x;
        tank.x++; 
        icon=tank.iconleft;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_S )
    {
        tank.staryY=tank.y;
           tank.staryX=tank.x;
        tank.y++;
        icon=tank.icondown;
    }
    check();
    this.repaint();  
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    
    @Override
    public void keyPressed(KeyEvent e) {   
    if (e.getKeyCode() == KeyEvent.VK_W) {
          tank.staryY=tank.y;
           tank.staryX=tank.x;
          tank.y--; 
          icon=tank.iconup;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_A )
    {
        tank.staryY=tank.y;
           tank.staryX=tank.x;
        tank.x--;
        icon=tank.iconright;
    }
     if (e.getKeyCode() == KeyEvent.VK_D) {
        tank.staryY=tank.y;
           tank.staryX=tank.x;
        tank.x++; 
        icon=tank.iconleft;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_S )
    {
        tank.staryY=tank.y;
           tank.staryX=tank.x;
        tank.y++;
        icon=tank.icondown;
    }
    check();
    this.repaint();  
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}