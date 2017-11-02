/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS 10
 */
public class HoaDonThanhToan extends javax.swing.JFrame {
private final String header[] = {"MAKH","TENCHURE", "TENCODAU", "MASANH", "NGAY", "CA","SOLUONGBAN","SLMON","SLDICHVU","TIENDATCOC","GIATIENTOIDA","SODT"};
private final String BIENLAI[]={"SOHD","NGAY","TONGTG","MAKH","MASANH"};
private final DefaultTableModel tblModel = new DefaultTableModel(header, 0);
private final DefaultTableModel tblMode11 = new DefaultTableModel(BIENLAI, 0);
   
    public HoaDonThanhToan() {
        initComponents();
        load();
        loadbl();
    }
     private void load(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql = "select * from HOADON ";// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            tblModel.setRowCount(0);
            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không Có Hóa Đơn,Tháng Nghèo Đói!");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
              data = new Vector();    
                   data.add(rs.getString("MAKH"));
              data.add(rs.getString("TENCHURE"));
              data.add(rs.getString("TENCODAU"));
              data.add(rs.getString("MASANH"));
              data.add(rs.getString("NGAY"));
                data.add(rs.getString("CA"));
                data.add(rs.getString("SOLUONGBAN"));
                data.add(rs.getString("SLMON"));
                data.add(rs.getString("SLDICHVU"));
                    data.add(rs.getString("TIENDATCOC"));
                    data.add(rs.getString("GIATIENTOIDA"));
                    data.add(rs.getString("SODT"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }
            jtbhoadon.setModel(tblModel); // Thêm dữ liệu vào table
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
      private void loadbl(){
    Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql = "select * from BIENLAI ";// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            tblMode11.setRowCount(0);
            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không có Bien Lai!");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
              data = new Vector();
                data.add(rs.getInt("SOHD"));
                data.add(rs.getString("NGAY"));
                data.add(rs.getString("TONGTG"));
                data.add(rs.getString("MAKH"));
                data.add(rs.getString("MASANH"));
                // Thêm một dòng vào table model
                tblMode11.addRow(data);
            }

               jtbhoadoan.setModel(tblMode11); // Thêm dữ liệu vào table   
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
            String sql = "select * from HOADON";
            if (jmakh.getText().length() > 0 && jmasanh.getText().length()>0) {
                sql = sql + " where MAKH = N'" + jmakh.getText() + "' and MASANH="+jmasanh.getText()+"";
            } if(jmakh.getText().length()==0 || jmasanh.getText().length()==0){
                 sql = "select * from HOADON ";
            }
            st = conn.createStatement();// Tạo đối tượng thực thi câu lệnh Select
            rs = st.executeQuery(sql);// Thực thi 
            Vector data = null;
            tblModel.setRowCount(0);
            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không Có Dữ Liệu");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
              data = new Vector();
           data.add(rs.getString("MAKH"));
              data.add(rs.getString("TENCHURE"));
              data.add(rs.getString("TENCODAU"));
              data.add(rs.getString("MASANH"));
              data.add(rs.getString("NGAY"));
                data.add(rs.getString("CA"));
                data.add(rs.getString("SOLUONGBAN"));
                data.add(rs.getString("SLMON"));
                data.add(rs.getString("SLDICHVU"));
                    data.add(rs.getString("TIENDATCOC"));
                    data.add(rs.getString("GIATIENTOIDA"));
                    data.add(rs.getString("SODT"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }
            jtbhoadon.setModel(tblModel); // Thêm dữ liệu vào table
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
      public static java.sql.Date converUtilDateToSqlDate(java.util.Date date){
        if (date != null){
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
 public static java.util.Date convertSqlDateToUtilDate(java.sql.Date date){
        if(date != null){
            java.util.Date sqlDate = new java.util.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
     private void Kiemtra() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        int k = 0;
        int index = Integer.valueOf( jmakh.getText().toString());
        if(index <0) // khong co thang dc chon.
            return;
//        Vector item = (Vector)jComboBox1.getSelectedItem();
//        int Thang= Integer.parseInt(item.get(0).toString());
        
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql = "select sum (DONGIA) from DICHVU where MAKH=" + index;// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql);
            if(rs.next()==false)
                return;
            jtdv.setText(Long.toString(rs.getInt(1))); // Thêm dữ liệu vào jtexts
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
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql1="select distinct (k.soluongban*m.tonggiama) from KHACHHANG k,tongma m where k.MAKH="+index;
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql1);
            if(rs.next()==false)
                return;
            jttienban.setText(Long.toString(rs.getInt(1))); 
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
        try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql1="select TIENDATCOC from KHACHHANG where MAKH= "+index;
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql1);
            if(rs.next()==false)
                return;
            jtdatcoc.setText(Long.toString(rs.getInt(1))); 
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
          try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql1="select distinct (TONGGIADV+tong)from Tongban,tongdv,KHACHHANG kh where kh.MAKH= "+index;
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql1);
            if(rs.next()==false)
                return;
            jthoadon.setText(Long.toString(rs.getInt(1))); 
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
          try {
            conn = DriverManager.getConnection(dbURL);// Câu lệnh xem dữ liệu
            String sql1="select distinct (tongtt-TIENDATCOC) from KHACHHANG k,CON  where k.MAKH= "+index;
            st = conn.createStatement();// Thực thi 
            rs = st.executeQuery(sql1);
            if(rs.next()==false)
                return;
            jtcon.setText(Long.toString(rs.getInt(1))); 
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
        jLabel3 = new javax.swing.JLabel();
        jDatengay = new com.toedter.calendar.JDateChooser();
        jmakh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jmasanh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbhoadon = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtdv = new javax.swing.JTextField();
        jttienban = new javax.swing.JTextField();
        jtcon = new javax.swing.JTextField();
        jtdatcoc = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jthoadon = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jbtlammoi = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbhoadoan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("  HÓA ĐƠN THANH TOÁN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(370, 0, 160, 30);

        jLabel3.setText("Mã Khách Hàng");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 50, 100, 28);

        jDatengay.setDate(new java.util.Date(1509012007000L));
        jDatengay.setDateFormatString("MMM d, yyyy");
        jDatengay.setEnabled(false);
        jPanel1.add(jDatengay);
        jDatengay.setBounds(710, 50, 160, 28);
        jPanel1.add(jmakh);
        jmakh.setBounds(130, 50, 160, 28);

        jLabel7.setText("Mã Sảnh");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(330, 50, 90, 28);

        jmasanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmasanhActionPerformed(evt);
            }
        });
        jPanel1.add(jmasanh);
        jmasanh.setBounds(400, 50, 160, 28);

        jLabel4.setText("Ngày Thanh Toán");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(600, 50, 110, 28);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 36, 880, 10);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 39, 10, 48);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(890, 38, 2, 48);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(10, 86, 880, 2);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(310, 39, 10, 48);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(583, 39, 2, 49);

