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
package br.edu.infnet.evaluation.mbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.infnet.evaluation.bean.UserEJBService;
import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.enums.UserType;
import br.edu.infnet.evaluation.util.BeanLocator;

/**
 * Managed bean that contains all methods to handle users.
 * 
 * @author Renan T. Pinzon
 */
@ManagedBean
@SessionScoped
public class UserMBean implements Serializable {

	private static final long serialVersionUID = 8903720058141456007L;

	private User user;

	private List<User> list;

	/**
	 * Default constructor.
	 */
	public UserMBean() {
		super();
		if (user == null) {
			this.user = new User();
			this.user.setEnabled(true);
			this.user.setBlocked(false);
			this.user.setAttempts(0);
		}
	}

	/**
	 * Getter method for user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter method for user.
	 * 
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Returns all user types.
	 * 
	 * @return an array of types of user
	 */
	public UserType[] getUserTypes() {
		return UserType.values();
	}

	/**
	 * Retrieves all users.
	 * 
	 * @return a list containing all users
	 */
	public List<User> getList() {
		UserEJBService userEJBService = BeanLocator.lookup(UserEJBService.class);
		list = userEJBService.findAll();
		return list;
	}

	/**
	 * Stores an user at database.
	 * 
	 * @return a String to forward to the page of to list all users
	 */
	public String persist() {
		UserEJBService userEJBService = BeanLocator.lookup(UserEJBService.class);
		userEJBService.persist(user);
		return "user";
	}

	/**
	 * Stores an user at database.
	 * 
	 * @return a String to forward to the page of to update user
	 */
	public String edit() {
		return "userEdit";
	}

}
