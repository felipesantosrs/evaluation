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
package br.edu.infnet.evaluation.dto;

import java.util.List;

import br.edu.infnet.evaluation.entity.ClassRoom;
import br.edu.infnet.evaluation.entity.Question;
import br.edu.infnet.evaluation.entity.Survey;
import br.edu.infnet.evaluation.entity.User;

/**
 * Object that represents a survey grouped by the survey, class room and the
 * user who is answering it. It also have attributes that define if this survey
 * is opened, closed or if it was already answered.
 * 
 * @author Renan T. Pinzon
 */
public class SurveyDTO {

	private Survey survey;

	private ClassRoom classRoom;

	private User user;

	private Boolean opened;

	private Boolean closed;

	private Boolean answered;

	private List<Question> questions;

	/**
	 * Getter method for survey.
	 * 
	 * @return the survey
	 */
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
	 * @return the classRoom
	 */
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
	 * Getter method for opened.
	 * 
	 * @return the opened
	 */
	public Boolean getOpened() {
		return opened;
	}

	/**
	 * Setter method for opened.
	 * 
	 * @param opened the opened to set
	 */
	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	/**
	 * Getter method for closed.
	 * 
	 * @return the closed
	 */
	public Boolean getClosed() {
		return closed;
	}

	/**
	 * Setter method for closed.
	 * 
	 * @param closed the closed to set
	 */
	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	/**
	 * Getter method for answered.
	 * 
	 * @return the answered
	 */
	public Boolean getAnswered() {
		return answered;
	}

	/**
	 * Setter method for answered.
	 * 
	 * @param answered the answered to set
	 */
	public void setAnswered(Boolean answered) {
		this.answered = answered;
	}

	/**
	 * Getter method for questions.
	 * 
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * Setter method for questions.
	 * 
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
