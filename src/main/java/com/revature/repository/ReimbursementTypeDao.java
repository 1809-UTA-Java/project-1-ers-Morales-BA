package com.revature.repository;

import org.hibernate.Session;

import com.revature.model.ReimbursementType;
import com.revature.util.HibernateUtil;

public class ReimbursementTypeDao {
	public String getTypeById(int id) {
		ReimbursementType rt = null;
		Session session = HibernateUtil.getSession();
		
		rt = (ReimbursementType) session.createQuery(
				"from ReimburesmentType where id = :idVar")
				.setInteger("idVar", id);
		
		if(rt != null)
			return rt.getType();
		return null;
	}
}
