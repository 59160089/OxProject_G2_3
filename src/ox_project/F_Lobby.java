/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ox_project;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author firstx
 */
public class F_Lobby extends javax.swing.JFrame {

    Database db;
    MongoCollection<Document> col;
    
//    MongoClientURI uri  = new MongoClientURI("mongodb://admin:abc123456@ds237922.mlab.com:37922/ox_59160117");
//    MongoClient client = new MongoClient(uri);
//    MongoDatabase db = client.getDatabase(uri.getDatabase());
//    MongoCollection<Document> lobby = db.getCollection("Lobby"); 
    
    /** Creates new form F_Lobby */
    public F_Lobby() {
        initComponents();
        initDatabase();
        setAllRoom();
        setAllButton();
    }
    
    public void initDatabase() {
        col = db.getCollection("Lobby");
    }
    
    public boolean isFull(int countRoom){       
        if(countRoom >= 2){
            return true;
        } else {
            return false;
        }
    }
    
    public void setAllButton() {
        setButton(joinButton1, getCountRoom(1));
        setButton(joinButton2, getCountRoom(2));
        setButton(joinButton3, getCountRoom(3));
        setButton(joinButton4, getCountRoom(4));
        setButton(joinButton5, getCountRoom(5));
    }
    
    public void setButton(javax.swing.JButton btn, int countRoom) {
        if(isFull(countRoom)) {
            btn.setVisible(false);
        } else {
            btn.setVisible(true);
        }
    }
    
    public void setAllRoom() {
        setRoom(countRoom1, 1);
        setRoom(countRoom2, 2);
        setRoom(countRoom3, 3);
        setRoom(countRoom4, 4);
        setRoom(countRoom5, 5);
    }
    
    public void setRoom(javax.swing.JLabel label,int roomId) {
        label.setText(String.valueOf(getCountRoom(roomId)));
    }
    
    public int getCountRoom(int id) {
        Document count = col.find(eq("ID",id)).first();
        return count.getInteger("Count_player");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        countRoom2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        countRoom3 = new javax.swing.JLabel();
        countRoom4 = new javax.swing.JLabel();
        countRoom5 = new javax.swing.JLabel();
        countRoom1 = new javax.swing.JLabel();
        joinButton5 = new javax.swing.JButton();
        joinButton4 = new javax.swing.JButton();
        joinButton3 = new javax.swing.JButton();
        joinButton2 = new javax.swing.JButton();
        joinButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lobby");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(336, 336, 336))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel2.setText("Room1");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 41, 65, -1));

        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel3.setText("Room2");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 103, 65, -1));

        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel4.setText("Room3");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 177, 65, -1));

        jLabel6.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel6.setText("Room4");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 248, 65, -1));

        countRoom2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        countRoom2.setText("XXX ");
        jPanel2.add(countRoom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel8.setText("Room5");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 316, 65, -1));

        countRoom3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        countRoom3.setText("XXX ");
        jPanel2.add(countRoom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        countRoom4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        countRoom4.setText("XXX ");
        jPanel2.add(countRoom4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        countRoom5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        countRoom5.setText("XXX ");
        jPanel2.add(countRoom5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        countRoom1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        countRoom1.setText("XXX ");
        jPanel2.add(countRoom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        joinButton5.setText("Join");
        jPanel2.add(joinButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        joinButton4.setText("Join");
        jPanel2.add(joinButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        joinButton3.setText("Join");
        jPanel2.add(joinButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        joinButton2.setText("Join");
        joinButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(joinButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        joinButton1.setText("Join");
        joinButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(joinButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void joinButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_joinButton2ActionPerformed

    private void joinButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_joinButton1ActionPerformed

     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(F_Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Lobby().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countRoom1;
    private javax.swing.JLabel countRoom2;
    private javax.swing.JLabel countRoom3;
    private javax.swing.JLabel countRoom4;
    private javax.swing.JLabel countRoom5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton joinButton1;
    private javax.swing.JButton joinButton2;
    private javax.swing.JButton joinButton3;
    private javax.swing.JButton joinButton4;
    private javax.swing.JButton joinButton5;
    // End of variables declaration//GEN-END:variables

}
