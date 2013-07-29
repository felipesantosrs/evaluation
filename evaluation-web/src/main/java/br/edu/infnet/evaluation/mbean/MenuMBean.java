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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Managed bean that contains all methods to navigate from any menu to a page.
 * 
 * @author Renan T. Pinzon
 */
@ManagedBean
@SessionScoped
public class MenuMBean implements Serializable {

	private static final long serialVersionUID = -1839284265892305194L;

	/**
	 * Returns the String to navigate to user's CRUD.
	 * 
	 * @return the String to navigate to user's CRUD
	 */
	public String listUser() {
		return "user?faces-redirect=true";
	}

	/**
	 * Returns the String to navigate to user's CRUD.
	 * 
	 * @return the String to navigate to user's CRUD
	 */
	public String newUser() {
		return "userNew?faces-redirect=true";
	}

}
