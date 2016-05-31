package tank;

import Client.Client;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public final class Menu extends javax.swing.JFrame {
    public interface MyListener {
        public void callback(String text);
    }
    Client client=Client.getInstance();
    
    Player player=new Player();
    public Menu() 
    {
        loadImg();
        initComponents();
        start.setBackground(Color.red);
        kontynluj.setBackground(Color.red);
        exit.setBackground(Color.red);
        zmianaPanel.setBackground(Color.red);
        zmianaLabel.setText("<html>Zmiana<br>Hasła</html>");
        statystykiLabel.setText("<html>Pobierz<br>Statystyki</html>");
        statystykiPanel.setBackground(Color.red);
       
        client.setStatListener(new MyListener(){
            @Override
            public void callback(String text){
                statystykiLabel.setText(text);
            };
        
        });
        repaint();
    }
    
    public void setplayer(Player player)
    {
        String login = player.getLogin();
        String pass = player.getPass();
        this.player.set(login,pass);
    }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        start = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kontynluj = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        exit = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        zmianaPanel = new javax.swing.JPanel();
        zmianaLabel = new javax.swing.JLabel();
        statystykiPanel = new javax.swing.JPanel();
        statystykiLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 512));

        menu.setMaximumSize(new java.awt.Dimension(600, 512));
        menu.setMinimumSize(new java.awt.Dimension(600, 512));
        menu.setPreferredSize(new java.awt.Dimension(600, 512));
        menu.setRequestFocusEnabled(false);
        menu.setVerifyInputWhenFocusTarget(false);

        start.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        start.setMaximumSize(new java.awt.Dimension(200, 100));
        start.setMinimumSize(new java.awt.Dimension(200, 100));
        start.setName("Start"); // NOI18N
        start.setPreferredSize(new java.awt.Dimension(200, 100));
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOWA GRA");
        jLabel1.setAlignmentY(5.0F);

        javax.swing.GroupLayout startLayout = new javax.swing.GroupLayout(start);
        start.setLayout(startLayout);
        startLayout.setHorizontalGroup(
            startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        startLayout.setVerticalGroup(
            startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        kontynluj.setMaximumSize(new java.awt.Dimension(200, 100));
        kontynluj.setMinimumSize(new java.awt.Dimension(200, 100));
        kontynluj.setPreferredSize(new java.awt.Dimension(200, 100));
        kontynluj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kontynlujMouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("KONTYNUUJ");
        jLabel2.setAlignmentY(5.0F);

        javax.swing.GroupLayout kontynlujLayout = new javax.swing.GroupLayout(kontynluj);
        kontynluj.setLayout(kontynlujLayout);
        kontynlujLayout.setHorizontalGroup(
            kontynlujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kontynlujLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kontynlujLayout.setVerticalGroup(
            kontynlujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kontynlujLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        exit.setMaximumSize(new java.awt.Dimension(200, 100));
        exit.setMinimumSize(new java.awt.Dimension(200, 100));
        exit.setPreferredSize(new java.awt.Dimension(200, 100));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("EXIT");
        jLabel3.setAlignmentY(5.0F);

        javax.swing.GroupLayout exitLayout = new javax.swing.GroupLayout(exit);
        exit.setLayout(exitLayout);
        exitLayout.setHorizontalGroup(
            exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        exitLayout.setVerticalGroup(
            exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        zmianaPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zmianaPanelMouseClicked(evt);
            }
        });

        zmianaLabel.setText("label1");

        javax.swing.GroupLayout zmianaPanelLayout = new javax.swing.GroupLayout(zmianaPanel);
        zmianaPanel.setLayout(zmianaPanelLayout);
        zmianaPanelLayout.setHorizontalGroup(
            zmianaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zmianaPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(zmianaLabel)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        zmianaPanelLayout.setVerticalGroup(
            zmianaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zmianaPanelLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(zmianaLabel)
                .addGap(41, 41, 41))
        );

        statystykiPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statystykiPanelMouseClicked(evt);
            }
        });

        statystykiLabel.setText("jLabel4");

        javax.swing.GroupLayout statystykiPanelLayout = new javax.swing.GroupLayout(statystykiPanel);
        statystykiPanel.setLayout(statystykiPanelLayout);
        statystykiPanelLayout.setHorizontalGroup(
            statystykiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statystykiPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(statystykiLabel)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        statystykiPanelLayout.setVerticalGroup(
            statystykiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statystykiPanelLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(statystykiLabel)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(statystykiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kontynluj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(zmianaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(kontynluj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statystykiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(zmianaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        start.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseClicked
            this.setVisible(false); 
            Game game = new Game();
            game.start();
                    
    }//GEN-LAST:event_startMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(1);
    }//GEN-LAST:event_exitMouseClicked

    private void kontynlujMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kontynlujMouseClicked
        
    }//GEN-LAST:event_kontynlujMouseClicked
    
    private void zmianaPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zmianaPanelMouseClicked
        ZmianaHasla zmiana=new ZmianaHasla(this.player);
        zmiana.start();
        //client.wysylanieStatystyk("Florr", 10);
    }//GEN-LAST:event_zmianaPanelMouseClicked

    private void statystykiPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statystykiPanelMouseClicked
       client.statRequest();
    }//GEN-LAST:event_statystykiPanelMouseClicked
    
    public  void start() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setVisible(true);
    }
    
    
    Image icon;
    
    public void loadImg()
    {
        icon=new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Tank\\grafiki\\menu\\Menu.png").getImage();
    }
    
    @Override
    public void paint (Graphics g) {  
        g.drawImage(icon, 0, 0,650,650, null); 
        menu.paintComponents(g);  
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel kontynluj;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel start;
    private javax.swing.JLabel statystykiLabel;
    private javax.swing.JPanel statystykiPanel;
    private javax.swing.JLabel zmianaLabel;
    private javax.swing.JPanel zmianaPanel;
    // End of variables declaration//GEN-END:variables
}
