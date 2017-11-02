 
package Main;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
public class qltieccuoi {
   
private final Connection con;
public  qltieccuoi() throws ClassNotFoundException,SQLException{
      String s = "jdbc:sqlserver://hotaru:1433;databaseName=QLTIECCUOI";
      this.con=DriverManager.getConnection(s,"sa","votinh");
}
public ResultSet GetData(String tbName) throws SQLException{
    ResultSet kq= null;
    Statement statement = this.con.createStatement();
    String sql= "select *  from SANH";
    kq=statement.executeQuery(sql);
    return kq;
    }
public void Update(String MASANH,String TENSANH,String LOAISANH,int SOBANMAX,String GIATIENTOIDA,String CHUY) throws SQLException{
   Statement sta= this.con.createStatement();
    String sql1="update SANH set TENSANH=N'"+TENSANH+"',LOAISANH=N'"+LOAISANH+"',SOBANMAX=N'"+SOBANMAX+"',GIATIENTOIDA=N'"+GIATIENTOIDA+"',CHUY=N'"+CHUY+"' where MASANH=N'"+MASANH+"'";
    sta.executeUpdate(sql1);
}
public void Updatekh(int MAKH,String TENCHURE,String TENCODAU,int SODT ,Date NGAY,String CA,int TIENDATCOC,int MASANH,int SOLUONGBAN,int SOLUONGBANDUTRU) throws SQLException{
   Statement sta= this.con.createStatement();
    String sql="update KHACHHANG set TENCHURE=N'"+TENCHURE+"',TENCODAU=N'"+TENCODAU+"',SODT=N'"+SODT+"',NGAY=N'"+NGAY+"',CA=N'"+CA+"',TIENDATCOC='"+TIENDATCOC+"',MASANH='"+MASANH+"',SOLUONGBAN='"+SOLUONGBAN+"',SOLUONGBANDUTRU='"+SOLUONGBANDUTRU+"' where MAKH="+MAKH+"";
    sta.executeUpdate(sql);
}
public void delete(String MASANH,String TENSANH) throws SQLException{
    Statement sta= this.con.createStatement();
    String sql="DELETE SANH WHERE MASANH='"+MASANH+"' OR TENSANH='"+TENSANH+"'";
    sta.executeUpdate(sql);
 
}
public void deletekh(int MAKH) throws SQLException{
    Statement sta= this.con.createStatement();
    String sql="DELETE KHACHHANG WHERE MAKH='"+MAKH+"'";
    sta.executeUpdate(sql);
 
}
public void Close () throws SQLException{
        if(this.con!=null)
            this.con.close();
}
public static void main(String[] args) throws ClassNotFoundException,SQLException{
    qltieccuoi con=new qltieccuoi();
    ResultSet rs= con.GetData("BIENLAI");
}

}
