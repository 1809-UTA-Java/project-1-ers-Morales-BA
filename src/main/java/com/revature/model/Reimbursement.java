package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_REIMBURSEMENTS")
public class Reimbursement {
	@Id
	@Column(name = "R_ID")
	int id;
	
	@Column(name  = "R_AMOUNT")
	int amount;
	
	@Column(name = "R_DESCRIPTION")
	String description;
	
	@Column(name = "R_RECEIPT")
	String receipt;
	
	@Column(name = "R_SUBMITTED")
	Timestamp submitted;
	
	@Column(name = "R_RESOLVED")
	Timestamp resolved;
	
	@Column(name = "U_AUTHOR_ID")
	int authorId;
	
	@Column(name = "U_RESOLVER_ID")
	int resolverId;
	
	@Column(name = "RT_ID")
	int rtId;
	
	@Column(name = "RS_ID")
	int rsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getRtId() {
		return rtId;
	}

	public void setRtId(int rtId) {
		this.rtId = rtId;
	}

	public int getRsId() {
		return rsId;
	}

	public void setRsId(int rsId) {
		this.rsId = rsId;
	}

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int id, int amount, String description, String receipt, Timestamp submitted,
			Timestamp resolved, int authorId, int resolverId, int rtId, int rsId) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.rtId = rtId;
		this.rsId = rsId;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + ", rtId=" + rtId + ", rsId=" + rsId + "]";
	}
}
