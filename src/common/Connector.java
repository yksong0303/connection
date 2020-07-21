package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	private static Connection open;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID = "c##test";
	private static final String PWD = "test";
	private static final String DN = "oracle.jdbc.driver.OracleDriver";
	
	static {
	      try {
	         Class.forName(DN);
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }

	   public static Connection open() {
	      try {
	         Connection conn =  DriverManager.getConnection(URL, ID, PWD);
	         conn.setAutoCommit(false);
	         return conn;
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return null;
	   }
	   public static void close() {
	      try {
	         if(open!= null) {
	            open.close();
	         }
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }
	         open = null;
	      }
	}
	    