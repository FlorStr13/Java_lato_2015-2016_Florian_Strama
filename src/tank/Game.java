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

    
    static void  start() throws IOException{       
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
            new Game().setVisible(true);
            
    }
    
    PlayerTank tank=new PlayerTank();
    EnemyTank enemy=new EnemyTank();
    Rectangle re = new Rectangle(tank.x-1,tank.y-1,52,52);
    
    Arena plansza=new Arena();
    TabKlockow klocki;
    
    @Override
    public void paint (Graphics g) {        
        Graphics2D g2 = (Graphics2D) g;   
        g2.drawImage(new ImageIcon("grafiki\\White.png").getImage(), 0, 0, 500, 500, null);
        pole.paintComponents(g2);
        kolizja();  
        g2.drawImage(tank.icon, tank.x, tank.y, 50, 50, null);
        g2.drawImage(enemy.icon, enemy.x, enemy.y, 50, 50, null);
        pole.paintComponents(g2);
        stat.setBackground(Color.BLACK);
        for (Klocki klocki1 : klocki.klocki) {
            g2.drawImage(klocki1.icon, klocki1.x, klocki1.y, klocki1.w, klocki1.h, null);    
            pole.paintComponents(g2);
        }
    }
    
    Thread t1 = new Thread(new Runnable() {
     @Override
     public void run() {
          while(true){
              try {
                  Thread.sleep(25);
              } catch (InterruptedException ex) {
                  Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
              }
            enemy.move();
            enemy.check();
            enemykolizja();
            repaint();
          }
     }
    });  
    
    
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

    void enemykolizja()
    {
        if(plansza.plansza[enemy.x][enemy.y]==1)
        {
            enemy.x=enemy.staryX;
            enemy.y=enemy.staryY;
        }
        if(plansza.plansza[enemy.x+50][enemy.y]==1)
        {
            enemy.x=enemy.staryX;
            enemy.y=enemy.staryY;
        }
        if(plansza.plansza[enemy.x][enemy.y+50]==1)
        {
            enemy.x=enemy.staryX;
            enemy.y=enemy.staryY;
        }
        if(plansza.plansza[enemy.x+50][enemy.y+50]==1)
        {
            enemy.x=enemy.staryX;
            enemy.y=enemy.staryY;
        }
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    if (e.getKeyCode() == KeyEvent.VK_W) {
           tank.staryY=tank.y;
           tank.staryX=tank.x;
           tank.y--; 
           tank.icon=tank.iconup;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_A )
    {
        tank.staryX=tank.x;
        tank.staryY=tank.y;
        tank.x--;
        tank.icon=tank.iconright;
    }
     if (e.getKeyCode() == KeyEvent.VK_D) {
        tank.staryY=tank.y;
        tank.staryX=tank.x;
        tank.x++; 
        tank.icon=tank.iconleft;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_S )
    {
        tank.staryY=tank.y;
        tank.staryX=tank.x;
        tank.y++;
        tank.icon=tank.icondown;
        this.setBackground(Color.WHITE);
    }
    tank.check();
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
        tank.icon=tank.iconup;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_A )
    {
        tank.staryY=tank.y;
        tank.staryX=tank.x;
        tank.x--;
        tank.icon=tank.iconright;
    }
     if (e.getKeyCode() == KeyEvent.VK_D) {
        tank.staryY=tank.y;
        tank.staryX=tank.x;
        tank.x++; 
        tank.icon=tank.iconleft;
    }  
    
    if (e.getKeyCode() == KeyEvent.VK_S )
    {
        tank.staryY=tank.y;
        tank.staryX=tank.x;
        tank.y++;
        tank.icon=tank.icondown;
    }
    if (e.getKeyCode() == KeyEvent.VK_K )
    {
        try {
            nextLVL();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    tank.check();
    this.repaint();  
    }   
    
    void nextLVL() throws FileNotFoundException
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