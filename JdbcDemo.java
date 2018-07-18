package org.btm.jdbcApp.PreparedStmt;

import java.sql.*;

public class JdbcDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into muzeeb.student values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=muzeeb");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1,5);
			pstmt.setString(2, "charan");
			pstmt.setDouble(3, 73.1);
			pstmt.executeUpdate();
			pstmt.setInt(1,6);
			pstmt.setString(2, "haritha");
			pstmt.setDouble(3, 68.1);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
