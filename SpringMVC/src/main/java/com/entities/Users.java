package com.entities;
/**
 * Implementation of Hibernate for converting Data from DB in to Objects  
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a table called users from the Database.
 */
@Entity
@Table(name="users")
public class Users {
	/**
	 * Represents a ID auto generated field from the table.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer user_id;

	/**
	 * Represents a user_name field from the table.
	 */
	@Column(name="user_name")
	private String user_name;
	
	/**
	 * Represents a email field from the table.
	 */
	@Column(name="email")
	private String email;
	
	/**
	 * Get method for user_id
	 */
	public Integer getUser_id() {
		return user_id;
	}

	/**
	 * Set method for user_id
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	/**
	 * Get method for user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	
	/**
	 * Set method for user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	/**
	 * Get method for email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set method for email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
