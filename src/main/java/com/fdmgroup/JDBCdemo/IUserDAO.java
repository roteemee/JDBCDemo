package com.fdmgroup.JDBCdemo;

import java.util.List;

public interface IUserDAO {
	public void addUser (User user);
	public User getUser (String username);
	public void removeUser(String username);
	public void updateUser (User user);
	public List<User> listUsers();


}
