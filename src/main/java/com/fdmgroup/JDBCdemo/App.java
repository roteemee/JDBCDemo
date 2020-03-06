package com.fdmgroup.JDBCdemo;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDAO ud = new UserDAO();
		ud.listUsers();
		
		for (User user: ud.listUsers()) {
			String username = user.getUsername();
			String first_name = user.getFirstName();
			String last_name = user.getLastName();
			String email = user.getEmail();
			System.out.println(username+" "+ first_name+" "+ last_name+" "+ email);
		}
		

	}

}
