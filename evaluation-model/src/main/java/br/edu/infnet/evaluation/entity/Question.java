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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.edu.infnet.evaluation.enums.AnswerValue;

/**
 * Object that represents a question at database.
 * 
 * @author Renan T. Pinzon
 */
@Entity
@Table(name = "question")
public class Question implements Serializable {

	private static final long serialVersionUID = -1151887407592493548L;

	private Integer id;

	private String description;

	private Boolean enabled;

	private Set<Survey> surveys = new HashSet<Survey>();

	private transient AnswerValue answerValue;

	/**
	 * Getter method for id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_question")
	public Integer getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter method for description.
	 * 
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * Setter method for description.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter method for enabled.
	 * 
	 * @return the enabled
	 */
	@Column(name = "enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Setter method for enabled.
	 * 
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Getter method for surveys.
	 * 
	 * @return the surveys
	 */
	@ManyToMany(mappedBy = "questions")
	public Set<Survey> getSurveys() {
		return surveys;
	}

	/**
	 * Setter method for surveys.
	 * 
	 * @param surveys the surveys to set
	 */
	public void setSurveys(Set<Survey> surveys) {
		this.surveys = surveys;
	}

	/**
	 * Getter method for answerValue.
	 * 
	 * @return the answerValue
	 */
	@Transient
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
