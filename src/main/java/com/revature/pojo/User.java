package com.revature.pojo;

public class User {
	
	private String username;
	private String password;
	private String fullname;
	private String title;
	private String email;
	private int id;
	//public String input1, input2, input3, input4, input5, input6;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int id, String username, String password, String fullname, String title, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.title = title;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
//
//	public User(String username, String password, String fullname) {
//		this.username = username;
//		this.password = password;
//		this.fullname = fullname;	}

	public User(String fullname, String username, String password, String email, String title) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.title = title;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", fullname=" + fullname + ",title=" + title + ",email=" + email + ", id=" + id + "]";
	}



	
	

	
	
}
