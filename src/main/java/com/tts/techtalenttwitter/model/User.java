package com.tts.techtalenttwitter.model;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.springframework.security.core.context.SecurityContextHolder;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int active;

	@CreationTimestamp 
	private Date createdAt;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), 
	    inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles1;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), 
	    inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	public void setRoles1(HashSet<com.tts.techtalenttwitter.model.Role> hashSet) {
		// TODO Auto-generated method stub
			
	}

	public User getLoggedInUser() {
	    String loggedInUsername = SecurityContextHolder.
	      getContext().getAuthentication().getName();
	    
	    return findByUsername(loggedInUsername);
	}

	private User findByUsername(String loggedInUsername) {
		// TODO Auto-generated method stub
		return null;
	}

}