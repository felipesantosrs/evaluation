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
package br.edu.infnet.evaluation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.edu.infnet.evaluation.enums.AnswerValue;

/**
 * Object that represents an answer at database.
 * 
 * @author Renan T. Pinzon
 */
@Entity
@Table(name = "answer")
public class Answer implements Serializable {

	private static final long serialVersionUID = 2164150487733669154L;

	private AnswerPk id;

	private AnswerValue answerValue;

	/**
	 * Getter method for id.
	 * 
	 * @return the id
	 */
	@EmbeddedId
	public AnswerPk getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 * 
	 * @param id the id to set
	 */
	public void setId(AnswerPk id) {
		this.id = id;
	}

	/**
	 * Getter method for answerValue.
	 * 
	 * @return the answerValue
	 */
	@Enumerated
	@Column(name = "value")
	public AnswerValue getAnswerValue() {
		return answerValue;
	}

	/**
	 * Setter method for answerValue.
	 * 
	 * @param answerValue the answerValue to set
	 */
	public void setAnswerValue(AnswerValue answerValue) {
		this.answerValue = answerValue;
	}

}
