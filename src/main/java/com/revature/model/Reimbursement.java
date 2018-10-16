package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_REIMBURSEMENTS")
public class Reimbursement {
	@Id
	@Column(name = "R_ID")
	int id;

	@Column(name = "R_AMOUNT")
	int amount;
	
	@Column(name = "R_DESCRIPTION")
	String description;
	
	@Column(name = "R_RECEIPT")
	String receipt;
	
	@Column(name = "R_SUBMITTED")
	String submitted;
	
	@Column(name = "R_RESOLVED")
	String resolved;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "U_ID")
	User authorId;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "U_ID")
	User resolverId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "RT_ID")
	ReimbursementType rtId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "RT_STATUS")
	ReimbursementStatus rsId;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int id, int amount, String description, String receipt, String submitted, String resolved,
			User authorId, User resolverId, ReimbursementType rtId, ReimbursementStatus rsId) {
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

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public User getAuthorId() {
		return authorId;
	}

	public void setAuthorId(User authorId) {
		this.authorId = authorId;
	}

	public User getResolverId() {
		return resolverId;
	}

	public void setResolverId(User resolverId) {
		this.resolverId = resolverId;
	}

	public ReimbursementType getRtId() {
		return rtId;
	}

	public void setRtId(ReimbursementType rtId) {
		this.rtId = rtId;
	}

	public ReimbursementStatus getRsId() {
		return rsId;
	}

	public void setRsId(ReimbursementStatus rsId) {
		this.rsId = rsId;
	}
	
}