        jtbhoadon.setModel(new javax.swing.table.DefaultTableModel(
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
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
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
        jScrollPane1.setViewportView(jtbhoadon);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 140, 930, 220);

        jLabel8.setText("Tổng Tiền Dịch Vụ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 420, 90, 28);

        jLabel11.setText("Tổng  Tiền Bàn");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 460, 90, 28);

        jLabel12.setText("Tổng Hóa Đơn");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(30, 540, 90, 28);

        jLabel13.setText("Còn Lại");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(30, 580, 90, 28);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("XEM CHI TIẾT HÓA ĐƠN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(360, 100, 180, 30);
        jPanel1.add(jtdv);
        jtdv.setBounds(160, 420, 200, 28);
        jPanel1.add(jttienban);
        jttienban.setBounds(160, 460, 200, 28);
        jPanel1.add(jtcon);
        jtcon.setBounds(160, 580, 200, 28);
        jPanel1.add(jtdatcoc);
        jtdatcoc.setBounds(160, 500, 200, 28);

        jLabel14.setText("Tiền Đặt Cọc");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(30, 500, 90, 28);
        jPanel1.add(jthoadon);
        jthoadon.setBounds(160, 540, 200, 28);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("KIỂM TRA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(150, 370, 100, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Exit.png"))); // NOI18N
        jButton5.setText("Thát");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(770, 370, 90, 33);

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
        jbtlammoi.setBounds(670, 370, 90, 33);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/24x24/Add.png"))); // NOI18N
        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(560, 370, 90, 33);

        jtbhoadoan.setModel(new javax.swing.table.DefaultTableModel(
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
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
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
        jScrollPane2.setViewportView(jtbhoadoan);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(430, 420, 500, 200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmasanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmasanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmasanhActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.search();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.Kiemtra();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jbtlammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtlammoiMouseClicked
        // TODO add your handling code here:
        jmakh.setText("");
        jmasanh.setText("");
        jtcon.setText("");
        jttienban.setText("");
        jthoadon.setText("");
        jtdv.setText("");
        jtdatcoc.setText("");
        
        // tblModel.setRowCount(0);
    }//GEN-LAST:event_jbtlammoiMouseClicked

    private void jbtlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtlammoiActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_jbtlammoiActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI;user=sa;password=votinh";
        String insert = "INSERT INTO BIENLAI (NGAY,TONGTG,MAKH,MASANH) VALUES(?,?,?,?)";
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(insert);
            //ps.setString(1, jtmasanh.getText());
            // if (this.jtmasanh.getText().length()==0) JOptionPane.showMessageDialog(null, "Mã Sảnh không thể bỏ trống", "thông báo",2);
            ps.setDate(1, converUtilDateToSqlDate(jDatengay.getDate()));
            ps.setInt(2,Integer.parseInt(jthoadon.getText()));
            ps.setInt(3,Integer.parseInt(jmakh.getText()));
            ps.setInt(4,Integer.parseInt(jmasanh.getText()));
        int ret = ps.executeUpdate();
        if (ret != -1) {
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
        }
        else{
            JOptionPane.showMessageDialog(this, "Không Thành Công");
        }
        this.loadbl();
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

    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HoaDonThanhToan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDatengay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JButton jbtlammoi;
    private javax.swing.JTextField jmakh;
    private javax.swing.JTextField jmasanh;
    private javax.swing.JTable jtbhoadoan;
    private javax.swing.JTable jtbhoadon;
    private javax.swing.JTextField jtcon;
    private javax.swing.JTextField jtdatcoc;
    private javax.swing.JTextField jtdv;
    private javax.swing.JTextField jthoadon;
    private javax.swing.JTextField jttienban;
    // End of variables declaration//GEN-END:variables
}
