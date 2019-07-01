package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.User;
import com.util.services.UserService;
import com.util.services.UserServiceFake;


public class LoginServlet extends HttpServlet{
	
	private UserService userService = new UserServiceFake();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("userlogin.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userService.loginUser(username, password);
		
		if (user == null) {
			resp.setStatus(401);
			resp.getWriter().write("Failed Login");
		} else {
			//resp.getWriter().write("Successful Login");
			req.getRequestDispatcher("home").forward(req, resp);
		}
		
	}

}

