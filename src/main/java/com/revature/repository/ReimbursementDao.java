package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Reimbursement;
import com.revature.util.HibernateUtil;

public class ReimbursementDao {
	public List<Reimbursement> getReimbursements() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Reimbursement").list();
	}
	
	public List<Reimbursement> getReimbursementsByAuthor(int id) {
		Session session = HibernateUtil.getSession();
		return session.createQuery(
				"from Reimbursement where authorId = :nameVar")
				.setInteger("nameVar", id).list();
	}
	
	public List<Reimbursement> getPendingReimbursements() {
		Session session = HibernateUtil.getSession();
		return session.createQuery(
				"from Reimbursement where rtId = :statusVar")
				.setInteger("statusVar", 0).list();
	}
	
	public List<Reimbursement> getResolvedReimbursements() {
		Session session = HibernateUtil.getSession();
		return session.createQuery(
				"from Reimbursement where rtId != :statusVar")
				.setInteger("statusVar", 0).list();
	}
	
	public int saveReimbursement(Reimbursement r) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int result = (int) session.save(r);
		tx.commit();
		return result;
	}
}
