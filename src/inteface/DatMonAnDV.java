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
public class DatMonAnDV extends javax.swing.JFrame {

    private final String mon[] = {"STTMON", "TENMON", "DONGIA", "GHICHU","MAKH"};
    private final String dichvu[] = {"STTDV", "TENDV", "DONGIA","MAKH"};
    private final DefaultTableModel tblMode1 = new DefaultTableModel(mon, 0);
    private final DefaultTableModel tblMode2 = new DefaultTableModel(dichvu, 0);
    public DatMonAnDV() {
        initComponents();
        loadmon();
        loaddv();
    }
    private void loadmon(){
    Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql = "select * from MON ";// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            tblMode1.setRowCount(0);
            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không có dữ liệu!");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
              data = new Vector();
                data.add(rs.getInt("STTMON"));
                data.add(rs.getString("TENMON"));
                data.add(rs.getInt("DONGIA"));
                data.add(rs.getString("GHICHU"));
                data.add(rs.getString("MAKH"));
                // Thêm một dòng vào table model
                tblMode1.addRow(data);
            }

            TB2.setModel(tblMode1); // Thêm dữ liệu vào table
             TB2.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if(TB2.getSelectedRow()>=0){
                    // jTextFieldbs.setEditable(false);
                      jtsttma.setText(TB2.getValueAt(TB2.getSelectedRow(),0) + "");
                    jttenmonan.setText(TB2.getValueAt(TB2.getSelectedRow(),1) + "");
                    jtdongia.setText(TB2.getValueAt(TB2.getSelectedRow(),2) + "");
                    ghichu.setText(TB2.getValueAt(TB2.getSelectedRow(),3) + "");
                    jtmakh.setText(TB2.getValueAt(TB2.getSelectedRow(),4)+ "");
                    int select = TB2.getSelectedRow();
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
    
     private void loaddv(){
    Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql = "select * from DICHVU ";// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            tblMode2.setRowCount(0);
            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không có dữ liệu!");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
              data = new Vector();
                data.add(rs.getInt("STTDV"));
                data.add(rs.getString("TENDV"));
                data.add(rs.getInt("DONGIA"));
                data.add(rs.getString("MAKH"));
                // Thêm một dòng vào table model
                tblMode2.addRow(data);
            }

            TB3.setModel(tblMode2); // Thêm dữ liệu vào table
            TB3.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if(TB3.getSelectedRow()>=0){
                    // jTextFieldbs.setEditable(false);
                      jtsttdv.setText(TB3.getValueAt(TB3.getSelectedRow(),0) + "");
                    jttenadv.setText(TB3.getValueAt(TB3.getSelectedRow(),1) + "");
                    jtdongiadv.setText(TB3.getValueAt(TB3.getSelectedRow(),2) + "");
                    jtmakh1.setText(TB3.getValueAt(TB3.getSelectedRow(),3)+ "");
                    int select = TB3.getSelectedRow();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbthem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jttenmonan = new javax.swing.JTextField();
        jtdongia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ghichu = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jttenadv = new javax.swing.JTextField();
        jtdongiadv = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TB2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TB3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtmakh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtmakh1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jbtthoat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtsttma = new javax.swing.JTextField();
        jtsttdv = new javax.swing.JTextField();
        jbtlammoi = new javax.swing.JButton();
        jsua1 = new javax.swing.JButton();
        jbtxoa1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jbthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Add.png"))); // NOI18N
        jbthem.setText("Thêm");
        jbthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbthemActionPerformed(evt);
            }
        });
        jPanel1.add(jbthem);
        jbthem.setBounds(120, 250, 90, 33);

        jLabel1.setText("ĐẶT TIỆC CƯỚI");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(390, -220, 80, 20);

        jLabel9.setText("Tên Món Ăn");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 110, 90, 25);

        jLabel12.setText("Đơn Giá");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 140, 65, 25);

        jLabel13.setText("Ghi Chú");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(290, 77, 50, 25);
        jPanel1.add(jttenmonan);
        jttenmonan.setBounds(120, 110, 150, 25);
        jPanel1.add(jtdongia);
        jtdongia.setBounds(120, 140, 150, 25);

        ghichu.setColumns(20);
        ghichu.setRows(5);
        jScrollPane2.setViewportView(ghichu);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(290, 100, 240, 110);

        jLabel14.setText("Dịch Vụ");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(570, 110, 110, 25);

        jLabel16.setText("Đơn Giá");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(570, 140, 90, 25);
        jPanel1.add(jttenadv);
        jttenadv.setBounds(670, 110, 150, 25);

        jtdongiadv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtdongiadvActionPerformed(evt);
            }
        });
        jPanel1.add(jtdongiadv);
        jtdongiadv.setBounds(670, 140, 150, 25);

        TB2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TB2);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(0, 300, 540, 260);

        TB3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TB3);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(570, 300, 300, 260);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("ĐẶT MÓN ĂN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(220, 30, 100, 25);

        jLabel3.setText("Mã Khách Hàng");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 80, 110, 25);
        jPanel1.add(jtmakh);
        jtmakh.setBounds(120, 80, 150, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("DỊCH VỤ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(670, 30, 60, 25);
        jPanel1.add(jtmakh1);
        jtmakh1.setBounds(670, 80, 150, 25);

        jLabel5.setText("Mã Khách Hàng");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(570, 80, 100, 25);

        jbtthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Exit.png"))); // NOI18N
        jbtthoat.setText("Thoát");
        jbtthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtthoatActionPerformed(evt);
            }
        });
        jPanel1.add(jbtthoat);
        jbtthoat.setBounds(660, 250, 90, 33);

        jLabel6.setText("STT Món Ăn");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 170, 80, 25);

        jLabel7.setText("STT Dịch Vụ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(570, 170, 70, 25);
        jPanel1.add(jtsttma);
        jtsttma.setBounds(120, 170, 70, 25);
        jPanel1.add(jtsttdv);
        jtsttdv.setBounds(670, 170, 70, 25);

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
        jPanel1.add(jbtlammoi);
        jbtlammoi.setBounds(530, 250, 90, 33);

        jsua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Application.png"))); // NOI18N
        jsua1.setText("Sửa");
        jsua1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsua1MouseClicked(evt);
            }
        });
        jsua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsua1ActionPerformed(evt);
            }
        });
        jPanel1.add(jsua1);
        jsua1.setBounds(250, 250, 100, 33);

        jbtxoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Erase.png"))); // NOI18N
        jbtxoa1.setText("Xoá");
        jbtxoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtxoa1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtxoa1);
        jbtxoa1.setBounds(390, 250, 100, 33);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(310, 40, 230, 2);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 42, 10, 180);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(540, 40, 2, 180);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(10, 222, 530, 10);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(10, 42, 200, 10);
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(730, 40, 120, 2);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7);
        jSeparator7.setBounds(550, 40, 2, 180);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator8);
        jSeparator8.setBounds(850, 40, 2, 180);
        jPanel1.add(jSeparator9);
        jSeparator9.setBounds(550, 220, 300, 10);
        jPanel1.add(jSeparator10);
        jSeparator10.setBounds(550, 40, 110, 10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbthemActionPerformed
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        String insert = "INSERT INTO MON (TENMON,DONGIA,GHICHU,MAKH) VALUES(?,?,?,?)";
        String insert1="insert into DICHVU(TENDV,DONGIA,MAKH) VALUES(?,?,?)";
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(insert);
         //   ps.setString(0, jtsttma.getText());
            // if (this.jtmasanh.getText().length()==0) JOptionPane.showMessageDialog(null, "Mã Sảnh không thể bỏ trống", "thông báo",2);
            ps.setString(1, jttenmonan.getText());
            ps.setString(2,jtdongia.getText());//SelectedItem().toString());
            ps.setString(3, ghichu.getText());
            ps.setInt(4,Integer.parseInt(jtmakh.getText()));
        int ret = ps.executeUpdate();
        if (ret != -1) {
            // jlbStatus.setText("The Khoa has been insertet");
            JOptionPane.showMessageDialog(this, "Thêm Thành Công Món Ăn");
            this.loadmon();
        }
        else{
            JOptionPane.showMessageDialog(this, "Không Thành Công Món Ăn");
        }     
        }catch (HeadlessException | NumberFormatException | SQLException ex) {
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
            } catch (SQLException ex2) {}
            }               
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(insert1);
            ps.setString(1, jttenadv.getText());
            ps.setString(2,jtdongiadv.getText());//SelectedItem().toString());
            ps.setInt(3,Integer.parseInt(jtmakh1.getText()));
        int ret1 = ps.executeUpdate();
        if (ret1 != -1) {
            // jlbStatus.setText("The Khoa has been insertet");
            JOptionPane.showMessageDialog(this, "Thêm Thành Công Dịch Vụ");
            this.loaddv();
        }
        else{
            JOptionPane.showMessageDialog(this, "Không Thành Công Dịch Vụ");
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
            } catch (SQLException ex1) {
            }
        }
    }//GEN-LAST:event_jbthemActionPerformed

    private void jtdongiadvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtdongiadvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtdongiadvActionPerformed

    private void jbtthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtthoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jbtthoatActionPerformed

    private void jbtlammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtlammoiMouseClicked
        // TODO add your handling code here:
        jtmakh.setText("");
        jtmakh1.setText("");
        jtsttma.setText("");
        jtsttdv.setText("");
        jttenmonan.setText("");
        jttenadv.setText("");
        jtdongia.setText("");
        jtdongiadv.setText("");
        ghichu.setText("");
        this.loadmon();
        this.loaddv();
        // tblModel.setRowCount(0);
    }//GEN-LAST:event_jbtlammoiMouseClicked

    private void jbtlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtlammoiActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_jbtlammoiActionPerformed

    private void jsua1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsua1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jsua1MouseClicked

    private void jsua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsua1ActionPerformed
      int ret = JOptionPane.showConfirmDialog(this, "Bạn Muốn Sửa Món Ăn và Dịch Vụ?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        String insert1="update MON set TENMON= ?,DONGIA= ?,GHICHU= ?,MAKH= ? where STTMON= ?";
        String insert = "update DICHVU set TENDV= ?,DONGIA= ?,MAKH=? where STTDV= ?";
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(insert);
         ps.setInt(4,Integer.parseInt(jtsttdv.getText()));
         ps.setString(1,jttenadv.getText());
         ps.setInt(2,Integer.parseInt(jtdongiadv.getText()));
         ps.setInt(3,Integer.parseInt(jtmakh1.getText()));
           ret = ps.executeUpdate();
        if (ret != -1) {
            JOptionPane.showMessageDialog(this, "Sửa Thành Công Dịch Vụ");
                       this.loaddv();
        }
        else{
            JOptionPane.showMessageDialog(this, "Không Thành Công Dịch Vụ");
        }     
        }catch (HeadlessException | NumberFormatException | SQLException ex) {
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
            } catch (SQLException ex2) {}
            }               
      
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(insert1);
           ps.setInt(5,Integer.parseInt(jtsttma.getText()));
            ps.setString(1,jttenmonan.getText());
            ps.setInt(2,Integer.parseInt(jtdongia.getText()));
            ps.setString(3,ghichu.getText());
            ps.setInt(4,Integer.parseInt(jtmakh.getText()));
         ret = ps.executeUpdate();
        if (ret != -1) {
            JOptionPane.showMessageDialog(this, "Sửa Thành Công Món Ăn");
            this.loadmon();
        }
        else{
            JOptionPane.showMessageDialog(this, "Sửa Không Thành Công Món Ăn");
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
            } catch (SQLException ex1) {
            }
        }
    }//GEN-LAST:event_jsua1ActionPerformed

    private void jbtxoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtxoa1ActionPerformed
     
        int ret = JOptionPane.showConfirmDialog(this, "Bạn Muốn Xóa?", "Thôn Báo", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
          Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String deletesql;
        deletesql = "Delete MON where STTMON = ?";
        String deletesql11 = "DELETE DICHVU WHERE STTDV= ?";
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(deletesql);
            ps.setInt(1,Integer.parseInt(jtsttma.getText()));
            ret = ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(this, "Xóa Thành Công Món Ăn");
                this.loadmon();
            }
            return;
        } catch (HeadlessException | NumberFormatException | SQLException ex) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex2) {
            }
        }
   try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(deletesql11);
            ps.setInt(1,Integer.parseInt(jtsttdv.getText()));
            ret = ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(this, "Xóa Thành Công Dịch Vụ");
                  this.loaddv();
            }
        } catch (HeadlessException | NumberFormatException | SQLException ex) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex2) {
            }
        }
    }//GEN-LAST:event_jbtxoa1ActionPerformed

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
            java.util.logging.Logger.getLogger(DatMonAnDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DatMonAnDV().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TB2;
    private javax.swing.JTable TB3;
    private javax.swing.JTextArea ghichu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton jbthem;
    private javax.swing.JButton jbtlammoi;
    private javax.swing.JButton jbtthoat;
    private javax.swing.JButton jbtxoa1;
    private javax.swing.JButton jsua1;
    private javax.swing.JTextField jtdongia;
    private javax.swing.JTextField jtdongiadv;
    private javax.swing.JTextField jtmakh;
    private javax.swing.JTextField jtmakh1;
    private javax.swing.JTextField jtsttdv;
    private javax.swing.JTextField jtsttma;
    private javax.swing.JTextField jttenadv;
    private javax.swing.JTextField jttenmonan;
    // End of variables declaration//GEN-END:variables
}
