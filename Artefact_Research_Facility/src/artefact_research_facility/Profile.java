/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefact_research_facility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sheenxavi004
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    int Userid;
    boolean origin = true;
    public Profile() {
        initComponents();
    }
    public Profile(int userid)
    {
        setTitle("Artefact Research Facility");
        initComponents();
        setVisible(true);
        Userid = userid;
        int supid;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Research_Artefact_Facility", "root","");
            Statement st = conn.createStatement();
            String query = "SELECT `user_id`, `name`, `email_id`,`dob`, `superior_id` FROM `user_info` WHERE `user_id` = '" + userid + "'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            uid.setText(" " + rs.getString("user_id"));
            name.setText(rs.getString("name"));
            emailid.setText(rs.getString("email_id"));
            supid = rs.getInt("superior_id");
            if(supid == 0)
            {
                position.setText(" Superior");
            }
            else
            {
                Statement sts = conn.createStatement();
                ResultSet rt = sts.executeQuery("SELECT `name` FROM `user_info` WHERE `user_id` = '"+ supid +"'");
                rt.next();
                sup.setText("Name of Superior");
                sup_col.setText(":");
                supname.setText(rt.getString("name"));
                position.setText(" Researcher");
            }
            dob.setText(" " + rs.getDate("dob").toString());
            
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        DefaultTableModel model = (DefaultTableModel)myresearches.getModel();
         model.setRowCount(0);
         try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Research_Artefact_Facility", "root","");
            Statement st = conn.createStatement();
            String query = "SELECT `research_name`,`research_id` FROM `research_info` WHERE `author_id` = '"+ Userid +"'";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                int research_id = rs.getInt("research_id");
                String rname = rs.getString("research_name");
                Statement stf = conn.createStatement();
                String fquery = "SELECT `file_id`,`file_name`,`file_location` FROM `file_info` WHERE `research_id` = '"+ research_id +"'";
                ResultSet rf = stf.executeQuery(fquery);
                while(rf.next())
                {
                    int fid = rf.getInt("file_id");
                    String fname = rf.getString("file_name");
                    String filelocation = rf.getString("file_location");
                    Object row[] = {fid,rname,fname,filelocation};
                    model.addRow(row);
                }
                myresearches.getColumn("File").setCellRenderer(new ButtonRenderer());
                myresearches.getColumn("File").setCellEditor(new ButtonEditor(new JTextField()));
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
     }
}         
    public Profile(int userid,boolean org)
    {
        origin = org;
        setTitle("Artefact Research Facility");
        initComponents();
        setVisible(true);
        Userid = userid;
        int supid;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Research_Artefact_Facility", "root","");
            Statement st = conn.createStatement();
            String query = "SELECT `name`, `email_id`,`dob`, `superior_id` FROM `user_info` WHERE `user_id` = '" + userid + "'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            uid.setText(" "+userid);
            name.setText(rs.getString("name"));
            emailid.setText(rs.getString("email_id"));
            supid = rs.getInt("superior_id");
            if(supid == 0)
            {
                position.setText(" Superior");
            }
            else
            {
                Statement sts = conn.createStatement();
                ResultSet rt = sts.executeQuery("SELECT `name` FROM `user_info` WHERE `user_id` = '"+ supid +"'");
                rt.next();
                sup.setText("Name of Superior");
                sup_col.setText(":");
                supname.setText(rt.getString("name"));
                position.setText(" Researcher");
            }
            dob.setText(" " + rs.getDate("dob").toString());
            
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        DefaultTableModel model = (DefaultTableModel)myresearches.getModel();
         model.setRowCount(0);
         try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Research_Artefact_Facility", "root","");
            Statement st = conn.createStatement();
            String query = "SELECT `research_name`,`research_id` FROM `research_info` WHERE `author_id` = '"+ Userid +"'";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                int research_id = rs.getInt("research_id");
                String rname = rs.getString("research_name");
                Statement stf = conn.createStatement();
                String fquery = "SELECT `file_id`,`file_name`,`file_location` FROM `file_info` WHERE `research_id` = '"+ research_id +"'";
                ResultSet rf = stf.executeQuery(fquery);
                while(rf.next())
                {
                    int fid = rf.getInt("file_id");
                    String fname = rf.getString("file_name");
                    String filelocation = rf.getString("file_location");
                    Object row[] = {fid,rname,fname,filelocation};
                    model.addRow(row);
                }
                myresearches.getColumn("File").setCellRenderer(new ButtonRenderer());
                myresearches.getColumn("File").setCellEditor(new ButtonEditor(new JTextField()));
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        emailid = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        position = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        myresearches = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        sup = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sup_col = new javax.swing.JLabel();
        supname = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        uid = new javax.swing.JLabel();

        jLabel6.setText("Research");

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel2.setText("Basic Profile");

        close.setText("Go Back");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel3.setText("Email ID");

        jLabel4.setText("Date of Birth");

        jLabel5.setText("Position");

        jLabel7.setText(":");

        jLabel8.setText(":");

        jLabel9.setText(":");

        jLabel10.setText(":");

        name.setText("jLabel12");

        emailid.setText("jLabel12");

        dob.setText("jLabel12");

        position.setText("jLabel12");

        myresearches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "File ID", "Research Name", "File Name", "File"
            }
        ));
        jScrollPane4.setViewportView(myresearches);
        if (myresearches.getColumnModel().getColumnCount() > 0) {
            myresearches.getColumnModel().getColumn(0).setMinWidth(70);
            myresearches.getColumnModel().getColumn(0).setMaxWidth(70);
            myresearches.getColumnModel().getColumn(2).setMinWidth(90);
            myresearches.getColumnModel().getColumn(2).setMaxWidth(90);
            myresearches.getColumnModel().getColumn(3).setMinWidth(90);
            myresearches.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel11.setText("Research Profile");

        jLabel13.setText(":");

        jLabel14.setText(":");

        jLabel15.setText(":");

        jLabel12.setText("Researcher ID");

        jLabel16.setText(":");

        uid.setText("jLabel17");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(130, 130, 130)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(sup_col, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(sup, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel16))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(supname, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(position, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uid, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16)
                    .addComponent(uid))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(name))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(emailid)
                    .addComponent(jLabel13))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(dob)
                    .addComponent(jLabel14))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(position)
                    .addComponent(jLabel15))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sup)
                    .addComponent(sup_col)
                    .addComponent(supname, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 30, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(close)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        dispose();
        try {
                if(origin)
                {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Research_Artefact_Facility", "root", "");
                    Statement st = conn.createStatement();
                    String query = "SELECT `user_id`,`superior_id` FROM `user_info` WHERE `user_id` = '" + Userid + "'";
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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable myresearches;
    private javax.swing.JLabel name;
    private javax.swing.JLabel position;
    private javax.swing.JLabel sup;
    private javax.swing.JLabel sup_col;
    private javax.swing.JLabel supname;
    private javax.swing.JLabel uid;
    // End of variables declaration//GEN-END:variables
}
