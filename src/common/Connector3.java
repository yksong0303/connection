package common;
import java.sql.*;

public class Connector3{
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
		}catch(ClassNotFoundException e) {
		e.printStackTrace();
		}
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","c##test","test");
			String sql = "select * from test";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("num"));
			}
			sql = "update test set id = ?, name = ? where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,"하이");
			ps.setString(2,"바이");
			ps.setInt(3, 2);
			ps.executeUpdate();
			sql = "insert into test(name, id , user) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "하이2");
			ps.setString(2, "바이2");
			ps.setString(3, "보이");
			ps.executeUpdate();
			sql = "delete from test where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 20);
			ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}