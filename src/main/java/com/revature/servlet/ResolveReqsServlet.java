package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.repository.ReimbursementDao;

@WebServlet("/judge")
public class ResolveReqsServlet extends HttpServlet {
	ReimbursementDao dao = new ReimbursementDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("user");
		
		if (u != null && u.getRoleId() == 1) {
			
			int reqId = Integer.parseInt(req.getParameter("reqid"));
			int rsId = Integer.parseInt(req.getParameter("rstatus"));
			
			Reimbursement r = dao.getReimbursementById(reqId);
			if (r != null) {
				r.setResolverId(u.getId());
				r.setRsId(rsId);
				Timestamp resolved = new Timestamp(System.currentTimeMillis());
				r.setResolved(resolved);

				dao.updateReimbursement(r);

				PrintWriter pw = resp.getWriter();
				pw.println("Request Resolved");
				pw.println("Go to /manager.html to continue or /logoff to log off");
				pw.close();
			} else
				resp.sendRedirect("/index.html");
		} else
			resp.sendRedirect("/index.html");
	}
}
