package com.web.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="C_USER_ROLE")
@Component
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne
    @JoinColumn(name="user_id", updatable = false, insertable = false)
 
	private User userDetails;
	
	

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
    @JoinColumn(name="role_id", updatable = false, insertable = false)
 
	private Role role;
}
	
