package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;
import com.revature.repository.UserDao;

@WebServlet("/viewemps")
public class ViewEmpsServlet extends HttpServlet {
	UserDao uDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		User u = (User) session.getAttribute("user");
		
		if(u != null && u.getRoleId() == 1) {
			List<User> users = new ArrayList<>();
			users = uDao.getEmployees();
			
			PrintWriter pw = resp.getWriter();
			pw.println(Arrays.toString(users.toArray()));
			pw.println("Go to /manager.html to continue or /logoff to logoff.");
			pw.close();
		}
	}
}
