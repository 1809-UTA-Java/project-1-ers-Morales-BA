package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_USERS")
public class User {
	@Id
	@Column(name = "U_ID")
	int id;
	
	@Column(name = "U_USERNAME")
	String username;
	
	@Column(name = "U_PASSWORD")
	String password;
	
	@Column(name = "U_FIRSTNAME")
	String firstname;
	
	@Column(name = "U_LASTNAME")
	String lastname;
	
	@Column(name = "U_EMAIL")
	String email;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "UR_ID")
	UserRoles role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoles getRole() {
		return role;
	}

	public void setRole(UserRoles role) {
		this.role = role;
	}

	public User(int id, String username, String password, String firstname, String lastname, String email,
			UserRoles role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", role=" + role + "]";
	}
	
}
