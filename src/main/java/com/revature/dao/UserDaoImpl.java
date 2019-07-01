package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;


public class UserDaoImpl implements UserDao {

	private static Connection conn = ConnectionFactory.getConnection();
	//public static ArrayList<Customer> userList = new ArrayList<Customer> ();

	@Override
	public ArrayList <User> getAllUsers() {

		ArrayList<User> userList = new ArrayList<User> ();
		String sql = "Select * from user_trms";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				userList.add(new User( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	
	public void createUser(User u) {
		// TODO Auto-generated method stub
		try {
			conn.setAutoCommit(false);
			String query = "Insert into user_trms(fullname, username, password, email, title) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getFullname());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getTitle());
			Savepoint sp = conn.setSavepoint("Before Creating Customer");
			boolean check = pstmt.execute();
			if (check) {
				conn.rollback(sp);
				LoggingUtil.error("Customer was not added.Repeat");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Creating Customer was successful");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		UserDaoImpl usdi = new UserDaoImpl();
//		System.out.println(usdi.getAllUsers());
	
}