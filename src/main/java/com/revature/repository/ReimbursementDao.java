package com.revature.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

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
	
	public List<Reimbursement> getPendingByAuthor(int id) {
		Session session = HibernateUtil.getSession();
		return session.createQuery(
				"from Reimbursement where authorId = :authorVar and rtId = :statusVar")
				.setInteger("authorVar", id).setInteger("statusVar", 0).list();
	}
	
	public List<Reimbursement> getResolvedReimbursements() {
		Session session = HibernateUtil.getSession();
		return session.createQuery(
				"from Reimbursement where rtId != :statusVar")
				.setInteger("statusVar", 0).list();
	}
	
	public List<Reimbursement> getResolvedByAuthor(int id) {
		Session session = HibernateUtil.getSession();
		return session.createQuery(
				"from Reimbursement where authorId = :authorVar and rtId != :statusVar")
				.setInteger("authorVar", id).setInteger("statusVar", 0).list();
	}

	public Reimbursement getReimbursementById(int id) {
		Session session = HibernateUtil.getSession();
		Reimbursement r = null;
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		reimbursements = session.createQuery(
				"from Reimbursement where id = :idVar")
				.setInteger("idVar", id).list();
		
		if (!reimbursements.isEmpty())
			r = reimbursements.get(0);
		
		return r;
	}
	
	public void saveReimbursement(Reimbursement r) throws FileNotFoundException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();
	}
	
	public void updateReimbursement(Reimbursement r) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(r);
		session.getTransaction().commit();
	}
}
