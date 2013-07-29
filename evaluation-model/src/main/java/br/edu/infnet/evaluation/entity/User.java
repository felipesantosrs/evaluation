/*
 * Copyright (c) 2013 Renan T. Pinzon <rpinzon@gmail.com>
 * 
 * Permission to use, copy, modify, and distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package br.edu.infnet.evaluation.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.edu.infnet.evaluation.enums.UserType;

/**
 * Object that represents an user at database.
 * 
 * @author Renan T. Pinzon
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -4345544894774830850L;

	private Integer id;

	private String name;

	private String email;

	private String password;

	private UserType type;

	private Boolean enabled;

	private Boolean blocked;

	private Integer attempts;

	private Date lastLogin;

	private Set<ClassRoom> classesRoom = new HashSet<ClassRoom>();

	/**
	 * Getter method for id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user")
	public Integer getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter method for name.
	 * 
	 * @return the name
	 */
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for email.
	 * 
	 * @return the email
	 */
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email.
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter method for password.
	 * 
	 * @return the password
	 */
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for password.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method for type.
	 * 
	 * @return the type
	 */
	@Enumerated
	@Column(name = "type")
	public UserType getType() {
		return type;
	}

	/**
	 * Setter method for type.
	 * 
	 * @param type the type to set
	 */
	public void setType(UserType type) {
		this.type = type;
	}

	/**
	 * Getter method for enabled.
	 * 
	 * @return the enabled
	 */
	@Column(name = "enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Setter method for enabled.
	 * 
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Getter method for blocked.
	 * 
	 * @return the blocked
	 */
	@Column(name = "blocked")
	public Boolean getBlocked() {
		return blocked;
	}

	/**
	 * Setter method for blocked.
	 * 
	 * @param blocked the blocked to set
	 */
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	/**
	 * Getter method for attempts.
	 * 
	 * @return the attempts
	 */
	@Column(name = "num_attempt")
	public Integer getAttempts() {
		return attempts;
	}

	/**
	 * Setter method for attempts.
	 * 
	 * @param attempts the attempts to set
	 */
	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	/**
	 * Getter method for lastLogin.
	 * 
	 * @return the lastLogin
	 */
	@Column(name = "last_login")
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * Setter method for lastLogin.
	 * 
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * Getter method for classes.
	 * 
	 * @return the classes room
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_class", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = { @JoinColumn(name = "id_class") })
	public Set<ClassRoom> getClassesRoom() {
		return classesRoom;
	}

	/**
	 * Setter method for classesRoom.
	 * 
	 * @param classesRoom the classesRoom to set
	 */
	public void setClassesRoom(Set<ClassRoom> classesRoom) {
		this.classesRoom = classesRoom;
	}

}
