package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;
import com.revature.repository.UserDao;

@SuppressWarnings("serial")
@WebServlet("/check")
public class LoginCheckServlet extends HttpServlet {
	UserDao dao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sUsername = req.getParameter("username");
		String sPassword = req.getParameter("password");
		
		User uLogin = dao.getUserByUserName(sUsername);
		
		if (uLogin != null && sPassword.equals(uLogin.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("username", sUsername);
			
			if (uLogin.getRoleId() == 1)
				resp.sendRedirect("manager.html");
			else
				resp.sendRedirect("employee.html");
		} else {
			resp.sendRedirect("index.html");
		}
	}
}
