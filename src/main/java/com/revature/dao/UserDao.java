package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojo.User;



public interface UserDao {
	public void createUser(User u);
	
	//public void updateCustomer(User u);
	
	//public void deleteCustomer(User u);
	
	//public User getCustomerById(Integer id);
	
	//public User getCustomerByCustomername(String Username);
	
	public ArrayList<User> getAllUsers();

	//void preparedUpdateCustomer(User u);


}
