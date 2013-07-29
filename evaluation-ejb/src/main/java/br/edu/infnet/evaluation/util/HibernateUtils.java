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
package br.edu.infnet.evaluation.util;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.LoggerFactory;

/**
 * Helper class that takes care of startup and makes accessing the
 * {@code SessionFactory} more convenient.
 * 
 * @author Renan T. Pinzon
 */
public final class HibernateUtils {

	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = getSessionFactory();
		} catch (Throwable e) {
			LoggerFactory.getLogger(HibernateUtils.class).error("Initial SessionFactory creation failed.", e);
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * To prevent this class from being instantiated.
	 */
	private HibernateUtils() {
		// does nothing
	}

	/**
	 * Creates a {@code SessionFactory} if no one exists and returns it with a
	 * {@link Session} already opened.
	 * 
	 * @return a {@code SessionFactory} with the session already opened
	 */
	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			sessionFactory = configuration.buildSessionFactory();
			sessionFactory.openSession();
		}
		return sessionFactory;
	}

	/**
	 * Open a {@link Session}.
	 * <p/>
	 * JDBC {@link Connection connection(s} will be obtained from the
	 * configured {@link org.hibernate.service.jdbc.connections.spi.ConnectionProvider}
	 * as needed to perform requested work.
	 * 
	 * @return the created session
	 */
	public static Session getSession() {
		/*
		 * If a HibernateException is thrown then it indicates a problem
		 * opening the session; pretty rare here
		 */
		return sessionFactory.openSession();
	}

}
