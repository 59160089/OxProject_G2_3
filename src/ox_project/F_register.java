
package ox_project;

import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

public class F_register extends javax.swing.JFrame {
    Database db;
    MongoCollection<Document> user;
    String avatarId ;
    /**
     * Creates new form F_register
     */
    public F_register() {
        initComponents();
         avatarId = "Default.png" ;
         user = db.getCollection("user");
    }

    
    /*
    เพิ่มข้อมูลของ User ลงในฐานข้อมูล
    */
    public void submitRegister(){
        
        List<Document> seedData = new ArrayList<Document>();

        seedData.add(new Document("ID",txtUsername.getText())
                .append("Pass", txtPassword.getText())
                .append("Name", txtPlayerName.getText())
                .append("AvatarID", avatarId)

               
        );
        user.insertMany(seedData);
           
        masregisterSuccess();
        gotoLogin();
    }
    
    /*
    แสดงข้อความเตือน เมื่อการสมัครสำเร็จ
    */
    public void masregisterSuccess(){
         JLabel label = new JLabel("สมัครเรียบร้อย");
            label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label);
            
    }
    
/*
    ตรวจสอบว่าผู้ใช้ยืนยันรหัสผ่านถูกต้องหรือไม่
    โดยข้อมูลเข้าเป็น String
    และข้อมูลออกเป็น Boolean
    */
    public boolean isPasswordMatching(String txtPass , String txtRePass){//isPasswordMatching  checkrepass
        if(txtPass.equals(txtRePass)){
//            System.out.println("ซ้ำ");
            return true;
        }else {
            return false;
        }
    }
    
     /*
    ตรวจสอบว่าผู้ใช้ กรอกชื่อผู้ใช้ ซ้ำกับ ชื่อผู้ใช้ที่มีอยู่ในระบบ หรือไม่
    True = ซ้ำ
    Flase = ไม่ซ้ำ
    */
    public boolean checkUserExist(){//checkUserExist  checkID
        
        MongoClientURI uri  = new MongoClientURI("mongodb://admin:abc123456@ds237922.mlab.com:37922/ox_59160117");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        
        MongoCollection<Document> user = db.getCollection("user");
       
        try {
            
            Document myDoc = user.find(eq("ID", txtUsername.getText())).first();
            System.out.println(myDoc.toJson());
            return true;
            
        } catch (Exception e) {
          //  System.out.println("ดักว่าไอดีไม่ซ้ำ");
              //  clearInpurField();
            //ดักไอดีซ้ำและคืนค่า Boolean
            return false;
        }      
    }
    
    /*
    ตรวจสอบว่า ผู้ใช้กรอกข้อมูลครบถ้วนหรือไม่
    True = ไม่ครบถ้วน
    False = ครบถ้วน
    */
    public boolean isFillAllFiled(String txtUsername , String txtPlayerName , String txtPassword , String txtConfirmPassword){ //isFillAllFiled  checkEmpty
        
        if(txtUsername.equals("")||txtPlayerName.equals("")||txtPassword.equals("")||txtConfirmPassword.equals("")){
            return false; // Text ว่าง
        }else{
            return true; // Text โดนกรอกแล้ว
        }
        
    }
    
    /*
    ไปยังหน้า Login
    */
    public void gotoLogin(){
        dispose();
        new F_Login().show();
               
    }
    
    /*
    ล้างช่องกรอกข้อมูลทั้งหมด
    */
    public void clearInpurField(){
        txtPlayerName.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        //tx_avatar.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        btnRegister = new keeptoo.KButton();
        txtUsername = new javax.swing.JTextField();
        txtPlayerName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnAvatar1 = new javax.swing.JButton();
        btnAvatar3 = new javax.swing.JButton();
        btnAvatar2 = new javax.swing.JButton();
        btnClear = new keeptoo.KButton();
        imgAvatar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkGradientFocus(700);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, 130, -1));
        btnRegister.getAccessibleContext().setAccessibleName("btnRegister");

        txtUsername.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        kGradientPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 207, -1));

        txtPlayerName.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        kGradientPanel1.add(txtPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 207, -1));

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel1.setText("User :");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel2.setText("Pass :");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel3.setText("Name :");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        txtPassword.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        kGradientPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 207, -1));

        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
        jLabel4.setText("ConfirmPass :");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        txtConfirmPassword.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        kGradientPanel1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 207, -1));

        btnAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Avatar1.png"))); // NOI18N
        btnAvatar1.setBorder(null);
        btnAvatar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        btnAvatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Avatar3.png"))); // NOI18N
        btnAvatar3.setBorder(null);
        btnAvatar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar3ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnAvatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        btnAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Avatar2.png"))); // NOI18N
        btnAvatar2.setBorder(null);
        btnAvatar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnAvatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 110, 100));

        btnClear.setText("Clear");
        btnClear.setkBackGroundColor(new java.awt.Color(255, 0, 0));
        btnClear.setkEndColor(new java.awt.Color(255, 204, 204));
        btnClear.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        btnClear.setkHoverForeGround(new java.awt.Color(255, 0, 0));
        btnClear.setkHoverStartColor(new java.awt.Color(255, 0, 0));
        btnClear.setkIndicatorColor(new java.awt.Color(255, 0, 0));
        btnClear.setkPressedColor(new java.awt.Color(255, 0, 0));
        btnClear.setkSelectedColor(new java.awt.Color(255, 0, 0));
        btnClear.setkStartColor(new java.awt.Color(255, 0, 0));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 130, -1));
        btnClear.getAccessibleContext().setAccessibleName("btnClear");

        imgAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Default.png"))); // NOI18N
        kGradientPanel1.add(imgAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setText("Register");
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 55, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearInpurField();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:

        if(!isFillAllFiled(txtUsername.getText(), txtPlayerName.getText(), txtPassword.getText(), txtConfirmPassword.getText())){
            masIsNotFillAllFiled();
            clearInpurField();

        }else {
            if(checkLengthIdPass(txtUsername.getText(),txtPassword.getText())){
                
            if(isPasswordMatching(txtPassword.getText(),txtConfirmPassword.getText())){ // รหัสผ่านตรงกัน
             
                if( checkUserExist()){
                   masUserExist();
                    clearInpurField();
                }else{

                    submitRegister();
                    clearInpurField();

                }
            }else {
              masPassDoNotMatch();
                clearInpurField();
            }
            
            }else{
                 masUserPassLessThan8();
                clearInpurField();
            }
            
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    /*
    แสดงข้อความเตือนเมื่อผู้ใช้ยืนยันรหัสผ่านไม่ถูกต้อง
    */
    public void masPassDoNotMatch(){
         JLabel label = new JLabel("กรุณากรอกรหัสผ่านให้ตรงกัน");
                label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
    /*
    แสดงข้อความเตือนเมื่อผู้ใช้ กรอก ชื่อผู้ใช้ หรือ รหัสผ่าน ไม่ตรงกับเงื่อนไข
    */
    public void masUserPassLessThan8(){
          JLabel label = new JLabel("Username และ Password ควรมีความยาวตั้งแต่8ตัวเป็นต้นไป");
                label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
    /*
    แสดงข้อความเตือนเมื่อผู้ใช้ กรองข้อมูลไม่ครบถ้วน
    */
    public void masIsNotFillAllFiled(){
            JLabel label = new JLabel("กรุณากรอกข้อมูลให้ครบถ้วน");
            label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
    /*
    แสดงข้อความเตือนเมื่อ ชื่อผู้ใช้ ที่ผู้ใช้กรอกมา ซ้ำกับ ชื่อผู้ใช้ในระบบ
    */
     public void masUserExist(){
          JLabel label = new JLabel("มีไอดีนี้อยู่ในระบบแล้ว");
                    label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    
     /*
     ตรวจสอบว่า ผู้ใช้กรอก ชื่อผู้ใช้ และ รหัสผ่าน ตรงตามเงื่อนไขของระบบหรือไม่
     True = ตรงตามเงื่อนไข
     Flase = ไม่ตรงตามเงื่อนไข
     */
    public boolean checkLengthIdPass(String txtUsername , String txtPassword){
        if ( txtUsername.length() >= 8 && txtPassword.length() >= 8 ){
            return true;
        }else{
            return false;
        }
    }
    private void btnAvatar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar3ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src\\image\\Avatar3.png");
        avatarId = "Avatar3.png";
        System.out.println(avatarId);
        imgAvatar.setIcon(icon);
    }//GEN-LAST:event_btnAvatar3ActionPerformed

    private void btnAvatar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar2ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src\\image\\Avatar2.png");
        avatarId = "Avatar2.png";
        System.out.println(avatarId);
        imgAvatar.setIcon(icon);
    }//GEN-LAST:event_btnAvatar2ActionPerformed

    private void btnAvatar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar1ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src\\image\\Avatar1.png");
        imgAvatar.setIcon(icon);
        avatarId = "Avatar1.png";
      //  System.out.println(avatarId);
    }//GEN-LAST:event_btnAvatar1ActionPerformed
/*  ImageIcon icon = new ImageIcon("src\\image\\Avatar1.png");
        imgAvatar.setIcon(icon);
        avatarId = "Avatar1.png";
        System.out.println(avatarId);*/
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvatar1;
    private javax.swing.JButton btnAvatar2;
    private javax.swing.JButton btnAvatar3;
    private keeptoo.KButton btnClear;
    private keeptoo.KButton btnRegister;
    private javax.swing.JLabel imgAvatar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPlayerName;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
