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

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.service.UserService;
import br.edu.infnet.evaluation.service.UserServiceImpl;

/**
 * Class that contains all methods to handle users.
 * 
 * @author Renan T. Pinzon
 */
@Stateless
@Local(UserEJBService.class)
public class UserEJBServiceBean implements UserEJBService {

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.bean.UserEJBService#findAll()
	 */
	@Override
	public List<User> findAll() {
		UserService userService = new UserServiceImpl(User.class);
		return userService.findAll();
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.bean.UserEJBService#persist(br.edu.infnet.evaluation.entity.User)
	 */
	@Override
	public void persist(User user) {
		UserService userService = new UserServiceImpl(User.class);
		userService.persist(user);
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.bean.UserEJBService#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String email) {
		UserService userService = new UserServiceImpl(User.class);
		return userService.findByEmail(email);
	}

}
