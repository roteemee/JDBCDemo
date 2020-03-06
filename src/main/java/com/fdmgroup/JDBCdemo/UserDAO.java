 package com.fdmgroup.JDBCdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
	
	
	
public UserDAO() {

	
}

	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeUser(String username) {
		// TODO Auto-generated method stub

	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	public List<User> listUsers() {
		List<User> users = new ArrayList<User>();
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			String url = "jdbc:oracle:thin:trainee1/!QAZSE4@localhost:1521:xe"; 
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			String userList = "SELECT username, first_name, last_name, password, email, role, status FROM TPUSERS";
			int rows = statement.executeUpdate(userList);
			System.out.println(rows+" rows");
			
			ResultSet resultSet = statement.executeQuery(userList);
			while(resultSet.next()) { 
				String username = resultSet.getString("username");   
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String role = resultSet.getString("role");
				int status = resultSet.getInt("status");
				
				User user = new User(username, first_name, last_name, password, email, role, status);
				users.add(user);
			
			
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

}
