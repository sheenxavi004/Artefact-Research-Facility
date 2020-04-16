/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefact_research_facility;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sheenxavi004
 */
public class AddResearch extends javax.swing.JFrame {

    /**
     * Creates new form Upload_Files
     */
    int author_id;
    public AddResearch() {
        initComponents();
    }
    public AddResearch(int user_id)
    {
        setTitle("Artefact Research Facility");
        setVisible(true);
        author_id = user_id;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        upload = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        research_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel1.setText("Add Research Data");

        jLabel3.setText("File Name");

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });

        upload.setText("Upload");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });

        close.setText("Go Back");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jLabel4.setText("Research Name");

        research_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                research_nameActionPerformed(evt);
            }
        });

        jLabel5.setText(":");

        jLabel6.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fname)
                    .addComponent(research_name, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(upload, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(research_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(upload, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(close)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        // TODO add your handling code here:
        String researchname = research_name.getText();
        String filename = fname.getText();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int researchid;
        String Path = "/home/sheenxavi004/Documents/Artefact_Research_Facility/";
        try{

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Research_Artefact_Facility", "root", "");
            Statement str = conn.createStatement();
            Statement stf = conn.createStatement();
            Statement st = conn.createStatement();
            Path = Path + researchname + filename;
            String checkr = "SELECT * FROM `research_info` WHERE `research_name` = '" + researchname + "'";
            String checkf = "SELECT * FROM `file_info` WHERE `file_name` = '" + filename + "'";
            ResultSet existr = str.executeQuery(checkr);
            ResultSet existf = stf.executeQuery(checkf);
            if(!existr.next())
            {
                str.executeUpdate("INSERT INTO `research_info`(`research_name`,`author_id`,`doi`) VALUES('" + researchname + "' , '" + author_id + "' , '" + year + "')");
                Statement stt = conn.createStatement();
                ResultSet temp = stt.executeQuery("SELECT * FROM `research_info` WHERE `research_name` = '" + researchname + "'");
                temp.next();
                researchid = temp.getInt("research_id");                
                if(!existf.next())
                {
                    st.executeUpdate("INSERT INTO `file_info` (`file_name`,`research_id`,`file_location`) VALUES('" + filename + "','" + researchid + "','" + Path + "')");
                }
            }
            else
            {
                researchid = existr.getInt("research_id");
                if(!existf.next())
                {
                    st.executeUpdate("INSERT INTO `file_info` (`file_name`,`research_id`,`file_location`) VALUES('" + filename + "','" + researchid + "','" + Path + "')");
                }
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File source = chooser.getSelectedFile();
            File dest = new File(Path);
            dest.createNewFile();
            FileInputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            } 
            in.close();
            out.close();
            JOptionPane.showMessageDialog(null, "Upload Complete !");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_uploadActionPerformed

    private void research_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_research_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_research_nameActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        dispose();
        try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Research_Artefact_Facility", "root", "");
                    Statement st = conn.createStatement();
                    String query = "SELECT `user_id`,`superior_id` FROM `user_info` WHERE `user_id` = '" + author_id + "'";
                    ResultSet rs = st.executeQuery(query);
                    rs.next();
                    int Superior_id = rs.getInt("superior_id");
                    if (Superior_id == 0) {
                        int user_id = rs.getInt("user_id");
                        new Superior_View(user_id);
                    } else {
                        int user_id = rs.getInt("user_id");
                        new Researcher_View(user_id);
                    }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_closeActionPerformed

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
            java.util.logging.Logger.getLogger(AddResearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddResearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddResearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddResearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddResearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField research_name;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables
}
