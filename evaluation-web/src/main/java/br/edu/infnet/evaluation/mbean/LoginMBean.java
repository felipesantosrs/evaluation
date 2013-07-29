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
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.infnet.evaluation.bean.UserEJBService;
import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.enums.UserType;
import br.edu.infnet.evaluation.util.BeanLocator;
import br.edu.infnet.evaluation.util.Constants;

/**
 * Managed bean that contains all methods to perform login into the system.
 * 
 * @author Renan T. Pinzon
 */
@ManagedBean
@SessionScoped
public class LoginMBean implements Serializable {

	private static final long serialVersionUID = 6396247514151480275L;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginMBean.class);

	UserEJBService userEJBService;

	private User user;

	/**
	 * Default constructor.
	 */
	public LoginMBean() {
		super();
		userEJBService = BeanLocator.lookup(UserEJBService.class);
		// get the current session and invalidate it
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	/**
	 * Getter method for user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		if (user == null) {
			user = new User();
		}
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
	 * Attempt to login in the system.
	 * 
	 * @return the next page if the user logged in successfully or null if not
	 */
	public String login() {
		if (StringUtils.isNotBlank(user.getEmail())) {
			User foundUser = userEJBService.findByEmail(user.getEmail());
			if (foundUser != null && !foundUser.getBlocked()) {
				if (verifyUser(foundUser)) {
					FacesContext facesContext = FacesContext.getCurrentInstance();
					HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
					session.setAttribute("currentUser", foundUser);
					String nextPage = "summary";
					if (foundUser.getType() == UserType.STUDENT) {
						nextPage = "survey";
					}
					return nextPage + "?faces-redirect=true";
				}
			}
		}
		LOGGER.error("Invalid username or password!!");
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid username or password", "Invalid username or password");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return null;
	}

	/**
	 * Perform the user's logout and redirect to the login page.
	 * 
	 * @return the next page
	 */
	public String logout() {
		// get the current session and invalidate it
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";
	}

	/**
	 * Verify if the user is authorized to login in the system.
	 * <p/>
	 * If the password match the user's password the number of attempts is
	 * changed to 0 (zero) regardless the actual number of wrong passwords.
	 * <p/>
	 * If the password does not match the user's password increases the number
	 * of failed attempts and then verify if the number of failed attempts
	 * reached the maximum allowed in the system to block the user.
	 * 
	 * @return true if they match and false if not
	 */
	private boolean verifyUser(User foundUser) {
		boolean result = false;
		if (foundUser.getPassword().equals(user.getPassword())) {
			foundUser.setLastLogin(new Date());
			foundUser.setAttempts(0);
			result = true;
		} else {
			foundUser.setAttempts(foundUser.getAttempts() + 1);
			if (foundUser.getAttempts() >= Constants.MAX_ATTEMPTS_LOGIN) {
				foundUser.setBlocked(true);
			}
		}
		userEJBService.persist(foundUser);
		return result;
	}

}
