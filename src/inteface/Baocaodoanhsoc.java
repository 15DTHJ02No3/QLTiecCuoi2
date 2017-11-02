/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Baocaodoanhsoc extends javax.swing.JFrame {
    private String header[] = {"SOHD", "NGAY","TONGTG", "MAKH","MASANH"};
    private DefaultTableModel tblModel = new DefaultTableModel(header, 0);
    
    public Baocaodoanhsoc() {
        initComponents();
        loadThangFillToCBBox();
    }
    private void loadThangFillToCBBox(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs= null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI ;user=sa;password=votinh";
        try {
            conn = DriverManager.getConnection(dbURL);          // Câu lệnh xem dữ liệu
            String sql = "select * from Thang ";                // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();                        // Thực thi 
            rs = st.executeQuery(sql);
            //Vector data = null;
            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel(); 
            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                //data = new Vector();
                //data.add(rs.getInt("Thang"));
                //data.add(rs.getString("Thang"));
            // Thêm một dòng vào table model
                cmbModel.addElement(rs.getInt("Thang"));
            }
              jcbhtthang.setModel(cmbModel);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private void loadbyBL(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        int k = 0;
        int index = Integer.valueOf(jcbhtthang.getSelectedItem().toString());
        if(index <0) // khong kho nao duoc chon.
            return;
//        Vector item = (Vector)jComboBox1.getSelectedItem();
//        int Thang= Integer.parseInt(item.get(0).toString());
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql = "select * from BIENLAI where month(NGAY) =" + index ;// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            tblModel.setRowCount(0);
            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "The BienL is not available!");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("SOHD"));
                data.add(rs.getDate("NGAY"));
                data.add(rs.getLong("TONGTG"));
                data.add(rs.getString("MAKH"));
                data.add(rs.getString("MASANH"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }
            tbdt.setModel(tblModel); // Thêm dữ liệu vào table
        } catch (HeadlessException | SQLException e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
        }
       }
       private void Kiemtra() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        int k = 0;
        int index = Integer.valueOf( jcbhtthang.getSelectedItem().toString());
        if(index <0) // khong co thang dc chon.
            return;
//        Vector item = (Vector)jComboBox1.getSelectedItem();
//        int Thang= Integer.parseInt(item.get(0).toString());
        
try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql = "select sum (TongTG) from BIENLAI where month(NGAY)= " + index;// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql);
            if(rs.next()==false)
                return;
            jttongdt.setText(Long.toString(rs.getInt(1))); // Thêm dữ liệu vào jtexts
        } catch (SQLException e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
        }
    
       }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jttongdt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdt = new javax.swing.JTable();
        jbtthoat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jcbhtthang = new javax.swing.JComboBox<>();
        jbtkiemtradoanhthu = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdt1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        btkiemtar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(535, 410));

        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Calendar.png"))); // NOI18N
        jLabel1.setText("THÁNG");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 80, 110, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Sum.png"))); // NOI18N
        jLabel2.setText("TỔNG DOANH THU");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 120, 140, 30);

        jttongdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jttongdtActionPerformed(evt);
            }
        });
        jPanel1.add(jttongdt);
        jttongdt.setBounds(210, 120, 170, 30);

        jScrollPane1.setViewportView(tbdt);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 210, 530, 200);

        jbtthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Exit.png"))); // NOI18N
        jbtthoat.setText("Thoát");
        jbtthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtthoatActionPerformed(evt);
            }
        });
        jPanel1.add(jbtthoat);
        jbtthoat.setBounds(370, 160, 110, 33);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("DOANH THU");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 20, 133, 29);

        jcbhtthang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbhtthangActionPerformed(evt);
            }
        });
        jPanel1.add(jcbhtthang);
        jcbhtthang.setBounds(210, 80, 90, 30);

        jbtkiemtradoanhthu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Find.png"))); // NOI18N
        jbtkiemtradoanhthu.setText("Kiểm Tra");
        jbtkiemtradoanhthu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtkiemtradoanhthuMouseClicked(evt);
            }
        });
        jbtkiemtradoanhthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtkiemtradoanhthuActionPerformed(evt);
            }
        });
        jPanel1.add(jbtkiemtradoanhthu);
        jbtkiemtradoanhthu.setBounds(240, 160, 110, 33);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/dandelion_fluff.jpg"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 540, 200);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setTitle("Báo Cáo Doanh Số");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Calendar.png"))); // NOI18N
        jLabel4.setText("THÁNG");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Sum.png"))); // NOI18N
        jLabel5.setText("TỔNG DOANH THU");

        tbdt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                " SOBL", "NGAY", "NOIDUNG", "TONGTG", "MAKH", "MASANH"
            }
        ));
        jScrollPane2.setViewportView(tbdt1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Exit.png"))); // NOI18N
        jButton4.setText("Thoát");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setText("DOANH THU");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        btkiemtar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Find.png"))); // NOI18N
        btkiemtar1.setText("Kiểm Tra");
        btkiemtar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btkiemtar1MouseClicked(evt);
            }
        });
        btkiemtar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkiemtar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(btkiemtar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(198, 198, 198))))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btkiemtar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jInternalFrame1);
        jInternalFrame1.setBounds(0, 0, 438, 397);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jttongdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jttongdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jttongdtActionPerformed

    private void jbtthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtthoatActionPerformed
            this.dispose();
    }//GEN-LAST:event_jbtthoatActionPerformed

    private void jcbhtthangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbhtthangActionPerformed
        // TODO add your handling code here:
        loadbyBL();
    }//GEN-LAST:event_jcbhtthangActionPerformed

    private void jbtkiemtradoanhthuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtkiemtradoanhthuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtkiemtradoanhthuMouseClicked

    private void jbtkiemtradoanhthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtkiemtradoanhthuActionPerformed
        // TODO add your handling code here:
        this.Kiemtra();
    }//GEN-LAST:event_jbtkiemtradoanhthuActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btkiemtar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btkiemtar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btkiemtar1MouseClicked

    private void btkiemtar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkiemtar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btkiemtar1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Baocaodoanhsoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Baocaodoanhsoc().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btkiemtar1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton jbtkiemtradoanhthu;
    private javax.swing.JButton jbtthoat;
    private javax.swing.JComboBox<String> jcbhtthang;
    private javax.swing.JTextField jttongdt;
    private javax.swing.JTable tbdt;
    private javax.swing.JTable tbdt1;
    // End of variables declaration//GEN-END:variables
}
