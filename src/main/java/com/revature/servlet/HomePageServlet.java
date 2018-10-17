package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.repository.UserDao;

@WebServlet("/check")
public class HomePageServlet extends HttpServlet {

	UserDao dao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/xml");
		ObjectMapper om = new XmlMapper();
		String obj = om.writeValueAsString(dao.get)
		PrintWriter pw = resp.getWriter();
		String arg1 = req.getParameter("username");
		String arg2 = req.getParameter("password");
		
		if (arg1 == null)
			resp.sendRedirect("index");
		
		pw.println("GET " + arg1 + " password " + arg2);
		pw.close();
	}
}
