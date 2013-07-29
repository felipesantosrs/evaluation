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
package br.edu.infnet.evaluation.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.infnet.evaluation.entity.User;
import br.edu.infnet.evaluation.service.util.BaseServiceImpl;
import br.edu.infnet.evaluation.util.HibernateUtils;

/**
 * Class that implements all methods to handle users.
 * 
 * @author Renan T. Pinzon
 */
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * Default constructor.
	 * 
	 * @param clazz the class of the entity
	 */
	public UserServiceImpl(Class<User> clazz) {
		super(clazz);
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.service.util.BaseServiceImpl#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		try {
			session = HibernateUtils.getSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.addOrder(Order.desc("id"));
			list = criteria.list();
		} catch (Exception e) {
			LOGGER.error("Error retrieving all entities.", e);
		} finally {
			session.close();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.service.UserService#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String email) {
		User entity = null;
		try {
			session = HibernateUtils.getSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.createAlias("classesRoom", "cr", Criteria.LEFT_JOIN);
			criteria.add(Restrictions.eq("email", email));
			criteria.add(Restrictions.eq("enabled", true));
			entity = (User) criteria.uniqueResult();
		} catch (Exception e) {
			LOGGER.error("Error retrieving entity by email. email: " + email, e);
		} finally {
			session.close();
		}
		return entity;
	}

}
