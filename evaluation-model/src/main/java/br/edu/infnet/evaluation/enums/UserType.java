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
package br.edu.infnet.evaluation.enums;

/**
 * Enumeration that represents all types of user.
 * 
 * @author Renan T. Pinzon
 */
public enum UserType {

	ADMINISTRATOR("Administrador"), TEACHER("Professor"), STUDENT("Aluno");

	private String value;

	/**
	 * Internal constructor.
	 * 
	 * @param value the value of the enumeration
	 */
	private UserType(String value) {
		this.value = value;
	}

	/**
	 * Getter method for value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
