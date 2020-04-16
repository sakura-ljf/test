package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {
	private static Connection conn=null;
	private static Statement st=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	public static Connection getConn() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/bookshop?seUnicode=true&characterEncoding=utf-8";
		String name="root";
		String password="1302594499";
		Connection conn=DriverManager.getConnection(url, name, password);
		return conn;
	}
	public static void main () throws ClassNotFoundException, SQLException{
		Connection conn=ConnDB.getConn();
		
		if(conn!=null){
			System.out.println("数据库连接成功");
		}
		else
		{
			System.out.println("数据库连接失败");
		}
	}
	
	public static void close() throws SQLException{
		if(rs!=null)
		{
			rs.close();
		}	
		if(ps!=null)
		{
			ps.close();
		}
		if(st!=null)
		{
			st.close();
		}
		if(conn!=null)
		{
			conn.close();
		}
	}
}

