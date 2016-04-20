package tank;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class Game extends javax.swing.JFrame implements KeyListener {

    public Game() throws IOException {
        this.klocki = new TabKlockow(plansza.lvl);
        plansza.wpisz(klocki);
        initComponents();
        addKeyListener(this);   
        t1.start();       
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pole = new javax.swing.JPanel();
        stat = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);

        pole.setMaximumSize(new java.awt.Dimension(500, 500));
        pole.setMinimumSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout poleLayout = new javax.swing.GroupLayout(pole);
        pole.setLayout(poleLayout);
        poleLayout.setHorizontalGroup(
            poleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        poleLayout.setVerticalGroup(
            poleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        stat.setMaximumSize(new java.awt.Dimension(100, 500));
        stat.setMinimumSize(new java.awt.Dimension(100, 500));
        stat.setPreferredSize(new java.awt.Dimension(100, 500));

        javax.swing.GroupLayout statLayout = new javax.swing.GroupLayout(stat);
        stat.setLayout(statLayout);
        statLayout.setHorizontalGroup(
            statLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        statLayout.setVerticalGroup(
            statLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(stat, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(stat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   public  void  start() throws IOException{       
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
        this.setVisible(true);
       
    }
    //wszystkie zmiena
    PlayerTank tank=new PlayerTank();
    EnemyTank [] enemy=new EnemyTank[5];
    
    Arena plansza=Arena.getInstance();
    TabKlockow klocki;
    Bullet bullet;
    boolean bulletstate=false;
    
    //rysowanie
    @Override
    public void paint (Graphics g) {        
        Graphics2D g2 = (Graphics2D) g;   
        g2.drawImage(new ImageIcon("grafiki\\White.png").getImage(), 0, 0, 500, 500, null);
        pole.paintComponents(g2);
        stat.setBackground(Color.BLACK);
        for (Klocki klocki1 : klocki.klocki) {
            g2.drawImage(klocki1.icon, klocki1.x, klocki1.y, klocki1.w, klocki1.h, null);    
            pole.paintComponents(g2);
        }        
        g2.drawImage(tank.icon, tank.x, tank.y, 50, 50, null);    
        pole.paintComponents(g2);
        for (int i=0;i<enemy.length;i++)
        {
         g2.drawImage(enemy[i].icon, enemy[i].x, enemy[i].y, 50, 50, null);
         pole.paintComponents(g2);
        }
        if(bulletstate)
        {
          g2.drawImage(bullet.icon, bullet.x, bullet.y, 25, 25, null);
          pole.paintComponents(g2);
        }
        
    }
    
    /// poruszanie sie czolgow i pociskow itp
    Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
        for (int i=0;i<enemy.length;i++)
        {
            enemy[i]=new EnemyTank(20*i,25*i);
        
        }
        while(true){
              try {
                  Thread.sleep(25);
              } catch (InterruptedException ex) {
                  Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
              }
              for (int i=0;i<enemy.length;i++)
              {
                enemy[i].move();
                enemy[i].check();
                enemy[i].kolizja();
              }
              if(bulletstate)
              {
                  bullet.move();
                  if(bullet.check() || bullet.kolizja())
                  {  
                    bulletstate=false;
                  }
              }
              
            repaint();
          }
     }
    });  
     //opsluga przycikow
    @Override
    public void keyTyped(KeyEvent e) {
        
    if (e.getKeyCode() == KeyEvent.VK_W) {
           tank.staryY=tank.y;
           tank.staryX=tank.x;
           tank.y--; 
           tank.icon=tank.iconup;
           tank.state = PlayerTank.tankstate.UP;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_A )
    {
        tank.staryX=tank.x;
        tank.staryY=tank.y;
        tank.x--;
        tank.icon=tank.iconright;
        tank.state = PlayerTank.tankstate.LEFT;
    }
     if (e.getKeyCode() == KeyEvent.VK_D) {
        tank.staryY=tank.y;
        tank.staryX=tank.x;
        tank.x++; 
        tank.icon=tank.iconleft;
        tank.state = PlayerTank.tankstate.RIGHT;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_S )
    {
        tank.staryY=tank.y;
        tank.staryX=tank.x;
        tank.y++;
        tank.icon=tank.icondown;
         tank.state = PlayerTank.tankstate.DOWN;
    }
    tank.kolizja();
    tank.check();   
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
    @Override
    public void keyPressed(KeyEvent e) {   
    if (e.getKeyCode() == KeyEvent.VK_W) {
           tank.staryY=tank.y;
           tank.staryX=tank.x;
           tank.y--; 
           tank.icon=tank.iconup;
           tank.state = PlayerTank.tankstate.UP;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_A )
    {
        tank.staryX=tank.x;
        tank.staryY=tank.y;
        tank.x--;
        tank.icon=tank.iconright;
        tank.state = PlayerTank.tankstate.LEFT;
    }
     if (e.getKeyCode() == KeyEvent.VK_D) {
        tank.staryY=tank.y;
        tank.staryX=tank.x;
        tank.x++; 
        tank.icon=tank.iconleft;
        tank.state = PlayerTank.tankstate.RIGHT;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_S )
    {
        tank.staryY=tank.y;
        tank.staryX=tank.x;
        tank.y++;
        tank.icon=tank.icondown;
         tank.state = PlayerTank.tankstate.DOWN;
    }
    if (e.getKeyCode() == KeyEvent.VK_K )
    {
        try {
            nextLVL();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    if (e.getKeyCode() == KeyEvent.VK_SPACE)// && !bulletstate)
    {
         bulletstate=false;
         bullet=new Bullet(tank);
         bulletstate=true;
    }     
    tank.kolizja();
    tank.check();
    }   
    
    void nextLVL() throws FileNotFoundException //przejscie na kolejny poziom
    {
        plansza.lvl++;
        klocki=null;
        klocki= new TabKlockow(plansza.lvl); 
        plansza.wpisz(klocki);
        tank = null;
        tank = new PlayerTank();       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pole;
    private javax.swing.JPanel stat;
    // End of variables declaration//GEN-END:variables
}