package com.util.services;

import com.revature.pojo.User;

public interface UserService {

	public User loginUser(String username, String password); 
	
	public User registerUser(String fullname, String username, String password, String email, String title);
	
}
