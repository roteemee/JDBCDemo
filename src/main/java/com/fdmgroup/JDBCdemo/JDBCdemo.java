package com.fdmgroup.JDBCdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// tells java which database we're working with
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			// Sets up connection with oracle database
			String url = "jdbc:oracle:thin:trainee1/!QAZSE4@localhost:1521:xe"; // this is the connection details from
																				// sql developer
			Connection connection = DriverManager.getConnection(url);

			Statement statement = connection.createStatement();

			String sql = "SELECT BROKER_ID, FIRST_NAME, LAST_NAME FROM BROKERS";
			// runs SQL query and saves results
			ResultSet resultSet = statement.executeQuery(sql);
			
			  /*while(resultSet.next()) { 
			   int id = resultSet.getInt("broker_id"); String
			 firstname = resultSet.getString("first_name"); String lastname =
			 resultSet.getString("last_name");
			  }
			  
			  System.out.println(id+": "+firstname+" "+lastname);
			

			Statement statement2 = connection.createStatement();
			String insertStament = "INSERT INTO brokers VALUES(16,'Nick', 'Lawton')";
			int rows = statement2.executeUpdate(insertStament);// running this every time we want to update a table in
															// our database
			System.out.println(rows + " rows inserted");
*/	
			
			Statement statement3 = connection.createStatement();
			String updateStatement = "Update brokers SET first_name = 'Bob' Where broker_id = 1";
			int rows = statement3.executeUpdate(updateStatement);
			System.out.println(rows+" rows updated");
			
			Statement statement4 = connection.createStatement();
			String deleteStatement = "DELETE FROM brokers WHERE BROKER_ID = 16";
			rows = statement4.executeUpdate(deleteStatement);
			System.out.println(rows+" rows deleted");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		listBrokersByFirstName("John");
		//listBrokersByFirstName("X' or 'y' = 'y");
		
	}

	public static void listBrokersByFirstName(String fName) {
		try {
			// tells java which database we're working with
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			// Sets up connection with oracle database
			String url = "jdbc:oracle:thin:trainee1/!QAZSE4@localhost:1521:xe"; // this is the connection details from sql developer
			Connection connection = DriverManager.getConnection(url);
			//? is a wildcard
			String sql = "SELECT BROKER_ID, FIRST_NAME, LAST_NAME FROM BROKERS WHERE first_name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//define what value ? is 1st arg in position of ?, 2nd arg is the value
			preparedStatement.setString(1, fName);
			ResultSet resultSet = preparedStatement.executeQuery();;
			while(resultSet.next()) {
				int id = resultSet.getInt("broker_id");
				String firstname = resultSet.getString("first_name");
				String lastname = resultSet.getString("last_name");
				
				System.out.println(id+": "+firstname+" "+lastname);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

