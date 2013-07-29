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

import java.util.List;

import org.hibernate.Session;

/**
 * Interface that defines basic services for all entities.
 * 
 * @author Renan T. Pinzon
 */
public interface BaseService<T> {

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, assuming that the instance exists. This method might return
	 * a proxied instance that is initialized on-demand, when a non-identifier
	 * method is accessed.
	 * <p/>
	 * You should not use this method to determine if an instance exists (use
	 * <tt>get()</tt> instead). Use this only to retrieve an instance that you
	 * assume exists, where non-existence would be an actual error.
	 * 
	 * @param id a valid identifier of an existing persistent instance of the
	 * class
	 * 
	 * @return the persistent instance or proxy
	 */
	T find(Integer id);

	/**
	 * Retrieves all results for the requested entity.
	 * 
	 * @return the list o matched query results
	 */
	List<T> findAll();

	/**
	 * Either {@link Session#save(Object)} or {@link Session#update(Object)}
	 * the given instance, depending upon resolution of the unsaved-value
	 * checks (see the manual for discussion of unsaved-value checking).
	 * <p/>
	 * This operation cascades to associated instances if the association is
	 * mapped with {@code cascade="save-update"}
	 * 
	 * @param object a transient or detached instance containing new or updated
	 * state
	 * 
	 * @see Session#save(Object object)
	 * @see Session#update(Object object)
	 */
	void persist(T entity);

	/**
	 * Remove a persistent instance from the datastore. The argument may be
	 * an instance associated with the receiving <tt>Session</tt> or a
	 * transient instance with an identifier associated with existing
	 * persistent state.
	 * <p/>
	 * This operation cascades to associated instances if the association is
	 * mapped with {@code cascade="delete"}
	 * 
	 * @param object the instance to be removed
	 */
	void delete(T entity);

}
