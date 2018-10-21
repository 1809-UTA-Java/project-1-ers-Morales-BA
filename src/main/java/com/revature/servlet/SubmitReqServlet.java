package com.revature.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.repository.ReimbursementDao;

@WebServlet("/submissioncheck")
public class SubmitReqServlet extends HttpServlet {
	ReimbursementDao dao = new ReimbursementDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User u  = (User) session.getAttribute("user");

		if (u != null && u.getRoleId() == 0) {
			Reimbursement r = new Reimbursement();
			r.setAuthorId(u.getId());
			
			double dAmt = Double.parseDouble(req.getParameter("amount"));
			r.setAmount(dAmt);
			
			String sDsc = (String) req.getParameter("description");
			if (!sDsc.isEmpty())
				r.setDescription(sDsc);
			
			if (req.getParameter("receipt") != null) {
				File fRec = new File(req.getParameter("receipt"));
				if (fRec != null && fRec.exists())
					r.setReceipt(fRec);
			}
			
			String sRT = req.getParameter("rtype");
			int iRT = Integer.parseInt(sRT);
			r.setRtId(iRT);
			
			// 0 for pending
			r.setRsId(0);
			
			dao.saveReimbursement(r);
			
			PrintWriter pw = resp.getWriter();
			pw.println("Submission completed");
			pw.println("Go to /employee.html to continue or /logoff to log off");
			pw.close();
		} else
			resp.sendRedirect("/index.html");
	}
}
