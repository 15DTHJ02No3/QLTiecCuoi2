/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;


import Main.qltieccuoi;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

 
/**
 *
 * @author WINDOWS 10
 */
public class Nhapsanhc extends javax.swing.JFrame {
    private final String header[] = {"MASANH", "TENSANH", "LOAISANH", "SOBANMAX", "GIATIENTOIDA","CHUY"};
    private final DefaultTableModel tblModel = new DefaultTableModel(header, 0);
    
    public Nhapsanhc() {
        initComponents();
        load();
    }
    private void load(){
/*        tbsp.removeAll();
        
        try{
            qltieccuoi pt=new qltieccuoi();
            ResultSet rs=pt.GetData("SANH");
            int i=0;
        while(rs.next()){
          tbsp.setValueAt(rs.getString("MASANH"), i, 0);
          tbsp.setValueAt(rs.getString("TENSANH"), i, 1);
          tbsp.setValueAt(rs.getString("LOAISANH"), i, 2);
          tbsp.setValueAt(rs.getString("SOBANMAX"), i, 3);
          tbsp.setValueAt(rs.getString("GIATIENTOIDA"), i, 4);
          tbsp.setValueAt(rs.getString("CHUY"), i, 5);
         i++;
        }
        pt.Close();
        }catch(ClassNotFoundException ex){
            Logger.getLogger(NhapSanh.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException ex){
                Logger.getLogger(NhapSanh.class.getName()).log(Level.SEVERE,null,ex);
                    //JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", 1);
        }
     }
     */
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql = "select * from SANH ";// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            tblModel.setRowCount(0);
            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không có Sảnh!");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
              data = new Vector();
                data.add(rs.getString("MASANH"));
                data.add(rs.getString("TENSANH"));
                data.add(rs.getString("LOAISANH"));
                data.add(rs.getString("SOBANMAX"));
                data.add(rs.getString("GIATIENTOIDA"));
                data.add(rs.getString("CHUY"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }

            tbsp.setModel(tblModel); // Thêm dữ liệu vào table
            tbsp.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if(tbsp.getSelectedRow()>=0){
                    // jTextFieldbs.setEditable(false);
                    jtmasanh.setText(tbsp.getValueAt(tbsp.getSelectedRow(),0) + "");
                    jttensanh.setText(tbsp.getValueAt(tbsp.getSelectedRow(),1) + "");
                    jtaghichu.setText(tbsp.getValueAt(tbsp.getSelectedRow(),5) + "");
                    jtsoluongban.setText(tbsp.getValueAt(tbsp.getSelectedRow(),3)+ "");
                    jcbgiaban.setSelectedItem(tbsp.getValueAt(tbsp.getSelectedRow(),4)+ "");
                      jcbloaisanh.setSelectedItem(tbsp.getValueAt(tbsp.getSelectedRow(),2)+ "");
                    int select = tbsp.getSelectedRow();
                }
                });
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
    private void search() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql = "select * from SANH ";
            if (jtmasanh.getText().length() > 0) {
                sql = sql + " where MASANH = N'" + jtmasanh.getText() + "' or TENSANH like N'%" + jtmasanh.getText() + "%' or LOAISANH = N'" + jtmasanh.getText() + "'";
            } if(jtmasanh.getText().length()==0){
                 sql = "select * from SANH ";
            }
            st = conn.createStatement();// Tạo đối tượng thực thi câu lệnh Select
            rs = st.executeQuery(sql);// Thực thi 
            Vector data = null;
            tblModel.setRowCount(0);
            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không Có Sảnh Này!");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
              data = new Vector();
                data.add(rs.getString("MASANH"));
                data.add(rs.getString("TENSANH"));
                data.add(rs.getString("LOAISANH"));
                data.add(rs.getString("SOBANMAX"));
                data.add(rs.getString("GIATIENTOIDA"));
                data.add(rs.getString("CHUY"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }
            tbsp.setModel(tblModel); // Thêm dữ liệu vào table
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel22 = new javax.swing.JPanel();
        jbtthoat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtmasanh = new javax.swing.JTextField();
        jcbloaisanh = new javax.swing.JComboBox<>();
        jttensanh = new javax.swing.JTextField();
        jbtlammoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbgiaban = new javax.swing.JComboBox<>();
        jbtthem = new javax.swing.JButton();
        jbtsua = new javax.swing.JButton();
        jbtxoa = new javax.swing.JButton();
        jtsoluongban = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaghichu = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbsp = new javax.swing.JTable();
        jbttimkiem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel22.setLayout(null);

        jbtthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Exit.png"))); // NOI18N
        jbtthoat.setText("Thoát");
        jbtthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtthoatActionPerformed(evt);
            }
        });
        jPanel22.add(jbtthoat);
        jbtthoat.setBounds(550, 210, 90, 34);

        jLabel6.setBackground(new java.awt.Color(0, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("THÔNG TIN SẢNH");
        jPanel22.add(jLabel6);
        jLabel6.setBounds(290, 0, 200, 30);
        jPanel22.add(jtmasanh);
        jtmasanh.setBounds(310, 260, 130, 34);

        jcbloaisanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn Sảnh--", "A", "B", "C", "D", "E" }));
        jcbloaisanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbloaisanhActionPerformed(evt);
            }
        });
        jPanel22.add(jcbloaisanh);
        jcbloaisanh.setBounds(450, 60, 120, 30);
        jPanel22.add(jttensanh);
        jttensanh.setBounds(140, 60, 200, 30);

        jbtlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Refresh.png"))); // NOI18N
        jbtlammoi.setText("Reset");
        jbtlammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtlammoiMouseClicked(evt);
            }
        });
        jbtlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtlammoiActionPerformed(evt);
            }
        });
        jPanel22.add(jbtlammoi);
        jbtlammoi.setBounds(440, 210, 90, 34);

        jLabel1.setText("MÃ SẢNH");
        jPanel22.add(jLabel1);
        jLabel1.setBounds(240, 260, 60, 34);

        jLabel2.setText("TÊN SẢNH");
        jPanel22.add(jLabel2);
        jLabel2.setBounds(60, 60, 60, 30);

        jLabel3.setText("SẢNH");
        jPanel22.add(jLabel3);
        jLabel3.setBounds(370, 60, 80, 30);

        jLabel4.setText("SL BÀN");
        jPanel22.add(jLabel4);
        jLabel4.setBounds(60, 100, 60, 30);

        jLabel5.setText("GIÁ BÀN");
        jPanel22.add(jLabel5);
        jLabel5.setBounds(60, 140, 90, 30);

        jLabel7.setText("GHI CHÚ");
        jPanel22.add(jLabel7);
        jLabel7.setBounds(370, 90, 70, 30);

        jcbgiaban.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn Giá--", "1000000", "1100000", "1200000", "1400000", "1600000" }));
        jPanel22.add(jcbgiaban);
        jcbgiaban.setBounds(140, 140, 120, 30);

        jbtthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Add.png"))); // NOI18N
        jbtthem.setText("Thêm");
        jbtthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtthemActionPerformed(evt);
            }
        });
        jPanel22.add(jbtthem);
        jbtthem.setBounds(110, 210, 90, 34);

        jbtsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Application.png"))); // NOI18N
        jbtsua.setText("Sửa");
        jbtsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtsuaMouseClicked(evt);
            }
        });
        jbtsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtsuaActionPerformed(evt);
            }
        });
        jPanel22.add(jbtsua);
        jbtsua.setBounds(220, 210, 90, 34);

        jbtxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Erase.png"))); // NOI18N
        jbtxoa.setText("Xóa");
        jbtxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtxoaMouseClicked(evt);
            }
        });
        jbtxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtxoaActionPerformed(evt);
            }
        });
        jPanel22.add(jbtxoa);
        jbtxoa.setBounds(330, 210, 90, 34);
        jPanel22.add(jtsoluongban);
        jtsoluongban.setBounds(140, 100, 80, 30);

        jtaghichu.setColumns(20);
        jtaghichu.setRows(5);
        jScrollPane1.setViewportView(jtaghichu);

        jPanel22.add(jScrollPane1);
        jScrollPane1.setBounds(450, 100, 220, 70);
        jPanel22.add(jSeparator1);
        jSeparator1.setBounds(30, 40, 670, 2);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel22.add(jSeparator2);
        jSeparator2.setBounds(30, 40, 2, 150);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel22.add(jSeparator3);
        jSeparator3.setBounds(698, 40, 10, 150);
        jPanel22.add(jSeparator4);
        jSeparator4.setBounds(30, 190, 670, 2);

        tbsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbsp);

        jPanel22.add(jScrollPane2);
        jScrollPane2.setBounds(0, 310, 750, 210);

        jbttimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Text preview.png"))); // NOI18N
        jbttimkiem.setText("Tìm Kiếm");
        jbttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttimkiemActionPerformed(evt);
            }
        });
        jPanel22.add(jbttimkiem);
        jbttimkiem.setBounds(460, 260, 110, 34);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/Customized-3d-Wall-Murals-Wallpaper-Goose-Animal-Mural-for-Sofa-TV-Background-3d-Wall-Photo-Murals.jpg"))); // NOI18N
        jPanel22.add(jLabel8);
        jLabel8.setBounds(0, 0, 750, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtthoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jbtthoatActionPerformed

    private void jcbloaisanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbloaisanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbloaisanhActionPerformed

    private void jbtlammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtlammoiMouseClicked
        // TODO add your handling code here:
        jtmasanh.setText("");
        jttensanh.setText("");
        jcbloaisanh.setSelectedItem("--Chọn Sảnh--");
        jtsoluongban.setText("");
        jcbgiaban.setSelectedItem("--Chọn Giá--");
        jtaghichu.setText("");
        this.load();
        // tblModel.setRowCount(0);
    }//GEN-LAST:event_jbtlammoiMouseClicked

    private void jbtlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtlammoiActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_jbtlammoiActionPerformed

    private void jbtthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtthemActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        String insert = "INSERT INTO SANH (TENSANH,LOAISANH,SOBANMAX,GIATIENTOIDA,CHUY) VALUES(?,?,?,?,?)";
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(insert);
            //ps.setString(1, jtmasanh.getText());
            // if (this.jtmasanh.getText().length()==0) JOptionPane.showMessageDialog(null, "Mã Sảnh không thể bỏ trống", "thông báo",2);
            ps.setString(1, jttensanh.getText());
            ps.setString(2,jcbloaisanh.getSelectedItem().toString());
            ps.setInt(3, Integer.parseInt(jtsoluongban.getText()));
            ps.setString(4,jcbgiaban.getSelectedItem().toString());
            ps.setString(5, jtaghichu.getText());
            int ret = ps.executeUpdate();
            if (ret != -1) {
                // jlbStatus.setText("The Khoa has been insertet");
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
                this.load();
            }
            else{
                JOptionPane.showMessageDialog(this, "Không Thành Công");
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex2) {
            }
        }
    }//GEN-LAST:event_jbtthemActionPerformed

    private void jbtsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtsuaMouseClicked
        // TODO add your handling code here:

        try{
            qltieccuoi pt=new qltieccuoi();
            pt.Update(jtmasanh.getText(),jttensanh.getText(),(jcbloaisanh.getSelectedItem().toString()),Integer.parseInt(jtsoluongban.getText()),(jcbgiaban.getSelectedItem().toString()),jtaghichu.getText());
            int ret = JOptionPane.showConfirmDialog(this, "Bạn Muốn Sửa?", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (ret != JOptionPane.YES_OPTION)
            return;
            //pt.Close();
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Nhapsanhc.class.getName()).log(Level.SEVERE,null,ex);
        }
        this.load();
    }//GEN-LAST:event_jbtsuaMouseClicked

    private void jbtsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtsuaActionPerformed

    }//GEN-LAST:event_jbtsuaActionPerformed

    private void jbtxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtxoaMouseClicked
        // TODO add your handling code here:
        try{
            qltieccuoi pt=new qltieccuoi();
            pt.delete(jtmasanh.getText(),jttensanh.getText());
            int ret = JOptionPane.showConfirmDialog(this, "Bạn Muốn Xóa ?", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (ret != JOptionPane.YES_OPTION)
            return;
           // pt.Close();
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Nhapsanhc.class.getName()).log(Level.SEVERE,null,ex);
        }
        this.load();
    }//GEN-LAST:event_jbtxoaMouseClicked

    private void jbtxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtxoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtxoaActionPerformed

    private void jbttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttimkiemActionPerformed

        this.search();
    }//GEN-LAST:event_jbttimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(Nhapsanhc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Nhapsanhc().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbtlammoi;
    private javax.swing.JButton jbtsua;
    private javax.swing.JButton jbtthem;
    private javax.swing.JButton jbtthoat;
    private javax.swing.JButton jbttimkiem;
    private javax.swing.JButton jbtxoa;
    private javax.swing.JComboBox<String> jcbgiaban;
    private javax.swing.JComboBox<String> jcbloaisanh;
    private javax.swing.JTextArea jtaghichu;
    private javax.swing.JTextField jtmasanh;
    private javax.swing.JTextField jtsoluongban;
    private javax.swing.JTextField jttensanh;
    private javax.swing.JTable tbsp;
    // End of variables declaration//GEN-END:variables
}
