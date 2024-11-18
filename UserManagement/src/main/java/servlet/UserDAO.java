package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.User;

public class UserDAO {
	public int updateUser(int id, String name, String email, String password) {
		String query = "Update User SET name=?, email=?, password=? WHERE id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_management", "root", "Priya@123");
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			rows = pstmt.executeUpdate();
			
		} catch(ClassNotFoundException ex) {
			System.out.println("JDBC Driver not found");
		}catch(SQLException e) {
			
			e.printStackTrace();
		
		}
		
		return rows;
	}

	public  int insertUser(String name, String email, String password )
	{
		String query = "insert into user(name, email, password) values (?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_management", "root", "Priya@123");
	
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		rows = pstmt.executeUpdate();



	} catch(ClassNotFoundException ex) {
	System.out.println("JDBC Driver not found");
	}
	catch(SQLException e) {
	e.printStackTrace();
	
	}
	return rows;
	}
	
	public User getUser(String email, String password) {
		String query = "SELECT * FROM User WHERE email = ? AND password = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		User user = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_Management", "root", "Priya@123");
			
			pstmt = con.prepareStatement(query);	
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User(rs.getInt("id") , rs.getString("name") , rs.getString("email") , rs.getString("password"));
//				System.out.println(rs.getInt("id"));
//				System.out.println(rs.getString("name"));
//				System.out.println(rs.getString("email"));
//				System.out.println(rs.getString("password"));
			} 
			
		} catch(ClassNotFoundException ex) {
			System.out.println("JDBC Driver not found");
		}
		catch  (SQLException e) {
			e.printStackTrace();
			
		}
			return user;
		}


public boolean deleteUser(String name, String email, String password) {
	 String deleteQuery = "DELETE FROM employees WHERE id = ?";
	 Connection con = null;
	 PreparedStatement psmt = null;
	 
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User_Management", "root", "Priya@123");

		 	psmt = con.prepareStatement(deleteQuery);	
			psmt.setString(1, name);
			psmt.setString(2, email);
			psmt.setString(3, password);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch(ClassNotFoundException ex) {
			System.out.println("JDBC Driver not found");
		}
		catch  (SQLException e) {
			e.printStackTrace();
			
		}
			return false;
		}

}





