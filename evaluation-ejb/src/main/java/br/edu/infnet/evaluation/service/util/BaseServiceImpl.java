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
package br.edu.infnet.evaluation.service.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.infnet.evaluation.util.HibernateUtils;

/**
 * Class that implements all basic services for all entities.
 * 
 * @author Renan T. Pinzon
 */
public class BaseServiceImpl<T> implements BaseService<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

	protected Session session;

	private final Class<T> clazz;

	/**
	 * Default constructor.
	 * 
	 * @param clazz the class of the entity
	 */
	public BaseServiceImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.service.util.BaseService#find(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T find(Integer id) {
		T entity = null;
		try {
			session = HibernateUtils.getSession();
			entity = (T) session.get(this.clazz, id);
		} catch (Exception e) {
			LOGGER.error("Error retrieving entity by identifier. id: " + id, e);
		} finally {
			session.close();
		}
		return entity;
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.service.util.BaseService#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> list = new ArrayList<T>();
		try {
			session = HibernateUtils.getSession();
			list = session.createCriteria(this.clazz).list();
		} catch (Exception e) {
			LOGGER.error("Error retrieving all entities.", e);
		} finally {
			session.close();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.service.util.BaseService#persist(java.lang.Object)
	 */
	@Override
	public void persist(T entity) {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error("Error persisting entity.", e);
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see br.edu.infnet.evaluation.service.util.BaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error("Error deleting entity.", e);
		} finally {
			session.close();
		}
	}

}
