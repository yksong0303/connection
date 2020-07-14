package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector2 {
	private static final String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String user = "c##test";
	private static final String password = "test";
	private static final String DN = "oracle.jdbc.driver.OracleDriver";
	private static Connection conn;
	
	static {
		try {
			Class.forName(DN);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection open() {
		if(conn==null) {
			try {
				return DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Connection con = open();
		try {
			Statement stmt = con.createStatement();
			String sql = "select l_num, l_lentdate, l_recdate, m_num, b_num from lent";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("l_num"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
