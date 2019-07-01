package com.util.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;



public class UserServiceFake implements UserService {
	
	private static UserDaoImpl usdi = new UserDaoImpl();
	
	private List<User> userDao;

	public User loginUser(String username, String password) {
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		User user = null;
		
		for (User check : usdi.getAllUsers()) {
			if(check.getUsername().equals(username) && check.getPassword().equals(password)) {
				user = check;
				break;
			}
		}
		
		return user;
	}
	
	public User registerUser (String fullname, String username, String password, String email, String title) {
		usdi.createUser(new User(fullname, username, password, email, title));
		
		
		return null;
		
	}
	
	public User registerUser1 (String fullname, String username, String password, String email, String title) {
		usdi.createUser(new User(fullname, username, password, email, title));
		
		
		return null;
		
	}
	
	public UserServiceFake() {
		userDao = new ArrayList<User>();
		//userDao.add(new User("mah", "123", "mohamad"));
		//userDao.add(new User("dinosour", "dev123", "donald"));
	}

}
