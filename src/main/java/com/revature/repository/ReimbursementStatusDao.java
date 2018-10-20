package com.revature.repository;

import org.hibernate.Session;

import com.revature.model.ReimbursementStatus;
import com.revature.util.HibernateUtil;

public class ReimbursementStatusDao {
	public String getStatusById(int id) {
		ReimbursementStatus rs = null;
		Session session = HibernateUtil.getSession();
		
		rs = (ReimbursementStatus) session.createQuery(
				"from ReimbursementStatus where id = :idVar")
				.setInteger("idVar", id);
		
		if (rs != null)
			return rs.getStatus();
		return null;
	}
}
