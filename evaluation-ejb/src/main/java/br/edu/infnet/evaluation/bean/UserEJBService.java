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
package br.edu.infnet.evaluation.bean;

import java.util.List;

import br.edu.infnet.evaluation.entity.User;

/**
 * Interface that defines all methods to handle users.
 * 
 * @author Renan T. Pinzon
 */
public interface UserEJBService {

	/**
	 * Retrieves all users from database.
	 * 
	 * @return a list containing all users
	 */
	List<User> findAll();

	/**
	 * Persists an user at database.
	 * <p/>
	 * If the user already exists then an update is made, otherwise a new user
	 * will be created.
	 * 
	 * @param user the user to be persisted
	 */
	void persist(User user);

	/**
	 * Retrieves an user according to it email.
	 * 
	 * @param email the email of the user
	 * @return the user
	 */
	User findByEmail(String email);

}
