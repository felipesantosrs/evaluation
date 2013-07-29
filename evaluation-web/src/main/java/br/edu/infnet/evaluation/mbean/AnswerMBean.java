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
package br.edu.infnet.evaluation.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.infnet.evaluation.bean.AnswerEJBService;
import br.edu.infnet.evaluation.dto.SurveyDTO;
import br.edu.infnet.evaluation.entity.Answer;
import br.edu.infnet.evaluation.entity.AnswerPk;
import br.edu.infnet.evaluation.entity.Question;
import br.edu.infnet.evaluation.enums.AnswerValue;
import br.edu.infnet.evaluation.util.BeanLocator;

/**
 * Managed bean that contains all methods to handle data related to answers.
 * 
 * @author Renan T. Pinzon
 */
@ManagedBean
@ViewScoped
public class AnswerMBean implements Serializable {

	private static final long serialVersionUID = 5337732330428897526L;

	private SurveyDTO surveyDTO;

	/**
	 * Getter method for surveyDTO.
	 * 
	 * @return the surveyDTO
	 */
	public SurveyDTO getSurveyDTO() {
		return surveyDTO;
	}

	/**
	 * Setter method for surveyDTO.
	 * 
	 * @param surveyDTO the surveyDTO to set
	 */
	public void setSurveyDTO(SurveyDTO surveyDTO) {
		this.surveyDTO = surveyDTO;
	}

	/**
	 * Return all possible answers.
	 * 
	 * @return a list of possible answer s
	 */
	public AnswerValue[] getAnswerValues() {
		return AnswerValue.values();
	}

	public String cancel() {
		return "survey";
	}

	public String persist() {
		AnswerEJBService answerEJBService = BeanLocator.lookup(AnswerEJBService.class);
		for (Question question : surveyDTO.getQuestions()) {
			AnswerPk pk = new AnswerPk();
			pk.setSurvey(surveyDTO.getSurvey());
			pk.setClassRoom(surveyDTO.getClassRoom());
			pk.setUser(surveyDTO.getUser());
			pk.setQuestion(question);
			Answer answer = new Answer();
			answer.setId(pk);
			answer.setAnswerValue(question.getAnswerValue());
			answerEJBService.persist(answer);
		}
		return "survey";
	}

}
