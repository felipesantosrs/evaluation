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
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.infnet.evaluation.dto.SurveyDTO;
import br.edu.infnet.evaluation.entity.Question;
import br.edu.infnet.evaluation.entity.Survey;

/**
 * Managed bean that contains all methods to handle data related to questions.
 * 
 * @author Renan T. Pinzon
 */
@ManagedBean
@SessionScoped
public class QuestionMBean implements Serializable {

	private static final long serialVersionUID = -2962119691421460838L;

	public Survey survey;

	public SurveyDTO surveyDTO;

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
	 * Retrieves all questions.
	 * 
	 * @return a list containing all questions
	 */
	public List<Question> getList() {
		return getSurveyDTO().getQuestions();
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

}
