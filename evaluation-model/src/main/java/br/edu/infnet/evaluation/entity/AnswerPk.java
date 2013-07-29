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

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Object that represents the primary key of an answer.
 * 
 * @author Renan T. Pinzon
 */
@Embeddable
public class AnswerPk implements Serializable {

	private static final long serialVersionUID = 2036333258367000397L;

	private Survey survey;

	private ClassRoom classRoom;

	private User user;

	private Question question;

	/**
	 * Getter method for survey.
	 * 
	 * @return the survey
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_survey")
	public Survey getSurvey() {
		return survey;
	}

	/**
	 * Setter method for survey.
	 * 
	 * @param survey the survey to set
	 */
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	/**
	 * Getter method for classRoom.
	 * 
	 * @return the class room
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_class")
	public ClassRoom getClassRoom() {
		return classRoom;
	}

	/**
	 * Setter method for classRoom.
	 * 
	 * @param classRoom the classRoom to set
	 */
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	/**
	 * Getter method for user.
	 * 
	 * @return the user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	public User getUser() {
		return user;
	}

	/**
	 * Setter method for user.
	 * 
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Getter method for question.
	 * 
	 * @return the question
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question")
	public Question getQuestion() {
		return question;
	}

	/**
	 * Setter method for question.
	 * 
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

}
