package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.User;
import com.util.services.UserService;
import com.util.services.UserServiceFake;

public class RegisterServlet extends HttpServlet{
private UserService userService = new UserServiceFake();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("register.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullname = req.getParameter("fullname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String title = req.getParameter("title");
		//String password = req.getParameter("password");
		User user = userService.registerUser(fullname, username, password, email, title);
		
		if (user == null) {
			resp.setStatus(401);
			resp.getWriter().write("Failed Login");
		} else {
			//resp.getWriter().write("Successful Login");
			req.getRequestDispatcher("home").forward(req, resp);
		}
		
	}

}
