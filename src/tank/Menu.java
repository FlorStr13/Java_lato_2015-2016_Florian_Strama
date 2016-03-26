
package tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public final class Menu extends javax.swing.JFrame {

    public Menu() {
        loadImg();
        initComponents();
        start.setBackground(Color.red);
        co_op.setBackground(Color.red);
        exit.setBackground(Color.red);
    }
    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        start = new javax.swing.JPanel();
        co_op = new javax.swing.JPanel();
        exit = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        menu.setPreferredSize(new java.awt.Dimension(600, 500));
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

        javax.swing.GroupLayout startLayout = new javax.swing.GroupLayout(start);
        start.setLayout(startLayout);
        startLayout.setHorizontalGroup(
            startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        startLayout.setVerticalGroup(
            startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        co_op.setMaximumSize(new java.awt.Dimension(200, 100));
        co_op.setMinimumSize(new java.awt.Dimension(200, 100));
        co_op.setPreferredSize(new java.awt.Dimension(200, 100));

        javax.swing.GroupLayout co_opLayout = new javax.swing.GroupLayout(co_op);
        co_op.setLayout(co_opLayout);
        co_opLayout.setHorizontalGroup(
            co_opLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        co_opLayout.setVerticalGroup(
            co_opLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        exit.setMaximumSize(new java.awt.Dimension(200, 100));
        exit.setMinimumSize(new java.awt.Dimension(200, 100));
        exit.setPreferredSize(new java.awt.Dimension(200, 100));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exitLayout = new javax.swing.GroupLayout(exit);
        exit.setLayout(exitLayout);
        exitLayout.setHorizontalGroup(
            exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        exitLayout.setVerticalGroup(
            exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(co_op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(200, 200, 200))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(co_op, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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
            .addComponent(menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseClicked
        Game.start();
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_startMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(1);// TODO add your handling code here:
    }//GEN-LAST:event_exitMouseClicked
    
    
    
    
    public static void start() {
        
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
        
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
    
    
    Image icon;
    
    public void loadImg()
    {
        icon=new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Tank\\grafiki\\menu\\Menu.png").getImage();
    }
    
    @Override
    public void paint (Graphics g) {  
        super.paintComponents(g);
        g.drawImage(icon, 0, 0,650,650, null);
        menu.paintComponents(g);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel co_op;
    private javax.swing.JPanel exit;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel start;
    // End of variables declaration//GEN-END:variables
}
