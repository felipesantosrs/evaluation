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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class used to locate beans. This class should be used only in classes where
 * Dependency Injection does not work or is not available.
 * 
 * @author Renan T. Pinzon
 */
public final class BeanLocator {

	private static final Logger LOGGER = LoggerFactory.getLogger(BeanLocator.class);

	/**
	 * To prevent this class from being explicitly instantiated.
	 */
	private BeanLocator() {
		// does nothing
	}

	/**
	 * Retrieve the named object according to {@code clazz} parameter and
	 * returns it casted to this parameter type.
	 * 
	 * @param <T> the type of return
	 * @param clazz the class or interface to cast the looked up object
	 * @return the object bound to {@code clazz} casted to {@code T} 
	 */
	public static <T> T lookup(final Class<T> clazz) {
		final Object bean = lookup(getJNDIName(clazz));
		return clazz.cast(PortableRemoteObject.narrow(bean, clazz));
	}

	/**
	 * Retrieve the named object according to {@code name} parameter.
	 * 
	 * @param name the name of the object to look up
	 * @return the object bound to {@code name}
	 */
	private static Object lookup(final String name) {
		Context context = null;
		try {
			context = new InitialContext();
			return context.lookup(name);
		} catch (NamingException e) {
			LOGGER.error("Error performing lookup. jndiName: " + name, e);
			throw new IllegalStateException("Error performing lookup", e);
		} finally {
			try {
				context.close();
			} catch (NamingException e) {
				LOGGER.error("Error closing context", e);
				// do not throw
			}
		}
	}

	/**
	 * Retrieve the JNDI name according to the received class or interface. If
	 * the {@code clazz} parameter is an interface then append "Bean" to JNDI
	 * name otherwise use only the class name.
	 * 
	 * <pre>
	 * e.g.:
	 *    {@code clazz}: TestService.class
	 *   {@code output}: TestServiceBean/local
	 * 
	 *    {@code clazz}: TestServiceBean.class
	 *   {@code output}: TestServiceBean/local
	 * </pre>
	 * 
	 * @param clazz the class or interface to retrieve JNDI name
	 * @return the JNDI name
	 */
	private static String getJNDIName(final Class<?> clazz) {
		return clazz.getSimpleName() + (clazz.isInterface() ? "Bean/local" : "/local");
	}

}